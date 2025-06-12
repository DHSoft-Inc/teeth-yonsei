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
   // JSP 컴파일 시점에 한 번만 초기화되는 logger 인스턴스 
   private static final Log _log = LogFactoryUtil.getLog("allHistoryJsonLogger"); 
%>

<%
    // 1) DB에서 전체 이력 조회
    List<TreatmentHistory> allHistories =
        TreatmentHistoryLocalServiceUtil.getPatientTreatmentList(1001);

    // 2) JSON 배열로 변환
    JSONArray allHistoryJson = JSONFactoryUtil.createJSONArray();
    for (TreatmentHistory th : allHistories) {
        JSONObject obj = JSONFactoryUtil.createJSONObject();
        obj.put("region",    "Teeth" + th.getTeethNum());
        obj.put("date",      new SimpleDateFormat("yyyy-MM-dd").format(th.getTreatmentDate()));
        obj.put("treatment", th.getTreatment());  // 예: "AF,Gugang"
        obj.put("state",     th.getState());      // 예: "C1,Y"
        allHistoryJson.put(obj);
          
    }
    _log.info("allHistoryJson → " + allHistoryJson.toString());
%>

<c:set var="allHistoryData" value="${allHistoryJson.toString()}" />
<script>
  // 전역에 배열로 저장
  const allHistoryData = <%= allHistoryJson.toString() %>;
  const teethsParam = '<%= teethsParam.toString() %>';
  console.log("전체 이력:", allHistoryData);
  console.log("선택 치아:", teethsParam);
</script>

<html>
<head>
  <title>Teeth View</title>
  <style>
    #imageWrapper {
      position: relative;
      max-width: 90%;
      margin: 0 auto;
    }

    #patientImage {
      width: 100%;
      height: auto;
      display: block;
      user-select: none;
    }

    .region {
      position: absolute;
      border: 2px solid black;
      opacity: 0.5;
      cursor: pointer;
      z-index: 10;
    }

    #historyContainer {
      margin-top: 30px;
    }

    #historyContainer h4 {
      margin-bottom: 5px;
    }

    #historyContainer ul {
      margin-top: 0;
      margin-bottom: 15px;
      padding-left: 20px;
    }

    .treatment-row {
      display: flex;
      flex-direction: column;    /* <- 추가 */
      align-items: flex-start;   /* 왼쪽 정렬 */
      gap: 20px;                 /* 박스 사이 간격 */
      margin-top: 20px;
    }
    
    .treatment-column {
      display: flex;
      align-items: stretch;
      justify-content: flex-start;
      gap: 15px;
      margin-top: 20px;
      flex-wrap: wrap;
    
    }
    
	.treatment-box {
	  border: 1px solid #ccc;
	  padding: 10px;
	  min-width: 200px;
	  width: 1050px; /* 고정된 너비 설정 */
	  display: flex;
	  flex-direction: column;
	  justify-content: flex-start; /* 박스가 커지더라도 내용은 위에 고정 */
	  flex-grow: 0;
	  flex-shrink: 0;
	  height: auto;
	}

	.treatment-box-date {
	  border: 1px solid #ccc;
	  padding: 10px;
	  min-width: 200px;
	  width: 1160px; /* 고정된 너비 설정 */
	  display: flex;
	  flex-direction: column;
	  justify-content: flex-start; /* 박스가 커지더라도 내용은 위에 고정 */
	  flex-grow: 0;
	  flex-shrink: 0;
	  height: auto;
	}

    .option-group label {
      display: inline-flex;     /* 가로 안에서 inline 배치 */
      align-items: center;
      margin: 0;                /* gap으로 간격 제어 */
    }

    .option-group {
      display: flex;            /* <- 변경 */
      flex-wrap: wrap;          /* 줄바꿈 허용 */
      flex-direction: row;      /* 가로 정렬 */
      gap: 15px;                /* 옵션들 사이 간격 */
    }

    .separator {
      border-top: 2px solid #ccc;
      margin: 20px 0;
    }
    
  table.custom-table-outer {
  	width: 1160px;
    border-collapse: collapse;
   	text-align: left; 
  }

  .custom-table-outer th,
  .custom-table-outer td {
    border: 1px solid #ccc;
    padding: 10px;
    vertical-align: middle;
    font-size: 15px;
  }
  
  .custom-table-outer th {
  text-align: center;  /* th 요소들만 가운데 정렬 */
	}

  .custom-table-outer label {
  	display: block;  /* 라벨을 블록으로 처리하여 세로로 나열 */
    margin: 0 5px;
  }  
    
    
    
  table.custom-table {
  	width: 1050px;
    border-collapse: collapse;
   	text-align: left; 
  }

  .custom-table th,
  .custom-table td {
    border: 1px solid #ccc;
    padding: 10px;
    vertical-align: middle;
    font-size: 15px;
  }
  
  .custom-table th {
  text-align: center;  /* th 요소들만 가운데 정렬 */
	}

  .custom-table label {
  	display: block;  /* 라벨을 블록으로 처리하여 세로로 나열 */
    margin: 0 5px;
  }
  
	  #radioButtonWrapper {
	  display: inline-flex;
	  flex-direction: row;
	  gap: 20px;
	}
	
	#radioButtonWrapper p {
	  margin: 0;
	  font-weight: bold;
	  vertical-align: middle;  /* 텍스트가 수평 정렬되도록 */
	}
	
	#radioButtonWrapper label {
	  display: inline-flex;
	  align-items: center;
	  margin: 0;
	}
  
	.inline-section {
	  display: flex;                   /* 같은 비율로 균등 분할 */
	  align-items: center;
	  gap: 8px;
	  padding: 10px;
	  box-sizing: border-box;
	}
	
	.inline-section:first-child {
	  flex: 1;
	}
	
	.inline-section:last-child {
	  flex: 2;
	}
	
	.inline-section p {
	  margin-right: 5px;
	  white-space: nowrap;
	}
	
	.with-border {
	  border-left: 1px solid #ccc;
	}
	 
	.mar-r-2 { margin-right:2px;}
  </style>
</head>
<body>

<aui:script>
  console.log("Received teeths:", "<%= teethsParam %>");
</aui:script>

<div style="padding:10px;">

	<div style="padding: 0px 0px; font-size: 20px; font-weight: bold;">
	   치식 번호: <span id="jointNumLabel"></span> 개 [ <span id="selectedButtonsLabel"></span> ] 
	</div>
	
	
	<div id="imageWrapper">
	  <img id="patientImage" src="/o/teeth-web/images/teeth.png" alt="Patient Teeth" draggable="false" />
	</div>
	
	<div class="treatment-row">
	  <!-- 날짜 선택 -->
	  <div class="treatment-box-date option-group">
	    <label for="treatmentDate"><strong>Date 입력</strong></label><br>
	    <input type="date" name="treatmentDate" id="treatmentDate" min="2025-01-01" max="">
	    <span id="ageDiff" style="margin-left: 15px; font-size: 1rem; color: #555;"></span>
	  </div>
	  
	<script>
	  const today = new Date().toISOString().split("T")[0];
	  document.getElementById("treatmentDate").max = today;
	
	  // 생년월일 설정 (예시로 2025년 1월 1일)
	  const birth = new Date("2025-01-01");
	  
	  let matched = []; // 전역에서 선언
	
	  document.getElementById("treatmentDate").addEventListener("change", function () {
		const dateStr = document.getElementById("treatmentDate").value;
		console.log("입력된 문자열:", dateStr);
		
		const dateObj = new Date(dateStr); // 문자열을 Date 객체로 변환
	    console.log("Date 객체:", dateObj);
		
		
	    let years = dateObj.getFullYear() - birth.getFullYear();
	    let months = dateObj.getMonth() - birth.getMonth();
	    let days = dateObj.getDate() - birth.getDate();
	      console.log("연도 (getFullYear):", years);
	      console.log("월 (getMonth):", months); // 실제 월
	      console.log("일 (getDate):", days);
	    
	
	    console.log("원본 차이:",years,"년",months,"개월" ,days,"일");
	
	
	
	    const resultText = "생후 " + years + " Y " + months + " M " + days + " D 경과";
	    document.getElementById("ageDiff").textContent = resultText;
	    
	    const regions = teethsParam.split(',')
	      .map(n => n.trim())
	      .filter(n => n)
	      .map(n => 'Teeth' + n);
	    
	    
	    //const regions = teethsParam.split(',');
	    
	    console.log('regions:', regions);

	    // allHistoryData에서 date와 region이 일치하는 항목만 골라냄
	    matched = allHistoryData.filter(item =>
	      item.date === dateStr && regions.includes(item.region)
	    );

	    console.log("해당 날짜·치아 일치 이력(클라이언트 필터링):", matched);
	    // 이제 matched 배열을 isStatusDuplicate 등에 활용하세요.

	 // --- matched: 서버에서 가져온 기존 이력 배열 ---
	 // matched = [
	 //   { date: '2025-05-14', treatment: 'RF,Apexo', state: 'W,E', region: 'Teeth63' },
	 //   …
	 // ]

	 // 1. matched 배열에서 이미 사용된 치료(status)와 부위(permanent) 값 추출
	 const usedStatuses   = new Set();
	 const usedPermanents = new Set();



	 // 3. 모든 permanent 그룹 버튼에도 동일하게 적용
//	     (permanentC, permanentDD 두 그룹 모두)

	// 2) permanentC 라디오 그룹의 모든 value
	const permanentCValues = ['C1','C2','C3'];
	
	// 3) 그룹 중 하나라도 사용되었는지 판정
	const disablePermanentCGroup = permanentCValues.some(v => usedPermanents.has(v));
	
	// 4) permanentC 라디오 버튼 전체를 disable/enable
	document.querySelectorAll('input[name="permanentC"]').forEach(radio => {
	  radio.disabled = disablePermanentCGroup;
	});
	 
	 document.querySelectorAll('input[name="permanentDD"]').forEach(input => {
	   if (usedPermanents.has(input.value)) {
	     input.disabled = true;
	   } else {
	     input.disabled = false;
	   }
	 });

	  });
	</script>


	
	
	</div>
	
	<div class="separator"></div>
    
    
    <div class="treatment-row">
	 
	<table class="custom-table-outer">
	<tr>
	<td style="width: 120px; text-align: center;">
	State
	</td>
	<td>
		<table class="custom-table">
		
		  <tr>
		   <th rowspan="2" style="background-color: #d4edda;">
			 C (Dental <span style="color: red;">c</span>aries)
			</th>
		    <th colspan="2" style="background-color: #d1ecf1;">
		        DD (<span style="color: red;">D</span>evelopmental <span style="color: red;">D</span>efects of enamel)
		    </th>

		  </tr>
		  <tr>
		  <th style="background-color: #d1ecf1;">
		    M (hypo<span style="color: red;">M</span>ineralization)
		    </th>
		    <th style="background-color: #d1ecf1;">
		    P (hypo<span style="color: red;">P</span>lasia)
		    </th>
		  </tr>
		  <tr>
			<td>
			  <div style="display: grid; grid-template-columns: 1fr 1fr 1fr; gap: 5px;">
			    <label><input type="radio" name="permanentC" value="C1"/> C1</label>
			    <label><input type="radio" name="permanentC" value="C2"/> C2</label>
			    <label><input type="radio" name="permanentC" value="C3"/> C3</label>
			  </div>
			</td>
		    <td>
		   	  <div style="display: grid; grid-template-columns: 1fr 1fr 1fr; gap: 5px;">
			      <label><input type="checkbox" name="permanentDD" value="W"/> W (White)</label>
			      <label><input type="checkbox" name="permanentDD" value="Y"/> Y (Yellow)</label>
			      <label><input type="checkbox" name="permanentDD" value="B"/> B (Brown)</label>
		      </div>
		    </td>
		    <td>
		    	<div style="display: grid; grid-template-columns: 1fr 1fr; gap: 5px;">
			      <label><input type="checkbox" name="permanentDD" value="E"/> E (Enamel)</label>
			      <label><input type="checkbox" name="permanentDD" value="D"/> D (Dentin)</label>
		    	</div>
		    </td>
		    </td>
		  </tr>
		</table>
	 </td>
     </tr>
    </table>
    </div>
    
    <div class="separator"></div>
	
	
	<div class="treatment-row" >
	  <!-- 대분류 -->
	  <table class="custom-table-outer">
	  <tr>
	  <td style="width: 120px; text-align: center;" >
	  treatment
	  </td>
	  <!-- 수복 -->
	  <td>
	  <div id="radioButtonWrapper" class="treatment-box option-group" >
		  <div class="inline-section">
		    <p><strong>예방</strong></p>
		    <div style="border-left: 1px solid #ccc; padding-left: 10px; display: flex; gap: 10px;">
		    <label><input type="checkbox" class="mar-r-2" name="status" value="TFA"/> 불소도포 </label>
		    <label><input type="checkbox" class="mar-r-2" name="status" value="SC" /> 스케일링 </label>
		    </div>
		  </div>
		
		  <!-- 수복 -->
		  <div class="inline-section with-border">
		    <p><strong>수복</strong></p>
		    <div style="border-left: 1px solid #ccc; padding-left: 10px; display: flex; gap: 10px;">
		    <label><input type="checkbox" class="mar-r-2" name="status" value="Seal" /> 실란트 </label>
		    <label><input type="checkbox" class="mar-r-2" name="status" value="AF" /> 아말감 </label>
		    <label><input type="checkbox" class="mar-r-2" name="status" value="RF" /> 레진 </label>
		    <label><input type="checkbox" class="mar-r-2" name="status" value="Gl" /> 글라스아이오노머 </label>
		    <label><input type="checkbox" class="mar-r-2" name="status" value="SS" /> 기성금속관 </label>
		    <label><input type="checkbox" class="mar-r-2" name="status" value="Zr" /> 지르코니아크라운 </label>
		     </div>
		  </div>
	  
	  </div>
	  
	  <!-- 치수 -->
	  <div id="radioButtonWrapper" class="treatment-box option-group">
	  	<div class="inline-section">
	  	<p><strong>외과</strong></p>
	  	<div style="border-left: 1px solid #ccc; padding-left: 10px; display: flex; gap: 10px;">
	    <label><input type="checkbox" class="mar-r-2" name="status" value="Ext"/> 발치</label>
	     <!-- yes일 경우 서술 공간 필요 -->
	    <label><input type="checkbox" class="mar-r-2" name="status" value="oral"/> 구강소수술</label>
	    </div>
	    </div>
	    <div class="inline-section with-border">
	    <p><strong>치수</strong></p>
	    <div style="border-left: 1px solid #ccc; padding-left: 10px; display: flex; gap: 10px;">
	    <label><input type="checkbox" class="mar-r-2" name="status" value="Pulpo"/> Pulpotomy</label>
	    <label><input type="checkbox" class="mar-r-2" name="status" value="Pulpec"/> Pulpectomy</label>
	    <label><input type="checkbox" class="mar-r-2" name="status" value="Apexo"/> Apexogenesis</label>
	    <label><input type="checkbox" class="mar-r-2" name="status" value="Apexi"/> Apexification</label>
	    <label><input type="checkbox" class="mar-r-2" name="status" value="RCT"/> Root canal treatment</label>
	    </div>
	    </div>
	  </div>
	  
	  
	  <!-- 교정 -->
	  <div id="radioButtonWrapper" class="treatment-box option-group">
	  	<div class="inline-section">
	  	<p><strong>전신마취</strong></p>
	  	<div style="border-left: 1px solid #ccc; padding-left: 10px; display: flex; gap: 10px;">
	    <label><input type="checkbox" class="mar-r-2" name="status" value="DOR"/> DOR </label>
	    <label><input type="checkbox" class="mar-r-2" name="status" value="MOR"/> MOR </label>
	    </div>
	    </div>
	    <div class="inline-section with-border">
	    <p><strong>교정</strong></p>
	    <div style="border-left: 1px solid #ccc; padding-left: 10px; display: flex; gap: 10px;">
	    <label><input type="checkbox" class="mar-r-2" name="status" value="firstStraighten"/> 1차교정</label>
	    <label><input type="checkbox" class="mar-r-2" name="status" value="secondStraighten"/> 2차교정</label>
	    <label><input type="checkbox" class="mar-r-2" name="status" value="partialStraighten"/> 부분교정(장치비+월비)</label>
	    <label><input type="checkbox" class="mar-r-2" name="status" value="muscleFunction"/> 근기능장치</label>
	    </div>
	    </div>
	  </div>
	  
	  <!-- 공간유지장치 -->
	  <div id="radioButtonWrapper" class="treatment-box option-group">
	  	<div class="inline-section">
	    <p><strong>공간유지장치</strong></p>
	    <div style="border-left: 1px solid #ccc; padding-left: 10px; display: flex; gap: 10px;">
	    <label><input type="checkbox" class="mar-r-2" name="status" value="BL"/> B-L </label>
	    <label><input type="checkbox" class="mar-r-2" name="status" value="LA"/> L-A </label>
	    <label><input type="checkbox" class="mar-r-2" name="status" value="NHA"/> NHA </label>
	    <label><input type="checkbox" class="mar-r-2" name="status" value="RSM"/> RSM </label>
	    </div>
	    </div>
	    <div class="inline-section with-border">
	    <p><strong>진정</strong></p>
	     <div style="border-left: 1px solid #ccc; padding-left: 10px; display: flex; gap: 10px;">
	    <label><input type="checkbox" class="mar-r-2" name="status" value="N2OSedation"/> N2O흡인진정 </label>
	    <label><input type="checkbox" class="mar-r-2" name="status" value="LASedation"/> 경구진정 </label>
	    <label><input type="checkbox" class="mar-r-2" name="status" value="NHASedation"/> 근육진정 </label>
	    <label><input type="checkbox" class="mar-r-2" name="status" value="RSMSedation"/> 정주진정 </label>
	    </div>
	    </div>
	  </div>
	  
	  </td>
	  </tr>
	  </table>
	</div>
	
    <div  class="treatment-column" >
	    <button id="addTreatmentBtn" type="button" style="padding: 5px 15px; font-size:15px;" disabled>
	      Add Record
	    </button>
	    <button id="clearSelectionsBtn" type="button" style="padding: 5px 15px; font-size:15px; margin-left: 10px;">
		 Clear
  		 </button>
	</div>
	
	
	
	<div class="separator"></div>
	
	

	
	<div style="padding: 0px 20px; font-size: 20px; font-weight: bold;">
	   진료 기록
	</div>
	
	<input type="hidden" id="namespace" value="<portlet:namespace/>"/>
	
	<div id="historyContainer"></div>
	
	<table id="treatmentTable" style="width:90%; border-collapse: collapse; margin: 0 auto;">
	  <thead>
	    <tr>
	      <th style="border:1px solid #ccc; padding:8px;">Teeth</th> 
	      <th style="border:1px solid #ccc; padding:8px;">Date</th>   
	      <th style="border:1px solid #ccc; padding:8px;">State</th>
	      <th style="border:1px solid #ccc; padding:8px;">Treatment</th>
	      <th style="border:1px solid #ccc; padding:8px;">Action</th>
	    </tr>
	  </thead>
	  <tbody>
	    <!-- JS가 여기에 <tr>를 추가 -->
	  </tbody>
	</table>
	
	<div style="margin-top: 20px;" id="historyContainer"></div>
	
	<div style="text-align: center; font-size: 16px;">
	   하단의 Save 버튼을 누르면 추가했던 데이터들이 데이터 베이스에 저장됩니다.<br/><br/>
	  cancel 버튼을 누르면 현재 작업을 취소하고 팝업을 닫습니다.
	</div>
	
	 
	
	
	
	
	<div class="treatment-column" style="justify-content: center; margin-top: 20px; margin-bottom: 20px;">
	  <button id="addDBBtn" type="button" style="padding: 5px 15px; font-size: 15px;">Save</button>
	  <button id="cancelBtn" type="button" style="padding: 5px 15px; font-size: 15px; margin-left: 5px;">Back</button>
	</div>

</div>


<script src="/o/teeth-web/js/treatment.js"></script>

<c:set var="initialTeeths" value="${param.teeths}" />
<script>
  var INITIAL_TEETHS = '${initialTeeths}'; //jstl로 처리 
</script>
</body>
</html>
