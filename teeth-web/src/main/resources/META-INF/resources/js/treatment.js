// treatment.js


class PendingTreatment {
  constructor({
    treatmentDate = '',
    selectedTeeth = '',
    selectedTreatment = '-',
    selectedState = '-',
    mainCategory = '',
    userId = '',
    authToken = ''
  }) {
    this.treatmentDate = treatmentDate;
    this.selectedTeeth = selectedTeeth;
    this.selectedTreatment = selectedTreatment;
    this.selectedState = selectedState;
    this.mainCategory = mainCategory;
    this.userId = userId;
    this.authToken = authToken;
  }

  toFormData() {
    return new URLSearchParams({
      treatmentDate: this.treatmentDate,
      selectedTeeth: this.selectedTeeth,
      selectedTreatment: this.selectedTreatment,
      selectedState: this.selectedState,
      mainCategory: this.mainCategory,
      EditUserId: this.userId,
      p_auth: this.authToken
    });
  }
}



document.addEventListener('DOMContentLoaded', () => {


	
	//임시 저장용 배열(add Record 버튼 입력시  save 직전에 저장되는)
  
	
	const pendingTreatments = []; 
  
  
  
  
  
  
  //받아온 선택된 치식
  const teethsParam = (window.INITIAL_TEETHS || '').trim(); 
  const passedTeethNames = teethsParam 
  .split(',')
  .map(num => num.trim().startsWith('Teeth') ? num.trim() : 'Teeth' + num.trim())
  .filter(name => name !== 'Teeth' && name !== ''); // 해당 치식을 분리하고 Teeth13 같은 형태로 만드는 코드

  const imageWrapper = document.getElementById('imageWrapper');
  if (imageWrapper) {
    imageWrapper.style.display = 'none';
  } // 숨길 이미지가 있으면 숨기는 용도

  const jointNumLabel = document.getElementById('jointNumLabel');
  const selectedButtonsLabel = document.getElementById('selectedButtonsLabel');
  
  const historyContainer = document.getElementById('historyContainer');
  const patientImage = document.getElementById('patientImage');
  const treatmentDateInput = document.getElementById('treatmentDate');
  
  const addBtn = document.getElementById('addTreatmentBtn');  
  const addDBBtn = document.getElementById('addDBBtn');
  const cancelBtn = document.getElementById('cancelBtn');
  const dateInput = document.getElementById('treatmentDate');
  
  const statusRadios = Array.from(document.querySelectorAll('input[name="status"]'));
  const permanentCRadios = Array.from(document.querySelectorAll('input[name="permanentC"]'));
  const permanentDDRadios = Array.from(document.querySelectorAll('input[name="permanentDD"]'));
  
  //나머지 버튼들에 대해 jsp의 버튼 이름과 연결

  
  function checkIfCanEnableAddButton() {
	  const isStatusSelected = [...statusRadios].some(input => input.checked);
	  const isPermanentCSelected = [...permanentCRadios].some(input => input.checked);
	  const isPermanentDDSelected = [...permanentDDRadios].some(input => input.checked);
	  const isDateSelected = dateInput.value !== "";

	  if ((isStatusSelected || isPermanentCSelected || isPermanentDDSelected)) {
	    addBtn.disabled = false;
	  } else {
	    addBtn.disabled = true;
	  }
	}
  
  
  
  let jointNum = passedTeethNames.length;

  const regions = [ /* 기존 regions 좌표 배열 복사 */ ];


  regions.forEach(r => {
    r.isClicked = passedTeethNames.includes(r.name);
  }); //region에 대해 클릭되었다는 정보 복사

  regions.forEach(region => {
    const div = document.createElement('div');
    div.classList.add('region');
    div.dataset.name = region.name;
    imageWrapper && imageWrapper.appendChild(div);
  }); 
  
  // 초기 렌더링
  if (patientImage.complete) {
    drawRegions();
  } else {
    patientImage.addEventListener('load', drawRegions);
  }
  window.addEventListener('resize', drawRegions);
  
  
  
//이벤트 연결
  [...statusRadios, ...permanentCRadios, ...permanentDDRadios].forEach(radio => {
    radio.addEventListener('change', checkIfCanEnableAddButton);
  });

  dateInput.addEventListener('change', checkIfCanEnableAddButton);
  
	
	
	let lastChecked = null;

	  document.querySelectorAll('input[name="permanentC"]').forEach((radio) => {
	    radio.addEventListener('click', function () {
	      if (this === lastChecked) {
	        this.checked = false;
	        checkIfCanEnableAddButton();
	        lastChecked = null;
	      } else {
	        lastChecked = this;
	        checkIfCanEnableAddButton();
	      }
	    });
	  });
	  
	  
	  document.getElementById('clearSelectionsBtn').addEventListener('click', function () {
		    // 모든 체크박스 해제
		    document.querySelectorAll('input[type="checkbox"]').forEach((checkbox) => {
		      checkbox.checked = false;
		    });

		    // 모든 라디오버튼 해제
		    document.querySelectorAll('input[type="radio"]').forEach((radio) => {
		      radio.checked = false;
		    });

		    // 이전 라디오 클릭 기억 초기화 (선택 해제 가능 기능 사용하는 경우)
		    if (typeof lastChecked !== 'undefined') {
		      lastChecked = null;
		    }
		    
		    checkIfCanEnableAddButton();
		  });
  
	
	
  
    // 취소하고 창 닫기
  	cancelBtn.addEventListener('click', () => {
	  	  console.log('Cancel 버튼 클릭됨');
	  	  console.log('Opener:', Liferay.Util.getOpener());
  		Liferay.Util.getOpener().closeDialog('addTreatmentDialog');
  	});
	
	
	
  	addBtn.addEventListener('click', () => {
  		
    	  //C는 radioButton, D는 selectbox
    	  const selectedStateC = (permanentCRadios.find(r => r.checked) || {}).value || '';

    	  const selectedStateDDArr = Array.from( 
    	    document.querySelectorAll('input[name="permanentDD"]:checked')
    	  ).map(cb => cb.value);
    	  

    	  let treatmentDate = treatmentDateInput.value ? new Date(treatmentDateInput.value) : new Date();

    	  //C랑 D에서 받은거 합치기
    	  const selectedStateArr = [
    	    selectedStateC,
    	    ...selectedStateDDArr
    	  ].filter(val => val);
    	  
    	//전부 넣었으면 ,로 join해서 하나로
    	const selectedState = selectedStateArr.join(', ');
    	
    	
    	//status에 넣을거 배열에 전부 넣기
    	const selectedTreatmentArr = Array.from(
    		  document.querySelectorAll('input[name="status"]:checked')
    		).map(cb => cb.value);

	  	//전부 넣었으면 , 로 join해서 하나로
	  	const selectedTreatment = selectedTreatmentArr.join(', ');
	
	
	  	console.log('selectedTreatmentArr:', selectedTreatmentArr); // ["S1","S3"] 등
	  	console.log('selectedTreatment:', selectedTreatment);       // "S1, S3"

    	console.log('selectedStateArr:',selectedStateArr); // ['C2', 'Q1']  
    	console.log('selectedState:',selectedState);    // "C2, Q1"
    	  
    	  
    	  // history 업데이트(log로 보낼거)
    	  regions.forEach(region => {
    	    if (region.isClicked) {
    	        region.history.push({
    	          visit_date: treatmentDate,
    	          category: '',
    	          status: selectedTreatment
    	        }); 
    	    }
    	  });

    	  // 서버 저장용 formData 생성
    	  const treatmentObj = new PendingTreatment({
    		  treatmentDate: treatmentDate.toISOString().split('T')[0],
    		  selectedTeeth: teethsParam,
    		  selectedTreatment,
    		  selectedState,
    		  mainCategory: '',
    		  userId: Liferay.ThemeDisplay.getUserId(),
    		  authToken: Liferay.authToken
    		});

    		// 예: formData 대신 이걸로 쓸 수 있음
    		const formData = treatmentObj.toFormData();

    	
    	  const newlyAddedTeeth = [];
    	  if (teethsParam) {
    		const teethList = teethsParam
    	  .split(',')
    	  .map(tooth => tooth.trim());  // ← 여기서 trim()
    			
    		
    		
    		
    		
    		
    		treatmentDate = formData.get('treatmentDate');

    		// 치아 × 상태
    		teethList.forEach(tooth => {
    		  selectedTreatmentArr.forEach(treatment => {
    		    addPendingTreatment({ tooth, treatmentDate, treatment, state: '-' });
    		  });
    		});

    		// 치아 × 부위
    		teethList.forEach(tooth => {
    		  selectedStateArr.forEach(state => {
    		    addPendingTreatment({ tooth, treatmentDate, treatment: '-', state });
    		  });
    		});

    		// 중복 알림부분 만들어야 함


    	  }

    	  console.log('Pending Treatments:', pendingTreatments);
    	  console.log('matched:', matched);

    	  
    	  
    	     	  
    	  
    	  
    	  // 테이블 업데이트: 새로 추가된 치아번호만 렌더링
    	if (newlyAddedTeeth.length) {
    	  const tbody = document.querySelector('#treatmentTable tbody');
    	  
    	  newlyAddedTeeth.forEach(({ tooth, treatment, permanent }) => {
    	    const tr = document.createElement('tr');
    	    const teethNumberNum     = tooth.replace("Teeth", "");
    	    const permanentDisplay   = permanent || '-';
    	    const treatmentDisplay      = treatment    || '-';

    	    tr.innerHTML =
    	    	 createTd(teethNumberNum) +
    	    	 createTd(treatmentDate) +
    	    	 createTd(permanentDisplay) +
	   	    	 createTd(treatmentDisplay) +
	   	    	 
    	    	 
    	    	  `<td style="border:1px solid #ccc; padding:6px; text-align:center;">
    	    	     <button type="button" class="clear-btn">delete</button>
    	    	   </td>`;
    	      tbody.appendChild(tr);
    	      
    	      
    	      function createTd(content) {
    	    	  return `<td style="border:1px solid #ccc; padding:6px;">${content}</td>`;
    	    	}

    	      
    	      

    	      tr.querySelector('.clear-btn').addEventListener('click', (e) => {
    	    	  const btn = e.target;
    	    	  const tr = btn.closest('tr');
    	    	  const tbody = tr.parentElement;
    	    	  
    	    	  // tr이 tbody 자식 중 몇 번째인지 찾기
    	    	  const index = Array.from(tbody.children).indexOf(tr);

    	    	  // 테이블에서 행 제거
    	    	  tr.remove();

    	    	  if (index > -1 && index < pendingTreatments.length) {
    	    	    pendingTreatments.splice(index, 1);
    	    	    console.log('삭제된 인덱스:', index);
    	    	    console.log('남은 pendingTreatments:', pendingTreatments);
    	    	  }
    	    	});  	      
    	      
    	      
    	    });
    	  }

    	  // 입력 리셋
    	  statusRadios.forEach(r => r.checked = false);
	  	  permanentCRadios.forEach(r => {
	  	  	  console.log(r.value, r.checked); // 해제 전 상태 확인
	  	  	  r.checked = false;               // 체크 해제
	  	  	});
	  	  permanentDDRadios.forEach(r => r.checked = false);
	    	  addBtn.disabled = true;
	    	  drawRegions();
    	  

	        // 날짜 포맷 함수
	       function formatDate(dateString) {
	         const [year, month, day] = dateString.split('.').map(s => s.trim());
	         return `${year}-${month.padStart(2,'0')}-${day.padStart(2,'0')}`;
	       }  
	       
	       
	       function addPendingTreatment({ tooth, treatmentDate, treatment = '-', state = '-' }) {
	    	   // 중복 여부 검사
	    	   const newTreatment = new PendingTreatment({
	    	     treatmentDate,
	    	     selectedTeeth: tooth,
	    	     selectedTreatment: treatment,
	    	     selectedState: state,
	    	     mainCategory: '',
	    	     userId: Liferay.ThemeDisplay.getUserId(),
	    	     authToken: Liferay.authToken
	    	   });

	    	   const formParams = newTreatment.toFormData();

	    	   const isDuplicate = 
	    	     pendingTreatments.some(item => {
	    	       const p = new URLSearchParams(item);
	    	       return (
	    	         p.get('treatmentDate') === treatmentDate &&
	    	         p.get('selectedTeeth') === tooth &&
	    	         p.get('selectedTreatment') === treatment &&
	    	         p.get('selectedState') === state
	    	       );
	    	     }) ||
	    	     matched.some(m =>
	    	       m.date === treatmentDate &&
	    	       m.region === `Teeth${tooth}` &&
	    	       (
	    	         (treatment !== '-' && m.treatment.split(',').includes(treatment)) ||
	    	         (state !== '-' && m.state.split(',').includes(state))
	    	       )
	    	     );

	    	   if (isDuplicate) {
	    	     if (treatment !== '-') anyStatusDuplicate = true;
	    	     if (state !== '-') anyStateDuplicate = true;

	    	     console.log(`중복 발견 → tooth=${tooth}, treatment=${treatment}, state=${state}`);
	    	     // alert 대신 로그 또는 UI에 띄우는 메시지 수집만
	    	     const isTreatment = treatment !== '-';
	    	     const type = isTreatment ? 'treatment' : 'state';
	    	     const value = isTreatment ? treatment : state;

	    	     const msg = `${type} 항목이 중복되었습니다. (tooth=${tooth}, ${type}=${value})`;
	    	     msgs.push(msg);
	    	     return;
	    	   }

	    	   // 중복이 아니라면 추가
	    	   pendingTreatments.push(formParams.toString());
	    	   newlyAddedTeeth.push({
	    	     tooth,
	    	     treatment: treatment !== '-' ? treatment : '-',
	    	     permanent: state !== '-' ? state : '-'
	    	   });

	    	   console.log('추가', treatment !== '-' ? treatment : state);
	    	 }

    	  
    	});
  	
 
  	
  	
  	
    //save 버튼을 클릭했을 경우 DB에 추가하는 
  	addDBBtn.addEventListener('click', () => {
  	console.log('원본 Pending Treatments:', pendingTreatments);

  	  // 함수에 pendingTreatments를 인자로 넘겨 호출
  	  const combinedList = groupAndCombineTreatments(pendingTreatments);
  	  console.log('합쳐진 Treatments:', combinedList);

  	  const treatmentsData = new URLSearchParams();
  	  combinedList.forEach((str, i) => {
  	    const decoded = decodeURIComponent(str);
  	    treatmentsData.append(`treatment_${i + 1}`, decoded);
  	  });
  	  console.log('전송용 Params:', treatmentsData.toString());

  	  $.ajax({
  	    type: 'POST',
  	    url: '/o/teeth-web/ajax/save_treatment_list_db.jsp',
  	    data: treatmentsData.toString(),
  	    contentType: 'application/x-www-form-urlencoded; charset=UTF-8',
  	    success(response) {
  	      console.log("서버 응답:", response);
  	      pendingTreatments.length = 0;
  	      Liferay.Util.getOpener().location.reload();
  	      Liferay.Util.getOpener().closeDialog('addTreatmentDialog');
  	    },
  	    error(xhr, status, error) {
  	      console.error("AJAX 실패:", error);
  	    }
  	  });
	  
	  
	  // 나중에 ajax로 actioncommand(ajaxURL)로 쓸 때 수정해볼 것
	  /*
	  $.ajax({
		    type: 'POST',
		    url: window.ajaxURL,
		    //url: '<%= ajaxURL %>',
		    data: treatmentsData.toString(),  // URLSearchParams로 전송
		    contentType: 'application/x-www-form-urlencoded; charset=UTF-8',
		    success: function(response) {
		      console.log("서버 응답:", response);
		      // 서버 응답 후 처리할 코드 추가 (예: pendingTreatments 비우기)
		      pendingTreatments.length = 0;
		      
		      Liferay.Util.getOpener().location.reload(); 
		      Liferay.Util.getOpener().closeDialog('addTreatmentDialog');
		    },
		    error: function(xhr, status, error) {
		      console.error("AJAX 실패:", error);
		    }
		  });
	  */  
	  
	  
	});
	
  	
  	
  	
  	
	  function groupAndCombineTreatments(pendingList) {
		  const grouped = {};

		  pendingList.forEach(item => {
		    const params = new URLSearchParams(item);
		    const date  = params.get('treatmentDate');
		    const tooth = params.get('selectedTeeth');
		    const key   = `${date}|${tooth}`;

		    if (!grouped[key]) {
		      grouped[key] = {
		        treatmentDate: date,
		        selectedTeeth: tooth,
		        statuses: new Set(),
		        permanents: new Set(),
		        mainCategory: params.get('mainCategory'),
		        userId:      params.get('EditUserId'),
		        authToken:   params.get('p_auth')
		      };
		    }

		    const st = params.get('selectedTreatment');
		    if (st && st !== '-') grouped[key].statuses.add(st);

		    const pm = params.get('selectedState');
		    if (pm && pm !== '-') grouped[key].permanents.add(pm);
		  });

		  return Object.values(grouped).map(g => {
		    const ps = [...g.statuses].join(',') || '-';
		    const pp = [...g.permanents].join(',') || '-';

		    const up = new URLSearchParams();
		    up.set('EditUserId',    g.userId);
		    up.set('treatmentDate', g.treatmentDate);
		    up.set('mainCategory',  g.mainCategory);
		    up.set('selectedTreatment', ps);
		    up.set('selectedTeeth', g.selectedTeeth);
		    up.set('selectedState', pp);
		    up.set('p_auth',        g.authToken);

		    return up.toString();
		  });
  		}
	


  // 이력 표시 함수
  function updateHistoryDisplay() {
    historyContainer.innerHTML = '';
    regions.filter(r => r.isClicked).forEach(region => {
      const entries = [...region.history].sort((a, b) => b.visit_date - a.visit_date);
      const header = document.createElement('h4');
      header.textContent = region.name;
      historyContainer.appendChild(header);
      const ul = document.createElement('ul');
      entries.forEach(e => {
        const li = document.createElement('li');
        li.textContent = `${e.visit_date.toLocaleDateString()} - ${e.category || ''} ${e.status}`;
        ul.appendChild(li);
      });
      historyContainer.appendChild(ul);
    });
  }


  
  // drawRegions: 크기 및 색상 업데이트
  function drawRegions() {
    const scaleX = patientImage.clientWidth / patientImage.naturalWidth;
    const scaleY = patientImage.clientHeight / patientImage.naturalHeight;

    regions.forEach(region => {
      const div = document.querySelector(`.region[data-name=\"${region.name}\"]`);
      const left = region.x1 * scaleX;
      const top = region.y1 * scaleY;
      const w = (region.x2 - region.x1) * scaleX;
      const h = (region.y2 - region.y1) * scaleY;
      Object.assign(div.style, { left: `${left}px`, top: `${top}px`, width: `${w}px`, height: `${h}px` });
      div.style.backgroundColor = region.isClicked ? 'red' : (region.history.length ? 'orange' : 'white');
    });

    jointNumLabel.textContent = jointNum;
    const cleanedTeethNumbers = passedTeethNames.map(name => name.replace("Teeth", ""));
    selectedButtonsLabel.textContent = cleanedTeethNumbers.join(', ');
    updateHistoryDisplay();
  }
  
 
  //버튼이 선택되어 있지 않을경우 add 버튼을 비활성화
  function updateAddButtonState() {
	  const isAnyStatusChecked = Array.from(statusRadios).some(r => r.checked);
	  const isAnyPermanentCChecked = Array.from(permanentCRadios).some(r => r.checked);
	  const isAnyPermanentDDChecked = Array.from(permanentDDRadios).some(r => r.checked);

	  // 하나라도 선택되어 있으면 활성화, 아니면 비활성화
	  addBtn.disabled = !(isAnyStatusChecked || isAnyPermanentCChecked || isAnyPermanentDDChecked);
	}


});
