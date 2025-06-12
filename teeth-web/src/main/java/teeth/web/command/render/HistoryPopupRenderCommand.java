package teeth.web.command.render;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.util.ParamUtil;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;

import teeth.model.TreatmentHistory;
import teeth.service.TreatmentHistoryLocalServiceUtil;
import teeth.web.constants.TeethWebPortletKeys;
import teeth.web.dto.DisplayHistory;


@Component(
       immediate = true,
       property = {
           "javax.portlet.name=" + TeethWebPortletKeys.TEETHWEB,
           "mvc.command.name=/teeth/historyPopup"
       },
       service = MVCRenderCommand.class
   )
public class HistoryPopupRenderCommand implements MVCRenderCommand {

   @Override
   public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
	   	_log.info("Render History!");
        String regionName = ParamUtil.getString(renderRequest, "regionName");
        long patientID = ParamUtil.getLong(renderRequest, "PatientID");
        _log.info("regionName: " + regionName);
        long teethNum = Long.parseLong(regionName.replace("Teeth", ""));
        _log.info("teethNum:" + teethNum);
        List<TreatmentHistory> treatmenthistory = TreatmentHistoryLocalServiceUtil.getPatientTreatmentListByTeethNum(patientID, teethNum);
        _log.info("List: " + treatmenthistory);
        //임시 생년월일
        // 날짜 포맷터 생성
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        
        Date Birth = new Date();
        // 문자열을 파싱해서 Date로 변환
        try {
         Birth = sdf.parse("2025-01-01");
      } catch (ParseException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }
        
        
        List<DisplayHistory> displayList = DisplayHistory.buildDisplayHistoryList(treatmenthistory, Birth);
        
        for(DisplayHistory dh : displayList)
        {
        	if(dh.Status.isEmpty())
        	{
        		dh.setStatus("-");
        	}
        	if(dh.TreatmnetStringList.isEmpty())
        	{
        		dh.setTreatmnetStringList("-");
        	}
        }
        
        displayList.sort(Comparator.comparing(DisplayHistory::getDate).reversed());
        _log.info("DisplayList: " + displayList);
        renderRequest.setAttribute("teethNum", teethNum);
        renderRequest.setAttribute("displayList", displayList);
        renderRequest.setAttribute("regionName", regionName);
        return "/teeth/view/historyPopup.jsp";
      
   } 
   
   Log _log = LogFactoryUtil.getLog(HistoryPopupRenderCommand.class);

}
