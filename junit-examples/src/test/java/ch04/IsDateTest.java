package ch04;

import static ch04.IsDate.*;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Ignore;
import org.junit.Test;

/**
 * リスト4.9 IsDateのテストサンプル
 * @author shuji.w6e
 */
@Ignore("動作確認する時は@Ignoreをコメントアウトしてください")
public class IsDateTest {

    @Test
    public void 日付の比較() throws Exception {
        Date date = new Date();
        assertThat(date, is(dateOf(2011, 2, 10)));
    }

    @Test
    public void nullとの比較() throws Exception {
        assertThat(null, is(dateOf(2011, 2, 10)));
    }
}
