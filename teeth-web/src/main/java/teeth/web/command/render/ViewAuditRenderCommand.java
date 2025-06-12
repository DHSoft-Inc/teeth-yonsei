package teeth.web.command.render;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.util.ParamUtil;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;

import teeth.model.TreatmentAudit;
import teeth.service.TreatmentAuditLocalServiceUtil;
import teeth.web.constants.TeethWebPortletKeys;


@Component(
       immediate = true,
       property = {
           "javax.portlet.name=" + TeethWebPortletKeys.TEETHWEB,
           "mvc.command.name=/teeth/viewAuditTrail"
       },
       service = MVCRenderCommand.class
   )
public class ViewAuditRenderCommand implements MVCRenderCommand {

   @Override
   public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
      // TODO Auto-generated method stub
      
      String mode = ParamUtil.getString(renderRequest, "mode");
      _log.info("mode: " + mode);
      
      List<TreatmentAudit> DisplayList = new ArrayList<>();
      
      if(mode.equals("All"))
      {
         DisplayList = TreatmentAuditLocalServiceUtil.getTreatmentAudits(-1, -1);
      }
      else if(mode.equals("Teeth"))
      {
         long TeethNum = ParamUtil.getLong(renderRequest, "teethNum");
         _log.info("Teeth: " + TeethNum);
         DisplayList = TreatmentAuditLocalServiceUtil.getAuditByTeethNum(TeethNum);
         renderRequest.setAttribute("teethNum", TeethNum); 
      }
      
      	DisplayList = new ArrayList<>(DisplayList);
      
        DisplayList.sort(Comparator.comparing(TreatmentAudit::getEditedDate).reversed());
      
        _log.info("Audit DisplayList: " + DisplayList);
      
      renderRequest.setAttribute("mode", mode); 
      renderRequest.setAttribute("DisplayList", DisplayList);
      
      
      return "/teeth/view/auditPopup.jsp";
   }
   Log _log = LogFactoryUtil.getLog(ViewAuditRenderCommand.class);
}
