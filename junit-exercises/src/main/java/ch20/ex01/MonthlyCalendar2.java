package ch20.ex01;

import java.util.Calendar;

/**
 * リスト20.3 Calendarオブジェクトの生成をメソッドに抽出
 * @author shuji.w6e
 */
public class MonthlyCalendar2 {

    public int getRemainingDays() {
        Calendar cal = getCalendar();
        return cal.getActualMaximum(Calendar.DATE) - cal.get(Calendar.DATE);
    }

    Calendar getCalendar() {
        return Calendar.getInstance();
    }

}
