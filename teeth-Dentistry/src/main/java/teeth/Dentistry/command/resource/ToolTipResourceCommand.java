package teeth.Dentistry.command.resource;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCResourceCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.liferay.portal.kernel.util.ParamUtil;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.portlet.PortletSession;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;

import teeth.Dentistry.constants.TeethDentistryPortletKeys;
import teeth.Dentistry.dto.DisplayHistory;
import teeth.model.TreatmentHistory;


@Component(
		immediate = true,
		property = { 
		"javax.portlet.name="+ TeethDentistryPortletKeys.TEETHDENTISTRY,
		"mvc.command.name=/teeth/tooltip"
		}, 
	service = MVCResourceCommand.class
	)
public class ToolTipResourceCommand extends BaseMVCResourceCommand{
    @Override
	protected void doServeResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws Exception {
    	//_log.info("ToolTip!");
    	
		try {
		    // 1) regionName 파라미터 추출 ("Teeth13" 등)
		    String regionName = ParamUtil.getString(resourceRequest, "regionName");
		    _log.info("regionName: " + regionName);
		    // 2) 숫자 부분만 파싱
		    int teethNum = Integer.parseInt(regionName.substring(5));
		    _log.info("teethNum: " + teethNum);
		    // 3) PortletSession에서 rlMap 꺼내기
		    PortletSession ps = resourceRequest.getPortletSession();
		    @SuppressWarnings("unchecked")
		    Map<Integer, List<TreatmentHistory>> rlMap =
		      (Map<Integer, List<TreatmentHistory>>)
		      ps.getAttribute("rlMap", PortletSession.PORTLET_SCOPE);
		    _log.info("===========================");
		    _log.info("List: " + rlMap);
		    
		    // 4) 바로 세션에 저장된 리스트를 꺼내서 DataList에 할당
		    List<TreatmentHistory> DataList = rlMap.get(teethNum);

		    //Birth 데이터 입력 부분
		    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		    Date Birth = new Date();
	        // 문자열을 파싱해서 Date로 변환
	        try {
				Birth = sdf.parse("2025-01-01");
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		    
		    List<DisplayHistory> displayList = DisplayHistory.buildDisplayHistoryList(DataList, Birth);
		    displayList.sort(Comparator.comparing(DisplayHistory::getDate).reversed());
		    _log.info("DisplayList: " + displayList);
		    
			// JSP 쪽에서 사용할 수 있도록 request attribute 에 담기
			resourceRequest.setAttribute("regionName", regionName);
			resourceRequest.setAttribute("displayList", displayList);
		} catch (Exception e) {
			_log.info("Error!");
			e.printStackTrace();
		}
		
		// 툴팁 JSP include
		try {
			resourceRequest.getPortletContext().getRequestDispatcher("/teeth/view/tooltip.jsp").include(resourceRequest, resourceResponse);
		} catch (Exception e) {
			// 로그 남기거나 에러 처리
			_log.info("Error During jsp load");
			e.printStackTrace();
		}
		
	}

	   Log _log = LogFactoryUtil.getLog(ToolTipResourceCommand.class);
}
