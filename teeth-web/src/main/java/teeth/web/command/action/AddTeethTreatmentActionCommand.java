package teeth.web.command.action;
/*
package teeth.web.actioncommand;
 


import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.util.ParamUtil;

import java.util.Enumeration;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;

import teeth.web.constants.TeethWebPortletKeys;


@Component(
property = {
	    "javax.portlet.name="+ TeethWebPortletKeys.TEETHWEB,
	    "mvc.command.name=/add_tooth_treatment"
},
service = MVCActionCommand.class
)
public class AddTeethTreatmentActionCommand extends BaseMVCActionCommand {
	
	@SuppressWarnings("deprecation")
	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		// TODO Auto-generated method stub
		
		
		
		Date EditedDate = new Date(); 
		
		long patientId = ParamUtil.getLong(actionRequest, "patientId");
		Date treatmentDate = ParamUtil.getDate(actionRequest, "treatmentDate", new SimpleDateFormat("yyyy-MM-dd"));
		String mainCategory = ParamUtil.getString(actionRequest, "mainCategory");
		String selectedStatus = ParamUtil.getString(actionRequest, "selectedStatus");
		long selectedTeeth = ParamUtil.getLong(actionRequest, "selectedTeeth");
		
	    // 여기에 받은 파라미터를 모두 로그로 출력
	    _log.info("▶▶▶ AddTeethTreatmentActionCommand parameters:");
	    _log.info("   patientId     = " + patientId);
	    _log.info("   treatmentDate = " + treatmentDate);
	    _log.info("   mainCategory  = " + mainCategory);
	    _log.info("   selectedStatus= " + selectedStatus);
	    _log.info("   selectedTeeth = " + selectedTeeth);
	   
		
		 StringBuilder sb = new StringBuilder();
		    Map<String, String[]> paramMap = actionRequest.getParameterMap();
		    
		    for (Map.Entry<String, String[]> entry : paramMap.entrySet()) {
		        String key = entry.getKey();
		        for (String value : entry.getValue()) {
		            sb.append(key)
		              .append("=")
		              .append(value)
		              .append("&");
		        }
		    }
		    // 마지막 & 제거
		    if (sb.length() > 0) {
		        sb.setLength(sb.length() - 1);
		    }

		    _log.info("▶▶▶ Raw parameters: " + sb.toString());
		
		
	    // 파라미터 이름 전부 출력
	    Enumeration<String> names = actionRequest.getParameterNames();
	    while (names.hasMoreElements()) {
	        String name = names.nextElement();
	        String value = actionRequest.getParameter(name);
	        _log.info("▶ param: " + name + " = " + value);
	    }

	    // 예시: treatment_1 과 treatment_2 꺼내보기
	    String t1 = ParamUtil.getString(actionRequest, "treatment_1");
	    String t2 = ParamUtil.getString(actionRequest, "treatment_2");
	    _log.info("treatment_1 raw = " + t1);
	    _log.info("treatment_2 raw = " + t2);
		
		//TreatmentHistoryLocalServiceUtil.AddHistory(patientId, selectedTeeth, treatmentDate, treatment, state, EditedDate, editedUserID)
		
		//TreatmentHistoryLocalServiceUtil.AddHistory(patientId, selectedTeeth, treatmentDate, "treatment", "state", EditedDate, 1000);
		
	}
	private Log _log = LogFactoryUtil.getLog(AddTeethTreatmentActionCommand.class);

}
*/