package teeth.web.command.render;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.util.ParamUtil;

import java.util.ArrayList;
import java.util.List;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;

import teeth.model.TreatmentHistory;
import teeth.service.TreatmentHistoryLocalServiceUtil;
import teeth.web.constants.TeethWebPortletKeys;


@Component(
       immediate = true,
       property = {
           "javax.portlet.name=" + TeethWebPortletKeys.TEETHWEB,
           "mvc.command.name=/teeth/editHistoryPopup"
       },
       service = MVCRenderCommand.class
   )
public class EditPopupRenderCommand implements MVCRenderCommand {

   @Override
   public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
      // TODO Auto-generated method stub
      
      String TreatmentIDList = ParamUtil.getString(renderRequest, "TreatmentID");
      _log.info("Received TreatmentIDList: " + TreatmentIDList);
      
      List<TreatmentHistory> EditHistoryList = new ArrayList<>(); // 결과물로 전송될 TreatmentHistory List 
      List<Long> IDList = new ArrayList<>(); // 파싱된 ID 넣는 List
      
      // TreatmentIDList로 받은 IDList를 파싱
      if (TreatmentIDList != null && !TreatmentIDList.isEmpty()) {
          // 쉼표로 분리
          String[] tokens = TreatmentIDList.split(",");
          for (String token : tokens) {
              // 혹시 공백이 섞여있을 경우를 대비해 trim()
              token = token.trim();
              if (!token.isEmpty()) {
                  // Long으로 변환 후 리스트에 추가
                  IDList.add(Long.parseLong(token));
              }
          }
      }
      _log.info("Parsed IDList: " + IDList);
      
      // 파싱된 ID를 토대로 EditHistory List에 TreatmentHistory 추가
      for (Long ID : IDList)
      {
         try {
            TreatmentHistory TH = TreatmentHistoryLocalServiceUtil.getPatientTreatmentByTreatmentID(ID);
            EditHistoryList.add(TH);
         } catch(Exception e)
         {
            _log.info("Error During making List; ID: " + ID);
            e.printStackTrace();
         }
      }
      
      _log.info("Completed EditHistory List: " + EditHistoryList);
      
      renderRequest.setAttribute("EditHistoryList", EditHistoryList); //TreatmentHistory List
      
      
      return "/teeth/edit/editHistoryPopup.jsp";
   }
   Log _log = LogFactoryUtil.getLog(EditPopupRenderCommand.class);
}
