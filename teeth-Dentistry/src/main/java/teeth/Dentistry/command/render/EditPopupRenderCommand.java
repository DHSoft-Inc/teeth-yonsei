package teeth.Dentistry.command.render;

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

import teeth.Dentistry.constants.TeethDentistryPortletKeys;
import teeth.model.TreatmentHistory;
import teeth.service.TreatmentHistoryLocalServiceUtil;



@Component(
	       immediate = true,
	       property = {
	   			"javax.portlet.name="+ TeethDentistryPortletKeys.TEETHDENTISTRY,
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
	      
	      List<TreatmentHistory> EditHistoryList = new ArrayList<>(); // 寃곌낵臾쇰줈 �쟾�넚�맆 TreatmentHistory List 
	      List<Long> IDList = new ArrayList<>(); // �뙆�떛�맂 ID �꽔�뒗 List
	      
	      // TreatmentIDList濡� 諛쏆� IDList瑜� �뙆�떛
	      if (TreatmentIDList != null && !TreatmentIDList.isEmpty()) {
	          // �돹�몴濡� 遺꾨━
	          String[] tokens = TreatmentIDList.split(",");
	          for (String token : tokens) {
	              // �샊�떆 怨듬갚�씠 �꽎�뿬�엳�쓣 寃쎌슦瑜� ��鍮꾪빐 trim()
	              token = token.trim();
	              if (!token.isEmpty()) {
	                  // Long�쑝濡� 蹂��솚 �썑 由ъ뒪�듃�뿉 異붽�
	                  IDList.add(Long.parseLong(token));
	              }
	          }
	      }
	      _log.info("Parsed IDList: " + IDList);
	      
	      // �뙆�떛�맂 ID瑜� �넗��濡� EditHistory List�뿉 TreatmentHistory 異붽�
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
