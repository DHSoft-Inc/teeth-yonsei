package teeth.web.command.render;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;

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
			"javax.portlet.name="+ TeethWebPortletKeys.TEETHWEB,
			"mvc.command.name=/teeth/teethView"
		},
		service = MVCRenderCommand.class
	)
public class TeethviewRenderCommand implements MVCRenderCommand {

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
		// TODO Auto-generated method stub
		long PatientID = 1001; //임시 PatientID
		List<TreatmentHistory> HistoryList = TreatmentHistoryLocalServiceUtil.getPatientTreatmentList(PatientID);
		boolean isPermanent = false;
		try
		{
			// 영구치(11~18, 21~28, 31~38, 41~48)는 checkPermanent=true
			processTeethRange(renderRequest, PatientID, 11, 48, true, isPermanent);

			// 유치(51~55, 61~65, 71~75, 81~85)는 검사 없이 그냥 세팅
			processTeethRange(renderRequest, PatientID, 51, 85, false, isPermanent);
			
			renderRequest.setAttribute("patientID", PatientID);
			renderRequest.setAttribute("HistoryList", HistoryList);
			
			if(isPermanent == true)
			{
				return "/teeth/view/permanentTeethview.jsp";
			}
			else
			{
				return "/teeth/view/deciduousTeethview.jsp";
			}
		}
		catch(Exception e)
		{
			_log.info("Error During TeethView!");
		}
		
		
		return null;
	}
	
	private void processTeethRange(RenderRequest renderRequest, long PatientID, long from, long to, boolean checkPermanent, boolean isPermanent)
	{
		for(long i = from; i <= to; i++)
		{
			List<TreatmentHistory> HT = TreatmentHistoryLocalServiceUtil.getPatientTreatmentListByTeethNum(PatientID, i);
			if (checkPermanent && !HT.isEmpty()) 
			{
				isPermanent = true;
			}
			renderRequest.setAttribute("teeth" + i, HT);
	        _log.info("teeth" + i + " : " + HT);
			
		}
	}
	Log _log = LogFactoryUtil.getLog(TeethviewRenderCommand.class);
}
