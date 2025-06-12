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
			"mvc.command.name=/teeth/deciduousTeethView"
		},
		service = MVCRenderCommand.class
	)
public class DeciduousTeethViewRenderCommand implements MVCRenderCommand {

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
		// TODO Auto-generated method stub
		_log.info("Hello!");
		long PatientID = 1001; //임시 PatientID
		List<TreatmentHistory> HistoryList = TreatmentHistoryLocalServiceUtil.getPatientTreatmentList(PatientID);
		try
		{
			// 유치만 사용
			processTeethRange(renderRequest, PatientID, 51, 85);

			renderRequest.setAttribute("patientID", PatientID);
			renderRequest.setAttribute("HistoryList", HistoryList);
			
			return "/teeth/view/deciduousTeethview.jsp";
		}
		catch(Exception e)
		{
			_log.info("Error During DeciduousTeethView!");
			e.printStackTrace();
			return null;
		}
	}
	
	private void processTeethRange(RenderRequest renderRequest, long PatientID, long from, long to)
	{
		for(long i = from; i <= to; i++)
		{
			List<TreatmentHistory> HT = TreatmentHistoryLocalServiceUtil.getPatientTreatmentListByTeethNum(PatientID, i);
			renderRequest.setAttribute("teeth" + i, HT);
	        _log.info("teeth" + i + " : " + HT);
			
		}
	}
	Log _log = LogFactoryUtil.getLog(DeciduousTeethViewRenderCommand.class);

}
