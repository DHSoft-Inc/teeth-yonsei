<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../../init.jsp"%>

<%!Log _log = LogFactoryUtil.getLog("/teeth/permanentTeethview.jsp");%>

<style>
#imageWrapper {
	position: relative;
	width: auto;
	max-width: none;
	margin: 0 auto;
	
	aspect-ratio: 2806 / 963;
}
</style>

<%
	Long patientID = (Long) request.getAttribute("patientID");
	if(patientID == null) { patientID = 1001L; }
	
	List<TreatmentHistory> historyList = (List<TreatmentHistory>) request.getAttribute("HistoryList");
	
	List<TreatmentHistory>[] RL = new List[49];
	for(int i = 11; i <= 48; i++)
	{
		RL[i] = (List<TreatmentHistory>) request.getAttribute("teeth" + i);
	}
	
	// RL에 있는 List<TreatmentHistory>를 PortletSession 에 Map 형태로 저장
	java.util.Map<Integer, java.util.List<TreatmentHistory>> rlMap = new java.util.HashMap<>();

	for (int i = 11; i <= 48; i++) {
		if (RL[i] != null) {
			rlMap.put(i, RL[i]);
		}
	}
	portletSession.setAttribute("rlMap", rlMap, PortletSession.PORTLET_SCOPE);
	
	// JS에 약어 및 색 display용 historyList 설정
	// (1) historyList → JSONArray 생성
	SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
	JSONArray historyJson = JSONFactoryUtil.createJSONArray();

	for (TreatmentHistory th : historyList) {
		JSONObject obj = JSONFactoryUtil.createJSONObject();
		obj.put("region", "Teeth" + th.getTeethNum());
		obj.put("treatment", th.getTreatment());
		obj.put("date", fmt.format(th.getTreatmentDate()));
		obj.put("state", th.getState());
		historyJson.put(obj);
	}
	
	LiferayPortletURL baseURL = PortletURLFactoryUtil.create(request, themeDisplay.getPortletDisplay().getId(), themeDisplay.getPlid(), PortletRequest.RENDER_PHASE);
%>

<!-- RenderURL -->
<!-- Add Tooth Popup -->
<portlet:renderURL var="openDialogURL"
	windowState="<%=LiferayWindowState.POP_UP.toString()%>">
	<portlet:param name="mvcRenderCommandName" value="/render/add_tooth_treatment" />
	<portlet:param name="test" value="test" />
</portlet:renderURL>
<!-- View Audit Popup -->
<portlet:renderURL var="ViewAuditURL" windowState="pop_up">
	<portlet:param name="mvcRenderCommandName" value="/teeth/viewAuditTrail" />
	<portlet:param name="mode" value="All" />
</portlet:renderURL>

<portlet:renderURL var="HistoryPopUpURL" windowState="pop_up">
	<portlet:param name="mvcRenderCommandName" value="/teeth/historyPopup" />
	<portlet:param name="PatientID" value="<%=String.valueOf(patientID)%>" />
</portlet:renderURL>

<portlet:renderURL var="ViewDeciduousTeeth">
	<portlet:param name="mvcRenderCommandName" value="/teeth/deciduousTeethView"/>
	<portlet:param name="PatientID" value="<%=String.valueOf(patientID)%>" />
</portlet:renderURL>

<portlet:renderURL var="ViewTotalTeeth">
	<portlet:param name="mvcRenderCommandName" value="/teeth/totalTeethView"/>
	<portlet:param name="PatientID" value="<%=String.valueOf(patientID)%>" />
</portlet:renderURL>

<%-- Resource URLs --%>
<%-- /teeth/getHistory 리소스 커맨드 호출용 --%>
<portlet:resourceURL var="historyJsonUrl">
	<portlet:param name="mvcResourceCommandName" value="/teeth/getHistory" />
</portlet:resourceURL>
<%-- /teeth/tooltip 리소스 커맨드용 --%>
<portlet:resourceURL id="/teeth/tooltip" var="tooltipURL"/>

<div class="TeethView">
	<h1>Teeth Image Demo</h1>

	<!-- Add 연산용 내부 div -->
	<div style="display: none;">
		Selected Tooth: <span id="selectedButtonsLabel"></span><br />
		Num of Selected Tooth: <span id="jointNumLabel">0</span>
	</div>

	<!-- 조작 설명용 div -->
	<table class="info-table">
	  	<tr>
	  		<td colspan="4">영구치의 진료 기록이 있는 경우, 해당 위치의 유치는 선택 불가</td>
	  	</tr>
	  	<tr>
	    	<td colspan="2">치식을 좌클릭 혹은 드래그: 해당 치식을 선택(빨간색으로 표시)</td>
	    	<td colspan="2">치식을 우클릭: 클릭한 치식의 정보 확인(팝업창으로 표시)</td>
	  	</tr>
	  	<tr>
	    	<td colspan="2"><span style="color:rgba(0,0,255,1)">파란색</span>: Seal, AF, RF, GI, SS, Zr, Pulpo, Pulpec, Apexo, Apexl, RCT, Ext</td>
	    	<td><span style="color:rgba(255,165,0,1)">노란색</span>: W, Y, B, E, D</td>
	    	<td><span style="color:rgba(0,128,0,1)">초록색</span>: 그 외의 Treatment & State</td>
	  	</tr>
	  	<tr>
	    	<td colspan="2">View Full Audit: 모든 치식의 변경 기록 조회</td>
	    	<td colspan="2">View Permanent/Deciduous Teeth: 영구치 표시 화면 변경</td>
	  	</tr>
	  	
	</table>

	<!-- teeth image 출력용 div -->
	<div id="imageWrapper">
	
		<!-- tooltip 출력용 div -->
		<div id="tooltipContainer"
			style="position: absolute; display: none; z-index: 9999; background: #fff; border: 1px solid #ccc; padding: 8px; box-shadow: 0 2px 8px rgba(0, 0, 0, 0.2);">
		</div>
	</div>

	<!-- 약어 display용 내부 div -->
	<div id="historyContainer" style="display: none;"></div>

	<%
		String addBtnOnClickStr = String.format("openDialog('%s', '%s')", themeDisplay.getPortletDisplay().getId(),
				baseURL.toString());
		_log.info(addBtnOnClickStr);
	%>


	<!-- 하단 버튼용 div -->
	<div id="addTWrapper">
		<aui:input type="hidden" name="teeths" value="" />
		<aui:button-row>
			<aui:button id="addBtn" type="button" cssClass="btn btn-primary" name="addBtn" onClick="<%=addBtnOnClickStr%>" value="Add Treatment" />
			<aui:button type="button" cssClass="btn btn-primary" value="View Full Audit" onClick="openViewAuditModal()" />
			<aui:button type="button" cssClass="btn btn-secondary" value="View Deciduous Teeth" onClick="<%= ViewDeciduousTeeth %>" />
			<aui:button type="button" cssClass="btn btn-secondary" value="View Every Teeth" onClick="<%= ViewTotalTeeth %>" />
		</aui:button-row>
	</div>
</div>




<!-- JS 사용 전 historyList 설정 script -->
<script>
	const NAMESPACE = '<portlet:namespace />';
	var $teethInput = $('#' + NAMESPACE + 'teeths');
	const tooltipResourceURL = '<%=tooltipURL.toString()%>';
	console.log('$teethInput length =', $teethInput.length);

	// (2) JSP 에서 만든 JSON 을 JS 에 파싱
	const initialHistoryArray = <%=historyJson.toString()%>;

	// (3) regionName 별로 묶어서 Map 생성, 날짜 순 정렬 후 최신 1개만 남김
	const historyMap = {};
	initialHistoryArray.forEach(item => {
		const reg = item.region;
		historyMap[reg] = historyMap[reg] || [];
		historyMap[reg].push(item);
	});
	Object.keys(historyMap).forEach(reg => {
		historyMap[reg].sort((a, b) => new Date(a.date) - new Date(b.date));
		historyMap[reg] = historyMap[reg].slice(-1);
	});
	
</script>

<!-- JS파일을 불러옴 -->
<script	src="<%=request.getContextPath()%>/js/permanent_teeth.js"></script>

<script>
	Liferay.provide(window, "openDialog", function(namespace, baseURL) {
		const teethElem = $("#_"+namespace+"_teeths");
		const teethVal = teethElem.val();
		const teethValNum = teethVal.replace("Teeth", ""); 
		var selectedTeeth = document.getElementById('selectedButtonsLabel').textContent; 
		console.log("teeth val : ", teethVal);
		
		var url = Liferay.Util.PortletURL.createRenderURL(baseURL, {
			"p_p_id": namespace,
         	"p_auth": Liferay.authToken,
         	"p_p_state": "pop_up",
         	"teeths" : selectedTeeth,
         	"test": "test",
         	"mvcRenderCommandName": "/render/add_tooth_treatment"
         });
		console.log(url);
		Liferay.Util.openWindow({
			dialog: {
				destroyOnClose: true,
				centered: true,
				modal:true,
				resizable: true,
				height:900,
				width:1200
			},
			id: "addTreatmentDialog",
			title: "Add Treatment ",
			uri: url.toString()
		});
	}, ['liferay-portlet-url'] );
	
	Liferay.provide(window, "closeDialog", function(dialogId) {
	var dialog = Liferay.Util.Window.getById(dialogId);
	dialog.destroy();
	}, ['aui-base'] );

</script>

<!-- script랑 aui:script랑 합치면 안될거 같아서 분리시킨 대로 그대로 사용 -->
<aui:script>
	//Open Record Popup
	window.openHistoryModal = function(regionName) {
		var baseURL = '<%= HistoryPopUpURL.toString() %>';
		var DisplayRegionName = regionName.replace(/(\D+)(\d+)/, '$1 $2');
		// regionName 파라미터만 붙여 URL 완성
		var historyURL = Liferay.Util.PortletURL.createRenderURL(baseURL, { regionName: regionName });

		// 모달 팝업 실행
		Liferay.Util.openWindow({
			dialog: {
				centered: true,
				width: 1200,
				height: 600,
				resizable: false
			},
			title: 'Treatment Record: ' + DisplayRegionName,
			uri: historyURL
		});
		
		setTimeout(() => {	// hide tooltip if visible
			document.getElementById('tooltipContainer').style.display = 'none';	
		}, 300);
	};

	//imageWrapper 내 모든 region에 우클릭 리스너 부착
  	// DOM이 준비되면 콜백 실행
	$(function() {
	// imageWrapper 전체에 contextmenu 이벤트를 위임
		$('#imageWrapper').on('contextmenu', '.region', function(e) {
			e.preventDefault();
			// this는 우클릭된 .region 요소
			openHistoryModal($(this).data('name'));
		});
	});

	//Open Audit Popup
	window.openViewAuditModal = function () {
		console.log("openViewAuditModal");
        Liferay.Util.openWindow({
			dialog: {
				centered: true,
				width: 1200,
				height: 600,
				resizable: false
			},
			title: 'View Full Audit',
			uri: '<%=ViewAuditURL%>'
		});
	};
</aui:script>