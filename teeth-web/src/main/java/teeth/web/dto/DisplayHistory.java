package teeth.web.dto;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
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
   
    // TreatmentIDList
    public String getTreatmentIDList() {
        return TreatmentIDList;
    }

    public void setTreatmentIDList(String treatmentIDList) {
        this.TreatmentIDList = treatmentIDList;
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
    
    
    // TreatmentHistory 리스트를 treatmentDate 기준으로 묶어서 List<DisplayHistory> 형태로 반환
    public static List<DisplayHistory> buildDisplayHistoryList(List<TreatmentHistory> histories, Date birthDate) {
        // TreeMap을 쓰면 날짜 순으로 정렬됩니다.
        Map<Date, DisplayHistory> map = new TreeMap<>();

        for (TreatmentHistory h : histories) {
            Date date = h.getTreatmentDate();
            DisplayHistory dh = map.get(date);

            if (dh == null) {
                dh = new DisplayHistory();
                dh.setDate(date);

                // 생후 연·월·일 계산
                Calendar bCal = Calendar.getInstance();
                bCal.setTime(birthDate);
                Calendar dCal = Calendar.getInstance();
                dCal.setTime(date);

                int years  = dCal.get(Calendar.YEAR)  - bCal.get(Calendar.YEAR);
                int months = dCal.get(Calendar.MONTH) - bCal.get(Calendar.MONTH);
                int days   = dCal.get(Calendar.DAY_OF_MONTH) - bCal.get(Calendar.DAY_OF_MONTH);

                // days 조정
                if (days < 0) {
                    months--;
                    Calendar tmp = (Calendar) dCal.clone();
                    tmp.add(Calendar.MONTH, -1);
                    days += tmp.getActualMaximum(Calendar.DAY_OF_MONTH);
                }
                // months 조정
                if (months < 0) {
                    years--;
                    months += 12;
                }

                dh.setAgeYears(years);
                dh.setAgeMonths(months);
                dh.setAgeDays(days);

                // 나머지 초기화
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

            // 3) Status (state 컬럼)
            // 첫 번째 non-empty 상태만 설정
            if ((dh.getStatus() == null || dh.getStatus().isEmpty())
                && h.getState() != null && !h.getState().isEmpty()) {
                dh.setStatus(h.getState());
            }
        }

        return new ArrayList<>(map.values());
    }
    
    Log _log = LogFactoryUtil.getLog(DisplayHistory.class);
}