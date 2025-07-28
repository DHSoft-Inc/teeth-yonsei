package teeth.Dentistry.portlet;

import teeth.Dentistry.constants.TeethDentistryPortletKeys;
import teeth.model.TreatmentHistory;
import teeth.service.TreatmentHistoryLocalServiceUtil;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;

import java.util.List;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;

/**
 * @author User
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.header-portlet-css=/css/main.css",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=TeethDentistry",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/teeth/view/teethview.jsp",
		"javax.portlet.name=" + TeethDentistryPortletKeys.TEETHDENTISTRY,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class TeethDentistryPortlet extends MVCPortlet {
	@Override
    public void render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
		try 
		{
			long PatientID = 1001; 
			boolean isPermanent = false;
			isPermanent = processTeethRange(renderRequest, PatientID, 11, 48, true, isPermanent);
			isPermanent = processTeethRange(renderRequest, PatientID, 51, 85, false, isPermanent);
			
			renderRequest.setAttribute("patientID", PatientID);
			renderRequest.setAttribute("isPermanent", isPermanent);
			
			super.render(renderRequest, renderResponse);
		}
		catch(Exception e)
		{
			_log.info("Error During Render MainPage!");
			e.printStackTrace();
		}
	}
	
	private boolean processTeethRange(RenderRequest Request, long PatientID, long from, long to, boolean checkPermanent, boolean isPermanent)
	{
		for(long i = from; i <= to; i++)
		{
			List<TreatmentHistory> HT = TreatmentHistoryLocalServiceUtil.getPatientTreatmentListByTeethNum(PatientID, i);
			if (checkPermanent && !HT.isEmpty()) 
			{
				isPermanent = true;
			}
			Request.setAttribute("teeth" + i, HT);
	        //_log.info("teeth" + i + " : " + HT);
		}
		return isPermanent;
	}
	Log _log = LogFactoryUtil.getLog(TeethDentistryPortlet.class);
}