package teeth.web.dto;

import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TreeMap;

import teeth.model.TreatmentHistory;

public class DisplayHistory
{
	
	
   public String TreatmentIDList; //
   public String TreatmnetStringList;
   public Date Date;
   public String Status;
   
   private int ageYears;
   private int ageMonths;
   private int ageDays;
   
   
   private static final Map<String, String> STATUS_LABEL_MAP = new HashMap<>();

   
    // TreatmentIDList
    public String getTreatmentIDList() {
        return TreatmentIDList;
    }

    public void setTreatmentIDList(String treatmentIDList) {
        this.TreatmentIDList = treatmentIDList;
    }

    
    public String getTooltipTreatmnetStringList(Locale locale) {
        if (TreatmnetStringList == null || TreatmnetStringList.isEmpty()) {
            return "";
        }

        String[] items = TreatmnetStringList.split(",");
        StringBuilder sb = new StringBuilder();

        String testKey = LanguageUtil.get(locale, "teethweb.caption");
        _log.info(testKey);
        
        for (int i = 0; i < items.length; i++) {
            String item = items[i].trim();
           
            //String key = STATUS_LABEL_KEY_MAP.getOrDefault(item, "category.etc");
            
            
            //String label = LanguageUtil.get(locale, "category.etc");
            String label = "";
            
            
            if (!"기타".equals(label)) {
                sb.append(label).append(" - ").append(item);
            } else {
                sb.append(item);
            }

            if (i < items.length - 1) {
                sb.append(", ");
            }
        }
        _log.info(sb.toString());

        return sb.toString();
    }
    
    // TreatmnetStringList
    public String getTreatmnetStringList() {
        return TreatmnetStringList;
    }

    public void setTreatmnetStringList(String treatmnetStringList) {
        this.TreatmnetStringList = treatmnetStringList;
    }

    // Date
    public Date getDate() {
        return Date;
    }

    public void setDate(Date date) {
        this.Date = date;
    }

    // Status
    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        this.Status = status;
    }
    
    public int getAgeYears() {
        return ageYears;
    }
    public void setAgeYears(int ageYears) {
        this.ageYears = ageYears;
    }
    public int getAgeMonths() {
        return ageMonths;
    }
    public void setAgeMonths(int ageMonths) {
        this.ageMonths = ageMonths;
    }
    public int getAgeDays() {
        return ageDays;
    }
    public void setAgeDays(int ageDays) {
        this.ageDays = ageDays;
    }
    
    
    // TreatmentHistory 由ъ뒪�듃瑜� treatmentDate 湲곗��쑝濡� 臾띠뼱�꽌 List<DisplayHistory> �삎�깭濡� 諛섑솚
    public static List<DisplayHistory> buildDisplayHistoryList(List<TreatmentHistory> histories, Date birthDate) {
        // TreeMap�쓣 �벐硫� �궇吏� �닚�쑝濡� �젙�젹�맗�땲�떎.
        Map<Date, DisplayHistory> map = new TreeMap<>();

        for (TreatmentHistory h : histories) {
            Date date = h.getTreatmentDate();
            DisplayHistory dh = map.get(date);

            if (dh == null) {
                dh = new DisplayHistory();
                dh.setDate(date);

                // �깮�썑 �뿰쨌�썡쨌�씪 怨꾩궛
                Calendar bCal = Calendar.getInstance();
                bCal.setTime(birthDate);
                Calendar dCal = Calendar.getInstance();
                dCal.setTime(date);

                int years  = dCal.get(Calendar.YEAR)  - bCal.get(Calendar.YEAR);
                int months = dCal.get(Calendar.MONTH) - bCal.get(Calendar.MONTH);
                int days   = dCal.get(Calendar.DAY_OF_MONTH) - bCal.get(Calendar.DAY_OF_MONTH);

                // days 議곗젙
                if (days < 0) {
                    months--;
                    Calendar tmp = (Calendar) dCal.clone();
                    tmp.add(Calendar.MONTH, -1);
                    days += tmp.getActualMaximum(Calendar.DAY_OF_MONTH);
                }
                // months 議곗젙
                if (months < 0) {
                    years--;
                    months += 12;
                }

                dh.setAgeYears(years);
                dh.setAgeMonths(months);
                dh.setAgeDays(days);

                // �굹癒몄� 珥덇린�솕
                dh.setTreatmentIDList("");
                dh.setTreatmnetStringList("");
                dh.setStatus("");
                map.put(date, dh);
            }
            // 1) TreatmentIDList
            if (dh.getTreatmentIDList().isEmpty()) {
                dh.setTreatmentIDList(String.valueOf(h.getTreatmentID()));
            } else {
                dh.setTreatmentIDList(dh.getTreatmentIDList() + "," + h.getTreatmentID());
            }

            // 2) TreatmnetStringList
            if (h.getTreatment() != null && !h.getTreatment().equals("-")) {
                if (dh.getTreatmnetStringList().isEmpty()) {
                    dh.setTreatmnetStringList(h.getTreatment());
                } else {
                    dh.setTreatmnetStringList(dh.getTreatmnetStringList() + "," + h.getTreatment());
                }
            }

            // 3) Status (state 而щ읆)
            // 泥� 踰덉㎏ non-empty �긽�깭留� �꽕�젙
            if ((dh.getStatus() == null || dh.getStatus().isEmpty())
                && h.getState() != null && !h.getState().isEmpty()) {
                dh.setStatus(h.getState());
            }
        }

        return new ArrayList<>(map.values());
    }
    
    Log _log = LogFactoryUtil.getLog(DisplayHistory.class);
}