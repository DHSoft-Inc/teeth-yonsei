package teeth.web.command.action;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;

import java.util.Date;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import teeth.service.TreatmentHistoryLocalService;
import teeth.web.constants.TeethWebPortletKeys;


@Component(
property = {
	    "javax.portlet.name="+ TeethWebPortletKeys.TEETHWEB,
	    "mvc.command.name=/edit_tooth_treatment"
},
service = MVCActionCommand.class
)
public class EditTeethTreatmentActionCommand extends BaseMVCActionCommand{

	private static final Log _log = LogFactoryUtil.getLog(EditTeethTreatmentActionCommand.class);
    
	@Override
    protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
        long treatmentId = ParamUtil.getLong(actionRequest, "treatmentId");
        String mainCategory = ParamUtil.getString(actionRequest, "mainCategory");
        String status = ParamUtil.getString(actionRequest, "status");
        String permanent = ParamUtil.getString(actionRequest, "permanent");
        
        // 로그: 각 파라미터 값 확인
        _log.info("Received treatmentId: " + treatmentId);
        _log.info("Received mainCategory: " + mainCategory);
        _log.info("Received status: " + status);
        _log.info("Received permanent: " + permanent);

        ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
        long userId = themeDisplay.getUserId();
        Date now = new Date();

        // treatment 조합 (예시: A_W)
        String treatment = mainCategory + "_" + status;
        
        _log.info("treatmentId: " + treatmentId + ", treatment: " + treatment );
        
        // 서비스 호출
        _treatmentHistoryLocalService.UpdateHistory(
            treatmentId, 
            treatment, 
            permanent,  // state에 permanent를 저장한다고 했으니까
            now, 
            userId
        );
    }

    @Reference
    private TreatmentHistoryLocalService _treatmentHistoryLocalService;

}
