<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../../init.jsp"%>
<%@ page import="teeth.web.dto.DisplayHistory"%>
<%@ page import="java.util.List"%>
<%@ page import="javax.portlet.PortletURL"%>
<%@ page import="java.text.SimpleDateFormat"%>
<portlet:defineObjects />
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>

<%
	String regionName = (String) request.getAttribute("regionName");
	List<DisplayHistory> displayList = (List<DisplayHistory>) request.getAttribute("displayList");
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
%>

<div id="historyTooltipWrapper">
	<aui:row>
		<aui:col>
			<liferay-ui:search-container total="<%= displayList.size() %>" emptyResultsMessage="No Treatments Yet.">
				<liferay-ui:search-container-results results="<%=displayList%>" />
				<liferay-ui:search-container-row
					className="teeth.web.dto.DisplayHistory"
					modelVar="treatment">
					<liferay-ui:search-container-column-text name="Treatment Date" value="<%=sdf.format(treatment.getDate())%>" />
					<liferay-ui:search-container-column-text name="Age at Tx." value="<%=treatment.getAgeYears() + " 년 " + treatment.getAgeMonths() + " 개월 "%>" />
					<liferay-ui:search-container-column-text name="State"
						value="<%=treatment.getStatus()%>" />
					<liferay-ui:search-container-column-text name="Treatments"
						value="<%=treatment.getTreatmnetStringList()%>" />
				</liferay-ui:search-container-row>
				<liferay-ui:search-iterator paginate="false" />
			</liferay-ui:search-container>
		</aui:col>
	</aui:row>
</div>