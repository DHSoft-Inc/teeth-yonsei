package teeth.web.command.resource;

import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCResourceCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.stream.Collectors;

import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;

import teeth.model.TreatmentAudit;
import teeth.model.TreatmentHistory;
import teeth.service.TreatmentAuditLocalServiceUtil;
import teeth.service.TreatmentHistoryLocalServiceUtil;
import teeth.web.constants.TeethWebPortletKeys;
import teeth.web.constants.teethTreatmentMVCCommand;

@Component(
	    property = {
	        "javax.portlet.name=" + TeethWebPortletKeys.TEETHWEB,
	        "mvc.command.name="+ teethTreatmentMVCCommand.EDIT_TREATMENT
	        //"mvc.command.name=/teeth/addTreatment"
	    },
	    service = MVCResourceCommand.class
	)
public class editTeethTreatmentResourceCommand extends BaseMVCResourceCommand  {

	@Override
	protected void doServeResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws Exception {
		// TODO Auto-generated method stub
		 _log.info("JSON Treatment 처리 중: ");
		 String jsonStr = new BufferedReader(new InputStreamReader(resourceRequest.getPortletInputStream()))
			        .lines().collect(Collectors.joining());

			    JSONObject jsonObject = JSONFactoryUtil.createJSONObject(jsonStr);
			    JSONArray treatmentsArray = jsonObject.getJSONArray("requests");
			    _log.info("jsonObject: " + jsonObject.toString());
			    _log.info("treatmentsArray: " + treatmentsArray.toString());
	
			    for (int i = 0; i < treatmentsArray.length(); i++) {
			        JSONObject treatment = treatmentsArray.getJSONObject(i);

			        String editUserIdStr = treatment.getString("EditUserId");
			        String treatmentIDStr = treatment.getString("treatmentID");
			        String selectedStatus = treatment.getString("selectedStatus");
			        String selectedTeethStr = treatment.getString("selectedTeeth");
			        String selectedPermanent = treatment.getString("selectedPermanent");
			        ServiceContext serviceContext = ServiceContextFactory.getInstance(
			        	    TreatmentAudit.class.getName(), resourceRequest);
			        
			        _log.info("치료 정보: " + treatment.toString());

			        try {
			            long editUserId = Long.parseLong(editUserIdStr);
			            long treatmentId = Long.parseLong(treatmentIDStr);
			            long selectedTeeth = Long.parseLong(selectedTeethStr);

			            Date editedDate = new Date();

			            // 1. 과거 치료 내용 조회
			            TreatmentHistory past = TreatmentHistoryLocalServiceUtil.getPatientTreatmentByTreatmentID(treatmentId);
			            String pastTreatment = past.getTreatment();

			            // 2. 치료 기록 업데이트
			            TreatmentHistory updated = TreatmentHistoryLocalServiceUtil.UpdateHistory(
			                treatmentId,
			                selectedStatus,
			                selectedPermanent,
			                editedDate,
			                editUserId,
			                serviceContext
			            );

			            // 3. 감사 로그 저장
			            TreatmentAudit audit = TreatmentAuditLocalServiceUtil.AddAudit(
			                selectedTeeth,
			                editUserId,
			                past.getTreatmentDate(),
			                "Edit",
			                pastTreatment,
			                selectedStatus,
			                serviceContext
			            );

			            if (updated != null && audit != null) {
			                _log.info("치료 정보 저장 및 감사 로그 완료 - TreatmentID: " + treatmentId);
			            } else {
			                _log.error("치료 정보 저장 실패 - TreatmentID: " + treatmentId);
			            }

			        } catch (Exception e) {
			            _log.error("예외 발생: ", e);
			        }
			    }

			    // 클라이언트에 응답 보내기
			    resourceResponse.setContentType("text/plain");
			    resourceResponse.getWriter().write("치료 정보 저장 완료");
	}
	private Log _log = LogFactoryUtil.getLog(editTeethTreatmentResourceCommand.class);

}
