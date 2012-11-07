package ch04;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.hamcrest.BaseMatcher;
import org.hamcrest.Description;
import org.hamcrest.Matcher;

/**
 * リスト4.4 IsDateの作成
 * リスト4.5 IsDateクラスのファクトリメソッド
 * リスト4.6 期待値の保持
 * リスト4.7 matchesメソッドの実装
 * リスト4.8 検証失敗の詳細情報を記録する
 * リスト4.10 IsDateクラス
 * 日付の比較検証を行うカスタムMatcher
 * @author shuji.w6e
 */
public class IsDate extends BaseMatcher<Date> {
    private final int yyyy;
    private final int mm;
    private final int dd;
    Object actual;

    IsDate(int yyyy, int mm, int dd) {
        this.yyyy = yyyy;
        this.mm = mm;
        this.dd = dd;
    }

    @Override
    public boolean matches(Object actual) {
        this.actual = actual;
        if (!(actual instanceof Date)) return false;
        Calendar cal = Calendar.getInstance();
        cal.setTime((Date) actual);
        if (yyyy != cal.get(Calendar.YEAR)) return false;
        if (mm != cal.get(Calendar.MONTH) + 1) return false;
        if (dd != cal.get(Calendar.DATE)) return false;
        return true;
    }

    @Override
    public void describeTo(Description desc) {
        desc.appendValue(String.format("%d/%02d/%02d", yyyy, mm, dd));
        if (actual != null) {
            desc.appendText(" but actual is ");
            desc.appendValue(new SimpleDateFormat("yyyy/MM/dd").format((Date) actual));
        }
    }

    public static Matcher<Date> dateOf(int yyyy, int mm, int dd) {
        return new IsDate(yyyy, mm, dd);
    }
}