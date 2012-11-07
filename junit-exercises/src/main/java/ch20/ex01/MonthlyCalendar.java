package ch20.ex01;

import java.util.Calendar;

/**
 * リスト20.2 MonthlyCalendarクラス
 * @author shuji.w6e
 */
public class MonthlyCalendar {

    private final Calendar cal;

    public MonthlyCalendar() {
        this(Calendar.getInstance());
    }

    MonthlyCalendar(Calendar cal) {
        this.cal = cal;
    }

    public int getRemainingDays() {
        return cal.getActualMaximum(Calendar.DATE) - cal.get(Calendar.DATE);
    }

}
