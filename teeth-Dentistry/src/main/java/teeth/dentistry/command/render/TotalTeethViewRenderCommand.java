package teeth.dentistry.command.render;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;

import java.util.List;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;

import teeth.dentistry.constants.TeethDentistryPortletKeys;
import teeth.model.TreatmentHistory;
import teeth.service.TreatmentHistoryLocalServiceUtil;




@Component(
		immediate = true,
		property = {
			"javax.portlet.name="+ TeethDentistryPortletKeys.TEETHDENTISTRY,
			"mvc.command.name=/teeth/totalTeethView"
		},
		service = MVCRenderCommand.class
	)
public class TotalTeethViewRenderCommand implements MVCRenderCommand{
	
	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
		// TODO Auto-generated method stub
		long PatientID = 1001; //�엫�떆 PatientID
		List<TreatmentHistory> HistoryList = TreatmentHistoryLocalServiceUtil.getPatientTreatmentList(PatientID);
		try
		{			
			_log.info("TotalTeethView!");
			// �쁺?��?�튂
			processTeethRange(renderRequest, PatientID, 11, 48);

			// ��?移�
			processTeethRange(renderRequest, PatientID, 51, 85);
			
			renderRequest.setAttribute("patientID", PatientID);
			renderRequest.setAttribute("HistoryList", HistoryList);
			
			return "/teeth/view/totalTeethview.jsp";
		}
		catch(Exception e)
		{
			_log.info("Error During TotalTeethViewRender!");
			e.printStackTrace();
			return "/teeth/view/totalTeethView.jsp";
		}
	}
	
	private void processTeethRange(RenderRequest renderRequest, long PatientID, long from, long to)
	{
		for(long i = from; i <= to; i++)
		{
			List<TreatmentHistory> HT = TreatmentHistoryLocalServiceUtil.getPatientTreatmentListByTeethNum(PatientID, i);
			renderRequest.setAttribute("teeth" + i, HT);
	        //_log.info("teeth" + i + " : " + HT);
			
		}
	}
	Log _log = LogFactoryUtil.getLog(TotalTeethViewRenderCommand.class);
}
