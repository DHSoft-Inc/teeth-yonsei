package teeth.dentistry.command.render;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.util.ParamUtil;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;

import teeth.dentistry.constants.TeethDentistryPortletKeys;


@Component(
		immediate = true,
		property = {
				"javax.portlet.name="+ TeethDentistryPortletKeys.TEETHDENTISTRY,
			"mvc.command.name=/add/addTreatment"
		},
		service = MVCRenderCommand.class
	)
public class AddTreatmentRenderCommand implements MVCRenderCommand {

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
		// TODO Auto-generated method stub
		
		String teethArrStr = ParamUtil.getString(renderRequest, "teethArrStr");
		String teethsParam = ParamUtil.getString(renderRequest, "teethsParam");
		long numOfTeeth = ParamUtil.getLong(renderRequest, "numOfTeeth");
		
		String mode = ParamUtil.getString(renderRequest, "mode");
		_log.info(mode);
		
		renderRequest.setAttribute("teeths", teethsParam);
		renderRequest.setAttribute("teethArrStr", teethArrStr);
		
		switch (mode) {
			case "Canal_PreOP": return "/teeth/add/canal_PreOP.jsp";
			case "Canal_IntraOP": return "/teeth/add/canal_IntraOP.jsp";
			case "Canal_PostOP": return "/teeth/add/canal_PostOP.jsp";
			case "Resin_PreOP": return "/teeth/add/resin_PreOP.jsp";
			case "Resin_OperativePrecedure": return "/teeth/add/resin_OperativePrecedure.jsp";
			case "Resin_FU": return "/teeth/add/resin_FU.jsp";
			default: return null;
		}
	}
	private Log _log = LogFactoryUtil.getLog(AddTreatmentRenderCommand.class);
}
