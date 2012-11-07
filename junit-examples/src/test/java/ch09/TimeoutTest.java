package ch09;

import static ch09.TimeoutExample.*;

import org.junit.Test;

/**
 * リスト9.12 アノテーションを使ったタイムアウト
 * @author shuji.w6e
 */
public class TimeoutTest {
    @Test(timeout = 100L)
    public void アノテーションを使ったタイムアウト() throws Exception {
        doLongTask();
    }
}
