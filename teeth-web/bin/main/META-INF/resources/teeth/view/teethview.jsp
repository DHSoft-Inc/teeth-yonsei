<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../../init.jsp"%>

<%
	Boolean isPermanent = (Boolean) renderRequest.getAttribute("isPermanent");
	Long patientID = (Long) request.getAttribute("patientID");
	if(patientID == null) { patientID = 1001L; }
%>

<portlet:renderURL var="totalTeethURL">
	<portlet:param name="mvcRenderCommandName" value="/teeth/totalTeethView"/>
	<portlet:param name="PatientID" value="<%=String.valueOf(patientID)%>" />
</portlet:renderURL>

<portlet:renderURL var="deciduousTeethURL">
	<portlet:param name="mvcRenderCommandName" value="/teeth/deciduousTeethView"/>
	<portlet:param name="PatientID" value="<%=String.valueOf(patientID)%>" />
</portlet:renderURL>

<c:choose>
    <c:when test="${requestScope.isPermanent}">
        <script type="text/javascript">
            window.location.href='${totalTeethURL}';
        </script>
    </c:when>
    <c:otherwise>
        <script type="text/javascript">
            window.location.href='${deciduousTeethURL}';
        </script>
    </c:otherwise>
</c:choose>