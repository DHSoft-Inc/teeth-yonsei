package teeth.web.portlet;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;

import java.io.IOException;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;

import teeth.model.TreatmentHistory;
import teeth.service.TreatmentHistoryLocalServiceUtil;
import teeth.web.constants.TeethWebPortletKeys;

/**
 * @author User
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.header-portlet-css=/css/main.css",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=TeethWeb",
		"javax.portlet.init-param.copy-request-parameters=true",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/teeth/view/teethview.jsp",
		"javax.portlet.name=" + TeethWebPortletKeys.TEETHWEB,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class TeethWebPortlet extends MVCPortlet {

	@Override
    public void render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
		try 
		{
			long PatientID = 1001; //임시 PatientID
			boolean isPermanent = false;
			// 영구치(11~18, 21~28, 31~38, 41~48)는 checkPermanent=true
			isPermanent = processTeethRange(renderRequest, PatientID, 11, 48, true, isPermanent);

			// 유치(51~55, 61~65, 71~75, 81~85)는 검사 없이 그냥 세팅
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
	Log _log = LogFactoryUtil.getLog(TeethWebPortlet.class);
}