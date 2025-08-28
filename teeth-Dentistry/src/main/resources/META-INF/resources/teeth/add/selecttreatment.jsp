<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="../../init.jsp" %>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<style>
  .demo-wrap {
    border: 3px solid #9a9a9a;
    background: #f2f2f2;
    padding: 32px 24px 48px;
    border-radius: 6px;
  }
  .section {
    max-width: 760px;
    margin: 0 auto 56px;
  }
  .SectionTitle {
    font-size: 48px;
    font-weight: 700;
    letter-spacing: .5px;
    margin: 8px 0 18px;
  }
  .item-row {
    display: flex;
    align-items: center;
    justify-content: space-between;
    gap: 16px;

    border: 2px solid #8e8e8e;
    background: #e9e9e9;
    border-radius: 4px;

    padding: 10px 12px;
    margin: 12px 0;
    box-shadow: 0 1px 0 rgba(0,0,0,0.15) inset;
  }
  .item-label {
    font-size: 28px;
    font-weight: 600;
    line-height: 1.2;
    color: #222;
    flex: 1;
    white-space: nowrap;
    overflow: hidden;
    text-overflow: ellipsis;
  }
  .action-btn.btn {
    font-size: 18px;
    padding: 8px 18px;
    min-width: 120px;
  }
  @media (max-width: 480px) {
    .section-title { font-size: 36px; }
    .item-label { font-size: 22px; }
    .action-btn.btn { min-width: 100px; }
  }
</style>


<%
    String portalURL = themeDisplay.getPortalURL();
    String contextPath = themeDisplay.getPathContext();
    String teethArrStr = request.getParameter("teethArrStr");
    String teethsParam = request.getParameter("teeths");
    long numOfTeeth = (long) request.getAttribute("numOfTeeth");
%>

<!-- RenderURL -->
<!-- Canal -->
<portlet:renderURL var="Canal_PreOP" windowState="pop_up">
	<portlet:param name="mvcRenderCommandName" value="/add/addTreatment" />
	<portlet:param name="teethArrStr" value="<%= teethArrStr %>" />
	<portlet:param name="teethsParam" value="<%= teethsParam %>" />
	<portlet:param name="numOfTeeth" value="<%=String.valueOf(numOfTeeth) %>" />
	<portlet:param name="mode" value="Canal_PreOP" />
</portlet:renderURL>
<portlet:renderURL var="Canal_IntraOP" windowState="pop_up">
	<portlet:param name="mvcRenderCommandName" value="/add/addTreatment" />
	<portlet:param name="teethArrStr" value="<%= teethArrStr %>" />
	<portlet:param name="teethsParam" value="<%= teethsParam %>" />
	<portlet:param name="numOfTeeth" value="<%=String.valueOf(numOfTeeth) %>" />
	<portlet:param name="mode" value="Canal_IntraOP" />
</portlet:renderURL>
<portlet:renderURL var="Canal_PostOP" windowState="pop_up">
	<portlet:param name="mvcRenderCommandName" value="/add/addTreatment" />
	<portlet:param name="teethArrStr" value="<%= teethArrStr %>" />
	<portlet:param name="teethsParam" value="<%= teethsParam %>" />
	<portlet:param name="numOfTeeth" value="<%=String.valueOf(numOfTeeth) %>" />
	<portlet:param name="mode" value="Canal_PostOP" />
</portlet:renderURL>
<!-- Resin -->
<portlet:renderURL var="Resin_PreOP" windowState="pop_up">
	<portlet:param name="mvcRenderCommandName" value="/add/addTreatment" />
	<portlet:param name="teethArrStr" value="<%= teethArrStr %>" />
	<portlet:param name="teethsParam" value="<%= teethsParam %>" />
	<portlet:param name="numOfTeeth" value="<%=String.valueOf(numOfTeeth) %>" />
	<portlet:param name="mode" value="Resin_PreOP" />
</portlet:renderURL>
<portlet:renderURL var="Resin_OperativePrecedure" windowState="pop_up">
	<portlet:param name="mvcRenderCommandName" value="/add/addTreatment" />
	<portlet:param name="teethArrStr" value="<%= teethArrStr %>" />
	<portlet:param name="teethsParam" value="<%= teethsParam %>" />
	<portlet:param name="numOfTeeth" value="<%=String.valueOf(numOfTeeth) %>" />
	<portlet:param name="mode" value="Resin_OperativePrecedure" />
</portlet:renderURL>
<portlet:renderURL var="Resin_FU" windowState="pop_up">
	<portlet:param name="mvcRenderCommandName" value="/add/addTreatment" />
	<portlet:param name="teethArrStr" value="<%= teethArrStr %>" />
	<portlet:param name="teethsParam" value="<%= teethsParam %>" />
	<portlet:param name="numOfTeeth" value="<%=String.valueOf(numOfTeeth) %>" />
	<portlet:param name="mode" value="Resin_FU" />
</portlet:renderURL>


<div class="SelectTreatment">
	<div class = "TeethNumShow" style="padding: 0px 0px; font-size: 20px; font-weight: bold;">
	   	치식 번호: <%= numOfTeeth %> 개 [ <%=teethsParam %> ] 
	</div>
	<div class = "SelectArea">
		<section class = "CanalArea">
			<div class = "SectionTitle">Canal</div>
			<div class="item-row">
				<div class="item-label">1. Pre-op</div>
				<aui:button cssClass="btn btn-primary action-btn" type="button" value="button" onClick="<%= Canal_PreOP %>"/>
			</div>

			<div class="item-row">
				<div class="item-label">2. Intra-op</div>
				<aui:button cssClass="btn btn-primary action-btn" type="button" value="button" onClick="<%= Canal_IntraOP %>"/>
			</div>

			<div class="item-row">
				<div class="item-label">3. Post-op</div>
				<aui:button cssClass="btn btn-primary action-btn" type="button" value="button" onClick="<%= Canal_PostOP %>"/>
			</div>
		</section>
		<section class = "ResinArea">
			<div class = "SectionTitle">Resin</div>
			<div class="item-row">
				<div class="item-label">1. Pre-op</div>
				<aui:button cssClass="btn btn-primary action-btn" type="button" value="button" onClick="<%= Resin_PreOP %>"/>
			</div>

			<div class="item-row">
				<div class="item-label">2. Operative Precedure</div>
				<aui:button cssClass="btn btn-primary action-btn" type="button" value="button" onClick="<%= Resin_OperativePrecedure %>"/>
			</div>

			<div class="item-row">
				<div class="item-label">3. Resin Filling - f/u </div>
				<aui:button cssClass="btn btn-primary action-btn" type="button" value="button" onClick="<%= Resin_FU %>"/>
			</div>
		</section>
	</div>
	
	
</div>