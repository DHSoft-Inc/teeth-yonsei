// treatment.js — naming 통일판 (모든 입력을 treatment로 취급)

class addTreatment {
  constructor({ treatmentDate = '', selectedTeeth = '', selectedTreatment = '-', mainCategory = '', userId = '', authToken = '' }) {
    this.treatmentDate = treatmentDate;
    this.selectedTeeth = selectedTeeth;
    this.selectedTreatment = selectedTreatment;
    this.mainCategory = mainCategory;
    this.userId = userId;
    this.authToken = authToken;
  }
  toFormData() {
    return new URLSearchParams({
      treatmentDate: this.treatmentDate,
      selectedTeeth: this.selectedTeeth,
      selectedTreatment: this.selectedTreatment,
      mainCategory: this.mainCategory,
      EditUserId: this.userId,
      p_auth: this.authToken
    });
  }
}

// 임시 저장 객체
class Treatment {
  constructor({ treatmentDate, selectedTeeth, selectedTreatment = '-', mainCategory = '', userId, authToken }) {
    this.treatmentDate = treatmentDate;
    this.selectedTeeth = selectedTeeth;
    this.selectedTreatment = selectedTreatment;
    this.mainCategory = mainCategory;
    this.userId = userId;
    this.authToken = authToken;

    // UI 복원용: {name, value} 쌍 저장
    this._pairs = [];
  }
  isEqual(other) {
    return (
      this.treatmentDate === other.treatmentDate &&
      this.selectedTeeth === other.selectedTeeth &&
      this.selectedTreatment === other.selectedTreatment
    );
  }
}

document.addEventListener('DOMContentLoaded', () => {
  const pendingTreatments = [];

  // 치식 파싱
  const teethsParam = (window.INITIAL_TEETHS || '').trim();
  const passedTeethNames = teethsParam
    .split(',')
    .map(num => num.trim().startsWith('Teeth') ? num.trim() : 'Teeth' + num.trim())
    .filter(name => name !== 'Teeth' && name !== '');

  // DOM
  const imageWrapper = document.getElementById('imageWrapper'); if (imageWrapper) imageWrapper.style.display = 'none';
  const jointNumLabel = document.getElementById('jointNumLabel');
  const selectedButtonsLabel = document.getElementById('selectedButtonsLabel');
  const selectedButtonsLabel2 = document.getElementById('selectedButtonsLabel2');
  const historyContainer = document.getElementById('historyContainer');
  const patientImage = document.getElementById('patientImage');
  const treatmentDateInput = document.getElementById('treatmentDate');
  const deleteAllBtn = document.getElementById('deleteAllBtn');
  const addBtn = document.getElementById('addTreatmentBtn');
  const addDBBtn = document.getElementById('addDBBtn');
  const cancelBtn = document.getElementById('cancelBtn');

  // 모든 treatment 그룹을 한 곳에서 관리 (체크박스/라디오 혼재)
  const TREATMENT_GROUP_NAMES = [
    'treatment_proc[]',            // 기존 status → 통일
    'treatment_symptom[]',
    'treatment_occlusion',         // radio
    'treatment_caries_surface[]',
    'treatment_caries_depth',      // radio
    'treatment_caries_level',      // radio
    'treatment_hard_tissue[]',
    'treatment_lesion[]',
    'treatment_fracture_single',   // radio
    'treatment_fracture_multi[]',
    'treatment_visible_crack[]',
    'treatment_crack_level',       // radio
    'treatment_material[]',
    'treatment_cusp_capping[]',
    'treatment_gingival_level',    // radio
    'treatment_perio[]',
    'treatment_quality[]',
    'treatment_pocket_depth[]'
  ];
  const TREATMENT_SELECTOR = TREATMENT_GROUP_NAMES.map(n => `input[name="${n}"]`).join(',');
  const treatmentInputs = Array.from(document.querySelectorAll(TREATMENT_SELECTOR));

  // 라디오 재클릭 해제 허용 그룹
  const RADIO_NAMES = [
    'treatment_occlusion',
    'treatment_caries_depth',
    'treatment_caries_level',
    'treatment_fracture_single',
    'treatment_crack_level',
    'treatment_gingival_level'
  ];
  const lastCheckedByName = {};
  document.querySelectorAll(RADIO_NAMES.map(n => `input[name="${n}"]`).join(',')).forEach(radio => {
    radio.addEventListener('click', function () {
      const nm = this.name;
      if (lastCheckedByName[nm] === this) { this.checked = false; lastCheckedByName[nm] = null; }
      else { lastCheckedByName[nm] = this; }
      checkIfCanEnableAddButton();
    });
  });

  // 날짜 최대값
  treatmentDateInput.max = new Date().toISOString().split("T")[0];

  // regions(필요시 유지)
  const regions = [ /* 기존 regions 좌표 배열 복사 */ ];
  regions.forEach(r => r.isClicked = passedTeethNames.includes(r.name));
  regions.forEach(region => {
    const div = document.createElement('div');
    div.classList.add('region'); div.dataset.name = region.name;
    imageWrapper && imageWrapper.appendChild(div);
  });
  if (patientImage && patientImage.complete) drawRegions();
  else if (patientImage) patientImage.addEventListener('load', drawRegions);
  window.addEventListener('resize', drawRegions);

  // 버튼 활성화: 날짜 + (어떤 treatment라도 1개 이상)
  function anyTreatmentSelected() {
    return document.querySelectorAll(TREATMENT_GROUP_NAMES.map(n => `input[name="${n}"]:checked`).join(',')).length > 0;
  }
  function checkIfCanEnableAddButton() {
    addBtn.disabled = !(treatmentDateInput.value && anyTreatmentSelected());
  }
  treatmentInputs.forEach(i => i.addEventListener('change', checkIfCanEnableAddButton));
  treatmentDateInput.addEventListener('change', checkIfCanEnableAddButton);

  // 전체 해제
  document.getElementById('clearSelectionsBtn').addEventListener('click', () => {
    document.querySelectorAll('input[type="checkbox"], input[type="radio"]').forEach(el => el.checked = false);
    Object.keys(lastCheckedByName).forEach(k => lastCheckedByName[k] = null);
    checkIfCanEnableAddButton();
  });

  // 전체 삭제
  deleteAllBtn.addEventListener('click', () => {
    pendingTreatments.length = 0;
    const tbody = document.querySelector('#treatmentTable tbody');
    if (tbody) tbody.innerHTML = '';
  });

  // cancel
  cancelBtn.addEventListener('click', () => {
    Liferay.Util.getOpener().closeDialog('addTreatmentDialog');
  });

  // 선택 수집
  const esc = (v) => (window.CSS && CSS.escape) ? CSS.escape(v) : String(v).replace(/["\\]/g, '\\$&');
  function collectTreatmentSelections() {
    const pairs = []; // {name, value}
    const values = [];
    TREATMENT_GROUP_NAMES.forEach(name => {
      const checked = Array.from(document.querySelectorAll(`input[name="${name}"]:checked`));
      checked.forEach(el => { pairs.push({ name, value: el.value }); values.push(el.value); });
    });
    return { pairs, values };
  }

  // Add Record
  addBtn.addEventListener('click', () => {
    const { pairs, values } = collectTreatmentSelections();
    const selectedTreatment = values.join(', ');
    const treatmentDateStr = (treatmentDateInput.value ? new Date(treatmentDateInput.value) : new Date())
                              .toISOString().split('T')[0];

    // 중복 날짜 제거
    for (let i = pendingTreatments.length - 1; i >= 0; i--) {
      if (pendingTreatments[i].treatmentDate === treatmentDateStr) pendingTreatments.splice(i, 1);
    }
    const tbody = document.querySelector('#treatmentTable tbody');
    if (tbody) {
      Array.from(tbody.querySelectorAll('tr')).forEach(row => {
        if (row.cells[0] && row.cells[0].textContent.trim() === treatmentDateStr) row.remove();
      });
    }

    // teeth별 임시 저장
    teethsParam.split(',').map(t => t.trim()).forEach(tooth => {
      const t = new Treatment({
        treatmentDate: treatmentDateStr,
        selectedTeeth: tooth,
        selectedTreatment,
        mainCategory: '',
        userId: Liferay.ThemeDisplay.getUserId(),
        authToken: Liferay.authToken
      });
      t._pairs = pairs.slice();
      pendingTreatments.push(t);
    });

    // 테이블 렌더
    const tr = document.createElement('tr');
    tr.dataset.treatmentDate = treatmentDateStr;
    tr.appendChild(tdLink(treatmentDateStr));
    tr.appendChild(tdText(teethsParam.split(',').map(x=>x.trim().replace('Teeth','')).join(', ')));
    tr.appendChild(tdText(selectedTreatment || '-'));     // 상태/치료 통합 표시
    tr.appendChild(tdText('-'));                          // (구)Treatment 칼럼 유지시: 필요없으면 제거
    const tdBtn = tdText('');
    tdBtn.style.textAlign = 'center';
    tdBtn.innerHTML = `<button type="button" class="clear-btn">delete</button>`;
    tr.appendChild(tdBtn);
    (document.querySelector('#treatmentTable tbody') || tbody).appendChild(tr);

    tr.querySelector('.clear-btn').addEventListener('click', (e) => {
      const date = e.target.closest('tr').dataset.treatmentDate;
      document.querySelectorAll('#treatmentTable tbody tr').forEach(row => {
        if (row.dataset.treatmentDate === date) row.remove();
      });
      for (let i = pendingTreatments.length - 1; i >= 0; i--) {
        if (pendingTreatments[i].treatmentDate === date) pendingTreatments.splice(i, 1);
      }
    });

    // 입력 리셋
    treatmentInputs.forEach(i => i.checked = false);
    Object.keys(lastCheckedByName).forEach(k => lastCheckedByName[k] = null);
    addBtn.disabled = true;
    drawRegions();

    function tdText(t){ const td=document.createElement('td'); td.style.border='1px solid #ccc'; td.style.padding='6px'; td.textContent=t; return td; }
    function tdLink(t){ const td=tdText(t); td.style.cursor='pointer'; td.style.color='blue'; td.style.textDecoration='underline';
      td.addEventListener('click',()=>{treatmentDateInput.value=t; treatmentDateInput.dispatchEvent(new Event('change'));}); return td; }
  });

  // Save → DB (selectedTreatment만 전송, selectedState 제거)
  addDBBtn.addEventListener('click', () => {
    const combined = groupAndCombineTreatments(pendingTreatments);
    const treatmentsData = combined.map((str) => {
      const decoded = decodeURIComponent(str);
      const obj = {};
      decoded.split("&").forEach(pair => {
        const [k, v] = pair.split("=");
        if (k && v !== undefined) obj[k] = v;
      });
      return obj;
    });

    $.ajax({
      type: 'POST',
      url: new URL(resourceURL),
      data: JSON.stringify({ treatments: treatmentsData }),
      contentType: 'application/json; charset=UTF-8',
      success: function (response) {
        pendingTreatments.length = 0;
        Liferay.Util.getOpener().location.reload();
        Liferay.Util.getOpener().closeDialog('addTreatmentDialog');
      },
      error: function (xhr, status, error) { console.error("AJAX 실패:", error); }
    });
  });

  // 같은 날짜/치아 묶어서 직렬화
  function groupAndCombineTreatments(list) {
    const grouped = {};
    list.forEach(t => {
      const key = `${t.treatmentDate}|${t.selectedTeeth}`;
      if (!grouped[key]) {
        grouped[key] = {
          treatmentDate: t.treatmentDate,
          selectedTeeth: t.selectedTeeth,
          values: new Set(),
          mainCategory: t.mainCategory,
          userId: t.userId,
          authToken: t.authToken
        };
      }
      if (t.selectedTreatment && t.selectedTreatment !== '-') grouped[key].values.add(t.selectedTreatment);
    });

    return Object.values(grouped).map(g => {
      const params = new URLSearchParams();
      params.set('EditUserId', g.userId);
      params.set('treatmentDate', g.treatmentDate);
      params.set('mainCategory', g.mainCategory);
      params.set('selectedTeeth', g.selectedTeeth);
      params.set('selectedTreatment', [...g.values].join(',').replace(/\s+/g, '') || '-');
      params.set('p_auth', g.authToken);
      return params.toString();
    });
  }

  // 이력/시각화(기존 유지)
  function updateHistoryDisplay() {
    if (!historyContainer) return;
    historyContainer.innerHTML = '';
    regions.filter(r => r.isClicked).forEach(region => {
      const entries = [...region.history].sort((a, b) => b.visit_date - a.visit_date);
      const header = document.createElement('h4'); header.textContent = region.name;
      historyContainer.appendChild(header);
      const ul = document.createElement('ul');
      entries.forEach(e => { const li = document.createElement('li'); li.textContent = `${e.visit_date.toLocaleDateString()} - ${e.status}`; ul.appendChild(li); });
      historyContainer.appendChild(ul);
    });
  }

  function drawRegions() {
    if (!patientImage) return;
    const scaleX = patientImage.clientWidth / patientImage.naturalWidth;
    const scaleY = patientImage.clientHeight / patientImage.naturalHeight;
    regions.forEach(region => {
      const div = document.querySelector(`.region[data-name="${region.name}"]`);
      if (!div) return;
      const left = region.x1 * scaleX, top = region.y1 * scaleY;
      const w = (region.x2 - region.x1) * scaleX, h = (region.y2 - region.y1) * scaleY;
      Object.assign(div.style, { left: `${left}px`, top: `${top}px`, width: `${w}px`, height: `${h}px` });
      div.style.backgroundColor = region.isClicked ? 'red' : (region.history.length ? 'orange' : 'white');
    });
    jointNumLabel.textContent = passedTeethNames.length;
    const nums = passedTeethNames.map(n => n.replace('Teeth',''));
    selectedButtonsLabel.textContent = nums.join(', ');
    selectedButtonsLabel2.textContent = nums.join(', ');
    updateHistoryDisplay();
  }

  // 날짜 변경 → pending 값 복원
  treatmentDateInput.addEventListener('change', () => {
    // 전체 해제
    document.querySelectorAll(TREATMENT_SELECTOR).forEach(i => i.checked = false);
    Object.keys(lastCheckedByName).forEach(k => lastCheckedByName[k] = null);

    const dateStr = treatmentDateInput.value;
    const matchedPending = pendingTreatments.filter(item => item.treatmentDate === dateStr);

    matchedPending.forEach(item => {
      // 그룹-값 쌍 기반 복원
      if (Array.isArray(item._pairs)) {
        item._pairs.forEach(({ name, value }) => {
          const el = document.querySelector(`input[name="${name}"][value="${esc(value)}"]`);
          if (el) el.checked = true;
        });
      } else if (item.selectedTreatment) {
        // 폴백
        item.selectedTreatment.split(',').forEach(v => {
          const el = document.querySelector(`${TREATMENT_SELECTOR}[value="${esc(v.trim())}"]`);
          if (el) el.checked = true;
        });
      }
    });

    checkIfCanEnableAddButton();
  });
});
