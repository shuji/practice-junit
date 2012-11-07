package ch09;

import static ch09.TimeoutExample.*;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

/**
 * リスト9.1 Ruleアノテーションによるルールの宣言
 * リスト9.13 Timeoutルールを使ったタイムアウトの設定
 * @author shuji.w6e
 */
public class TimeoutExampleTest {
    @Rule
    public Timeout timeout = new Timeout(100);

    @Test
    public void 長い時間がかかるかもしれないテスト() throws Exception {
        doLongTask();
    }
}
