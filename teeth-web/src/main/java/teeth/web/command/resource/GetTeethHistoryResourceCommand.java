package teeth.web.command.resource;

import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCResourceCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.liferay.portal.kernel.util.ParamUtil;

import java.text.SimpleDateFormat;
import java.util.List;

import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;

import teeth.model.TreatmentHistory;
import teeth.service.TreatmentHistoryLocalServiceUtil;
import teeth.web.constants.TeethWebPortletKeys;

@Component(
    property = {
        "javax.portlet.name=" + TeethWebPortletKeys.TEETHWEB,
        "mvc.command.name=/teeth/getHistory"
    },
    service = MVCResourceCommand.class
)
public class GetTeethHistoryResourceCommand
    extends BaseMVCResourceCommand {

    private static final SimpleDateFormat _fmt =
        new SimpleDateFormat("yyyy-MM-dd");

    @Override
    protected void doServeResource(
        ResourceRequest resourceRequest,
        ResourceResponse resourceResponse)
    throws Exception {

        // (1) 파라미터로 넘어온 teethNum
        int teethNum = ParamUtil.getInteger(resourceRequest, "teethNum", -1);
        long patientID = 1001L; // 테스트용 고정

        // (2) 해당 치아번호 히스토리만 조회
        List<TreatmentHistory> list =
            TreatmentHistoryLocalServiceUtil
                .getPatientTreatmentListByTeethNum(patientID, teethNum);

        // (3) JSON 배열 생성
        JSONArray jsonArray = JSONFactoryUtil.createJSONArray();

        for (TreatmentHistory th : list) {
            JSONObject obj = JSONFactoryUtil.createJSONObject();
            obj.put("treatmentDate", _fmt.format(th.getTreatmentDate()));
            obj.put("treatment",     th.getTreatment());
            obj.put("state",         th.getState()); 
            jsonArray.put(obj);
        }

        // (4) 응답
        resourceResponse.setContentType("application/json");
        resourceResponse.setCharacterEncoding("UTF-8");
        resourceResponse.getWriter().write(jsonArray.toString());
    }
}
