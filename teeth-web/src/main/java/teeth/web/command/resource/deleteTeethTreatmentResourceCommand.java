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
	        "mvc.command.name="+ teethTreatmentMVCCommand.DELETE_TREATMENT
	    },
	    service = MVCResourceCommand.class
	)
public class deleteTeethTreatmentResourceCommand extends BaseMVCResourceCommand{

	@Override
	protected void doServeResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws Exception {
		// TODO Auto-generated method stub
		 String jsonStr = new BufferedReader(new InputStreamReader(resourceRequest.getPortletInputStream()))
			        .lines().collect(Collectors.joining());

	    JSONObject jsonObject = JSONFactoryUtil.createJSONObject(jsonStr);
	    JSONArray treatmentsArray = jsonObject.getJSONArray("deleteData");
	    
	    for (int i = 0; i < treatmentsArray.length(); i++) {
	        JSONObject treatment = treatmentsArray.getJSONObject(i);

	        _log.info("JSON Treatment 처리 중: " + treatment.toString());
	        String EditUserId = treatment.getString("userId");
	        String treatmentDateStr = treatment.getString("treatmentDate"); 
	        String mainCategory = treatment.getString("mainCategory");
	        String selectedTreatment = treatment.getString("selectedTreatment");
	        String selectedTeeth1 = treatment.getString("selectedTeeth");
	        String Status = treatment.getString("selectedStatus");
	        long selectedTreatmentID = treatment.getLong("selectedTreatmentID");
	        
	        //SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");  // 날짜 포맷이 "2025-04-10" 형식일 경우
	        //Date treatmentDate = sdf.parse(treatmentDateStr);
	        
	        
	        long userId = Long.parseLong(EditUserId);
	        long patientId = 1001; //ParamUtil.getLong(request, "patientId");
	        long teethNum = Long.parseLong(selectedTeeth1);
	        TreatmentHistory treatments = TreatmentHistoryLocalServiceUtil. getPatientTreatmentByTreatmentID(selectedTreatmentID);
	        
	        treatments = TreatmentHistoryLocalServiceUtil.deleteTreatmentHistory(selectedTreatmentID);
	        TreatmentAudit audit = TreatmentAuditLocalServiceUtil.AddAudit(teethNum, userId, treatments.getTreatmentDate(), "delete",  Status, "-");
	        
	      
	    }
	}
	private Log _log = LogFactoryUtil.getLog(deleteTeethTreatmentResourceCommand.class);
}
