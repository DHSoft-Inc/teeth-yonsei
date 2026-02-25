package teeth.dentistry.command.render;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.util.ParamUtil;

import java.util.Arrays;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;

import teeth.dentistry.constants.TeethDentistryPortletKeys;


@Component(
		immediate = true,
		property = {
			"javax.portlet.name="+ TeethDentistryPortletKeys.TEETHDENTISTRY,
			"mvc.command.name=/render/selectTreatmentView"
		},
		service = MVCRenderCommand.class
	)
public class SelectTreatmentDialogRenderCommand implements MVCRenderCommand {

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
		// TODO Auto-generated method stub
		
		String teethArrStr = ParamUtil.getString(renderRequest, "teeths");
		String result = teethArrStr.replaceAll("[^0-9,]", "");
		long numOfTeeth = Arrays.stream(result.split(",")).map(String::trim).filter(t -> !t.isEmpty()).count();
	
		_log.info(teethArrStr);
		_log.info(result);
		_log.info(numOfTeeth);
		renderRequest.setAttribute("teethArrStr", teethArrStr);
		renderRequest.setAttribute("teeths", result);
		renderRequest.setAttribute("numOfTeeth", numOfTeeth);
		
		return "/teeth/add/selecttreatment.jsp";
	}
	private Log _log = LogFactoryUtil.getLog(SelectTreatmentDialogRenderCommand.class);

}
