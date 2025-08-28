<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="../../init.jsp" %>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page import="java.util.List" %>
<%@ page import="teeth.model.TreatmentHistory" %>
<%@ page import="teeth.service.TreatmentHistoryLocalServiceUtil" %>
<%@ page import="com.liferay.portal.kernel.json.JSONFactoryUtil" %>
<%@ page import="com.liferay.portal.kernel.json.JSONArray" %>
<%@ page import="com.liferay.portal.kernel.json.JSONObject" %>
<%@ page import="com.liferay.portal.kernel.log.Log" %>
<%@ page import="com.liferay.portal.kernel.log.LogFactoryUtil" %>
<%@ page import="java.text.SimpleDateFormat" %>

<%
    String portalURL = themeDisplay.getPortalURL();
    String contextPath = themeDisplay.getPathContext();
    String teethsParam1 = request.getParameter("teeths");
    String trueParam = (String) request.getAttribute("teeths");
    request.setAttribute("teeths", trueParam);
    String teethsParam = (String) request.getAttribute("teeths");
%>
<%! 

	private static final Log _log = LogFactoryUtil.getLog("allHistoryJsonLogger"); 
%>

<%
    List<TreatmentHistory> allHistories =
        TreatmentHistoryLocalServiceUtil.getPatientTreatmentList(1001);

    JSONArray allHistoryJson = JSONFactoryUtil.createJSONArray();
    for (TreatmentHistory th : allHistories) {
        JSONObject obj = JSONFactoryUtil.createJSONObject();
        obj.put("region",    "Teeth" + th.getTeethNum());
        obj.put("date",      new SimpleDateFormat("yyyy-MM-dd").format(th.getTreatmentDate()));
        obj.put("treatment", th.getTreatment());
        obj.put("state",     th.getState());
        allHistoryJson.put(obj);
    }
    _log.info("allHistoryJson → " + allHistoryJson.toString());
%>

<c:set var="allHistoryData" value="${allHistoryJson.toString()}" />
<script>
  const allHistoryData = <%= allHistoryJson.toString() %>;
  const teethsParam = '<%= teethsParam %>';
</script>

<html>
<head>
  <title>Teeth View</title>
  <style>
    :root{ --frame-w:1200px; --frame-h:950px; --label-w:120px; --group-gap:10px;}
    body{ margin:0; }
    .viewport{ width:var(--frame-w); height:var(--frame-h); margin:0 auto; overflow:auto; }

    .separator{ border-top:2px solid #ccc; margin:12px 0; }

    /* ── 사진 2 형태의 그리드 ───────────────────────────────────────── */
    .survey-wrap{ width:1160px; margin:0 auto; display:flex; flex-direction:column; gap:8px; }
    .survey-row{ display:flex; gap:var(--group-gap); }
    .survey-group{
      display:flex; border:1px solid #cfcfcf; background:#fff; flex:1; min-height:36px;
    }
    .survey-group.full{ flex:0 0 100%; }
    .group-label{
      width:var(--label-w); background:#efefef; font-weight:700; text-align:center;
      display:flex; align-items:center; justify-content:center; padding:6px 4px; white-space:nowrap;
    }
    .group-body{
      flex:1; display:flex; align-items:center; gap:12px; flex-wrap:wrap; padding:6px 10px;
    }
    .group-body label{ display:inline-flex; align-items:center; gap:6px; }
    .pill{
      border:1px solid #ddd; padding:2px 6px; border-radius:4px; display:inline-flex; align-items:center;
    }
  </style>
</head>
<body>
<div class="viewport">
  <aui:script>console.log("Received teeths:", "<%= teethsParam %>");</aui:script>

  <div style="padding:10px 20px; font-size:20px; font-weight:bold;">
    치식 번호: <span id="jointNumLabel"></span> 개 [ <span id="selectedButtonsLabel"></span> ]
  </div>

  <div id="imageWrapper">
    <!-- <img id="patientImage" src="/o/teeth-web/images/teeth.png" alt="Patient Teeth" draggable="false" /> -->
  </div>

  <!-- 날짜 -->
  <div class="survey-wrap" style="margin-top:10px;">
    <div class="survey-row">
      <div class="survey-group full">
        <div class="group-label">Date</div>
        <div class="group-body">
          <input type="date" name="treatmentDate" id="treatmentDate" min="2025-01-01" max="">
          <span id="ageDiff" style="font-size:0.95rem;color:#555;"></span>
        </div>
      </div>
    </div>
  </div>

  <div class="separator"></div>

  <!-- ===================== STATE (사진1 전부) ===================== -->
	<!-- ⬇️ STATE 섹션을 treatment 네임으로 통일 -->
	<div class="survey-wrap" id="treatmentSurvey">
	
	  <!-- 임상 증상 -->
	  <div class="survey-row">
	    <div class="survey-group full">
	      <div class="group-label">임상 증상</div>
	      <div class="group-body">
	        <label class="pill"><input type="checkbox" name="treatment_symptom[]" value="Per">Per</label>
	        <label class="pill"><input type="checkbox" name="treatment_symptom[]" value="Mob">Mob</label>
	        <label class="pill"><input type="checkbox" name="treatment_symptom[]" value="Bite">Bite</label>
	        <label class="pill"><input type="checkbox" name="treatment_symptom[]" value="Cold">Cold</label>
	        <label class="pill"><input type="checkbox" name="treatment_symptom[]" value="Hot">Hot</label>
	        <label class="pill"><input type="checkbox" name="treatment_symptom[]" value="Spontaneous pain">Spontaneous pain</label>
	        <label class="pill"><input type="checkbox" name="treatment_symptom[]" value="Cervical sensitivity">Cervical sensitivity</label>
	      </div>
	    </div>
	  </div>
	
	  <!-- Occlusion + Caries surface -->
	  <div class="survey-row">
	    <div class="survey-group">
	      <div class="group-label">Occlusion</div>
	      <div class="group-body">
	        <label><input type="radio" name="treatment_occlusion" value="Normal occlusion">Normal occlusion</label>
	        <label><input type="radio" name="treatment_occlusion" value="Hyper occlusion">Hyper occlusion</label>
	        <label><input type="radio" name="treatment_occlusion" value="Infra occlusion">Infra occlusion</label>
	      </div>
	    </div>
	    <div class="survey-group">
	      <div class="group-label">Caries surface</div>
	      <div class="group-body">
	        <label class="pill"><input type="checkbox" name="treatment_caries_surface[]" value="O">O</label>
	        <label class="pill"><input type="checkbox" name="treatment_caries_surface[]" value="M">M</label>
	        <label class="pill"><input type="checkbox" name="treatment_caries_surface[]" value="D">D</label>
	        <label class="pill"><input type="checkbox" name="treatment_caries_surface[]" value="B">B</label>
	        <label class="pill"><input type="checkbox" name="treatment_caries_surface[]" value="L(P)">L(P)</label>
	        <label class="pill"><input type="checkbox" name="treatment_caries_surface[]" value="Root caries">Root caries</label>
	      </div>
	    </div>
	  </div>
	
	  <!-- Caries depth + Caries level -->
	  <div class="survey-row">
	    <div class="survey-group">
	      <div class="group-label">Caries depth</div>
	      <div class="group-body">
	        <label><input type="radio" name="treatment_caries_depth" value="Enamel 1/2">Enamel 1/2</label>
	        <label><input type="radio" name="treatment_caries_depth" value="DEJ">DEJ</label>
	        <label><input type="radio" name="treatment_caries_depth" value="Dentin 1/2">Dentin 1/2</label>
	      </div>
	    </div>
	    <div class="survey-group">
	      <div class="group-label">Caries level</div>
	      <div class="group-body">
	        <label><input type="radio" name="treatment_caries_level" value="Supra-gingiva">Supra-gingiva</label>
	        <label><input type="radio" name="treatment_caries_level" value="Equi-gingiva">Equi-gingiva</label>
	        <label><input type="radio" name="treatment_caries_level" value="Sub-gingiva">Sub-gingiva</label>
	      </div>
	    </div>
	  </div>
	
	  <!-- Hard tissue ds. + Lesion -->
	  <div class="survey-row">
	    <div class="survey-group">
	      <div class="group-label">Hard tissue ds.</div>
	      <div class="group-body">
	        <label class="pill"><input type="checkbox" name="treatment_hard_tissue[]" value="Hypomineralization">Hypomineralization</label>
	        <label class="pill"><input type="checkbox" name="treatment_hard_tissue[]" value="Hypoplasia">Hypoplasia</label>
	        <label class="pill"><input type="checkbox" name="treatment_hard_tissue[]" value="White spot">White spot</label>
	      </div>
	    </div>
	    <div class="survey-group">
	      <div class="group-label">Lesion</div>
	      <div class="group-body">
	        <label class="pill"><input type="checkbox" name="treatment_lesion[]" value="Abrasion">Abrasion</label>
	        <label class="pill"><input type="checkbox" name="treatment_lesion[]" value="Attrition">Attrition</label>
	        <label class="pill"><input type="checkbox" name="treatment_lesion[]" value="Abfraction">Abfraction</label>
	        <label class="pill"><input type="checkbox" name="treatment_lesion[]" value="Erosion">Erosion</label>
	      </div>
	    </div>
	  </div>
	
	  <!-- Fracture(단일) + Fracture(다중) -->
	  <div class="survey-row">
	    <div class="survey-group">
	      <div class="group-label">Fracture(단일)</div>
	      <div class="group-body">
	        <label><input type="radio" name="treatment_fracture_single" value="Marginal ridge">Marginal ridge</label>
	        <label><input type="radio" name="treatment_fracture_single" value="Supra-gingiva">Supra-gingiva</label>
	        <label><input type="radio" name="treatment_fracture_single" value="Equi-gingiva">Equi-gingiva</label>
	        <label><input type="radio" name="treatment_fracture_single" value="Sub-gingiva">Sub-gingiva</label>
	      </div>
	    </div>
	    <div class="survey-group">
	      <div class="group-label">Fracture(다중)</div>
	      <div class="group-body">
	        <label class="pill"><input type="checkbox" name="treatment_fracture_multi[]" value="MB">MB</label>
	        <label class="pill"><input type="checkbox" name="treatment_fracture_multi[]" value="B">B</label>
	        <label class="pill"><input type="checkbox" name="treatment_fracture_multi[]" value="DB">DB</label>
	        <label class="pill"><input type="checkbox" name="treatment_fracture_multi[]" value="ML">ML</label>
	        <label class="pill"><input type="checkbox" name="treatment_fracture_multi[]" value="MD">MD</label>
	        <label class="pill"><input type="checkbox" name="treatment_fracture_multi[]" value="P">P</label>
	      </div>
	    </div>
	  </div>
	
	  <!-- Visible crack line + Crack line level -->
	  <div class="survey-row">
	    <div class="survey-group">
	      <div class="group-label">Visible crack line</div>
	      <div class="group-body">
	        <label class="pill"><input type="checkbox" name="treatment_visible_crack[]" value="O">O</label>
	        <label class="pill"><input type="checkbox" name="treatment_visible_crack[]" value="M">M</label>
	        <label class="pill"><input type="checkbox" name="treatment_visible_crack[]" value="D">D</label>
	        <label class="pill"><input type="checkbox" name="treatment_visible_crack[]" value="B">B</label>
	        <label class="pill"><input type="checkbox" name="treatment_visible_crack[]" value="L(P)">L(P)</label>
	      </div>
	    </div>
	    <div class="survey-group">
	      <div class="group-label">Crack line level</div>
	      <div class="group-body">
	        <label><input type="radio" name="treatment_crack_level" value="Supra-gingiva">Supra-gingiva</label>
	        <label><input type="radio" name="treatment_crack_level" value="Equi-gingiva">Equi-gingiva</label>
	        <label><input type="radio" name="treatment_crack_level" value="Sub-gingiva">Sub-gingiva</label>
	      </div>
	    </div>
	  </div>
	
	  <!-- Material + Cusp capping -->
	  <div class="survey-row">
	    <div class="survey-group">
	      <div class="group-label">Material</div>
	      <div class="group-body">
	        <label class="pill"><input type="checkbox" name="treatment_material[]" value="GI">GI</label>
	        <label class="pill"><input type="checkbox" name="treatment_material[]" value="Resin(direct)">Resin(direct)</label>
	        <label class="pill"><input type="checkbox" name="treatment_material[]" value="Resin(indirect)">Resin(indirect)</label>
	        <label class="pill"><input type="checkbox" name="treatment_material[]" value="Gold">Gold</label>
	        <label class="pill"><input type="checkbox" name="treatment_material[]" value="Ceramic">Ceramic</label>
	        <label class="pill"><input type="checkbox" name="treatment_material[]" value="Zirconia">Zirconia</label>
	      </div>
	    </div>
	    <div class="survey-group">
	      <div class="group-label">Cusp capping</div>
	      <div class="group-body">
	        <label class="pill"><input type="checkbox" name="treatment_cusp_capping[]" value="MB">MB</label>
	        <label class="pill"><input type="checkbox" name="treatment_cusp_capping[]" value="B">B</label>
	        <label class="pill"><input type="checkbox" name="treatment_cusp_capping[]" value="DB">DB</label>
	        <label class="pill"><input type="checkbox" name="treatment_cusp_capping[]" value="ML">ML</label>
	        <label class="pill"><input type="checkbox" name="treatment_cusp_capping[]" value="MD">MD</label>
	        <label class="pill"><input type="checkbox" name="treatment_cusp_capping[]" value="P">P</label>
	      </div>
	    </div>
	  </div>
	
	  <!-- Gingival level + Perio -->
	  <div class="survey-row">
	    <div class="survey-group">
	      <div class="group-label">Gingival level</div>
	      <div class="group-body">
	        <label><input type="radio" name="treatment_gingival_level" value="Supra-gingiva">Supra-gingiva</label>
	        <label><input type="radio" name="treatment_gingival_level" value="Equi-gingiva">Equi-gingiva</label>
	        <label><input type="radio" name="treatment_gingival_level" value="Sub-gingiva">Sub-gingiva</label>
	      </div>
	    </div>
	    <div class="survey-group">
	      <div class="group-label">Perio</div>
	      <div class="group-body">
	        <label class="pill"><input type="checkbox" name="treatment_perio[]" value="Redness">Redness</label>
	        <label class="pill"><input type="checkbox" name="treatment_perio[]" value="Gingival swelling">Gingival swelling</label>
	        <label class="pill"><input type="checkbox" name="treatment_perio[]" value="BOP">BOP</label>
	        <label class="pill"><input type="checkbox" name="treatment_perio[]" value="Gingival recession">Gingival recession</label>
	        <label class="pill"><input type="checkbox" name="treatment_perio[]" value="Advanced alveolar bone resorption">Advanced alveolar bone resorption</label>
	        <label class="pill"><input type="checkbox" name="treatment_perio[]" value="calculus deposition">calculus deposition</label>
	      </div>
	    </div>
	  </div>
	
	  <!-- Quality -->
	  <div class="survey-row">
	    <div class="survey-group full">
	      <div class="group-label">Quality</div>
	      <div class="group-body">
	        <label class="pill"><input type="checkbox" name="treatment_quality[]" value="Restoration fracture">Restoration fracture</label>
	        <label class="pill"><input type="checkbox" name="treatment_quality[]" value="Contact loosening">Contact loosening</label>
	        <label class="pill"><input type="checkbox" name="treatment_quality[]" value="Poor Form and contour">Poor Form and contour</label>
	        <label class="pill"><input type="checkbox" name="treatment_quality[]" value="Poor occlusion">Poor occlusion</label>
	        <label class="pill"><input type="checkbox" name="treatment_quality[]" value="Secondary caries">Secondary caries</label>
	        <label class="pill"><input type="checkbox" name="treatment_quality[]" value="Marginal defect">Marginal defect</label>
	        <label class="pill"><input type="checkbox" name="treatment_quality[]" value="Postoperative hypersensitivity">Postoperative hypersensitivity</label>
	        <label class="pill"><input type="checkbox" name="treatment_quality[]" value="Marginal staining">Marginal staining</label>
	        <label class="pill"><input type="checkbox" name="treatment_quality[]" value="Poor color match">Poor color match</label>
	      </div>
	    </div>
	  </div>
	
	  <!-- Pocket depth (5mm) -->
	  <div class="survey-row">
	    <div class="survey-group full">
	      <div class="group-label">Pocket depth (5mm)</div>
	      <div class="group-body">
	        <label class="pill"><input type="checkbox" name="treatment_pocket_depth[]" value="MB">MB</label>
	        <label class="pill"><input type="checkbox" name="treatment_pocket_depth[]" value="B">B</label>
	        <label class="pill"><input type="checkbox" name="treatment_pocket_depth[]" value="DB">DB</label>
	        <label class="pill"><input type="checkbox" name="treatment_pocket_depth[]" value="ML">ML</label>
	        <label class="pill"><input type="checkbox" name="treatment_pocket_depth[]" value="L">L</label>
	        <label class="pill"><input type="checkbox" name="treatment_pocket_depth[]" value="DL">DL</label>
	      </div>
	    </div>
	  </div>
	</div>
	
	<!-- ⬇️ 기존 치료 박스의 name도 통일: status → treatment_proc[] -->
	<div id="radioButtonWrapper" class="treatment-box option-group">
	  <div class="inline-section">
	    <p><strong>예방</strong></p>
	    <div style="border-left:1px solid #ccc; padding-left:10px; display:flex; gap:10px;">
	      <label><input type="checkbox" name="treatment_proc[]" value="TFA" data-category="예방"/> 불소도포</label>
	      <label><input type="checkbox" name="treatment_proc[]" value="SC"  data-category="예방"/> 스케일링</label>
	    </div>
	  </div>
	  <!-- 이하 모든 치료 체크박스 name="treatment_proc[]" 로 동일 처리 -->
	</div>
	
	<!-- 표 헤더도 Treatment 만 남기고 간단화하고 싶다면 아래처럼 바꿔도 됨 -->
	<!-- <th>Details</th> 하나로 합쳐도 무방 -->

  <!-- ===================== /STATE ===================== -->

  <div class="separator"></div>

  <!-- 버튼/동적 테이블: 기존 그대로 유지 -->
  <div class="treatment-column" style="display:flex; align-items:center; gap:10px; padding:0 20px;">
    <button id="addTreatmentBtn" type="button" style="padding:5px 15px; font-size:15px;" disabled>Add Record</button>
    <button id="clearSelectionsBtn" type="button" style="padding:5px 15px; font-size:15px;">Clear</button>
    <button id="deleteAllBtn" type="button" style="padding:5px 15px; font-size:15px;">Delete all</button>
  </div>

  <div class="separator"></div>

  <div style="padding:0 20px; font-size:20px; font-weight:bold;">
    진료 기록  [ Teeth: <span id="selectedButtonsLabel2"></span> ]
  </div>

  <input type="hidden" id="namespace" value="<portlet:namespace/>"/>

  <div id="historyContainer"></div>

  <table id="treatmentTable" style="width:90%; border-collapse:collapse; margin:0 auto;">
    <thead>
      <tr>
        <th style="border:1px solid #ccc; padding:8px;">Date</th>
        <th style="border:1px solid #ccc; padding:8px;">Teeth</th>
        <th style="border:1px solid #ccc; padding:8px;">State</th>
        <th style="border:1px solid #ccc; padding:8px;">Treatment</th>
        <th style="border:1px solid #ccc; padding:8px;">Action</th>
      </tr>
    </thead>
    <tbody></tbody>
  </table>

  <div style="text-align:center; font-size:16px; margin-top:16px;">
    하단의 Save 버튼을 누르면 추가했던 데이터들이 데이터베이스에 저장됩니다.<br/><br/>
    cancel 버튼을 누르면 현재 작업을 취소하고 팝업을 닫습니다.
  </div>

  <div style="display:flex; justify-content:center; gap:8px; margin:20px 0;">
    <button id="addDBBtn" type="button" style="padding:5px 15px; font-size:15px;">Save</button>
    <button id="cancelBtn" type="button" style="padding:5px 15px; font-size:15px;">Back</button>
  </div>
</div>

<portlet:resourceURL id="/teeth/addTreatment" var="resourceAddURL"/>
<script>const resourceURL = '<%=resourceAddURL.toString()%>';</script>
<script src="/o/teeth-Dentistry/js/treatment.js"></script>

<c:set var="initialTeeths" value="${param.teeths}" />
<script>var INITIAL_TEETHS = '${initialTeeths}';</script>
</body>
</html>
