package teeth.web.command.resource;

import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCResourceCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
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
	        "mvc.command.name="+ teethTreatmentMVCCommand.ADD_TREATMENT
	        //"mvc.command.name=/teeth/addTreatment"
	    },
	    service = MVCResourceCommand.class
	)
public class addTeethTreatmentResourceCommand extends BaseMVCResourceCommand {

	@Override
	protected void doServeResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
	        throws Exception {

		 String jsonStr = new BufferedReader(new InputStreamReader(resourceRequest.getPortletInputStream()))
			        .lines().collect(Collectors.joining());

			    JSONObject jsonObject = JSONFactoryUtil.createJSONObject(jsonStr);
			    JSONArray treatmentsArray = jsonObject.getJSONArray("treatments");

			    for (int i = 0; i < treatmentsArray.length(); i++) {
			        JSONObject treatment = treatmentsArray.getJSONObject(i);

			        String EditUserId = treatment.getString("EditUserId");
			        String treatmentDate = treatment.getString("treatmentDate");
			        String mainCategory = treatment.getString("mainCategory");
			        String selectedTreatment = treatment.getString("selectedTreatment");
			        String selectedTeeth1 = treatment.getString("selectedTeeth");
			        String State = treatment.getString("selectedState");

			        _log.info("JSON Treatment 처리 중: " + treatment.toString());

			        // TODO: 처리 로직 (예: DB 저장)
			        
			        if (State == null || State.trim().isEmpty()) {
		                State = null;  // State 값이 없으면 null로 설정
		            }
		            if ("undefined".equals(State)) {
		                State = null;  // 값이 "undefined"일 경우 null로 설정
		            }
			        
		            String selectedTeeth = java.net.URLDecoder.decode(selectedTeeth1, "UTF-8");
		            selectedTeeth = selectedTeeth.replaceAll("[^0-9,]", ""); // 숫자와 쉼표만 남기기
		            
		            // 치료일자 문자열 -> Date 변환
		            Date treatmentDateParsed = null;
		            try {
		                treatmentDateParsed = new SimpleDateFormat("yyyy-MM-dd").parse(treatmentDate);
		            } catch (Exception e) {
		                //out.print("날짜 파싱 오류: " + e.getMessage());
		                return;
		            }
		            
		            String[] teethNumbers = selectedTeeth.split(",");
		            
		            for (String teethNumber : teethNumbers) {
		                // 각 치아에 대해 Treatment ID 생성
		                String Treatment = selectedTreatment;
		                Date EditedDate = new Date(); 
		                long patientId = 1001; //임시
		                long TN = Long.parseLong(teethNumber);
		                
		                long UserId = Long.parseLong(EditUserId);
		                
		                // 저장
		                TreatmentHistory TH = TreatmentHistoryLocalServiceUtil.AddHistory(patientId, TN, treatmentDateParsed, Treatment, State, EditedDate, UserId);
		                TreatmentAudit audit = TreatmentAuditLocalServiceUtil.AddAudit(TN, UserId, treatmentDateParsed, "Add", "-" , Treatment );

		                if(TH == null)
		                {
		                    //대충 실패 메서드
		                }
		                else
		                {
		                    //대충 성공한거
		                    //out.print("치료 정보 저장 완료: " + teethNumber + "\n");
		                }
		            }
			    }

			    resourceResponse.setContentType("application/json");
			    PrintWriter writer = resourceResponse.getWriter();
			    writer.write("{\"status\":\"success\"}");
			    writer.flush();

	}

	
	
	private Log _log = LogFactoryUtil.getLog(addTeethTreatmentResourceCommand.class);
}
