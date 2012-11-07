package ch11;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Ignore;
import org.junit.Test;

/**
 * リスト11.2 システム時間に依存する処理を含むメソッドのテスト
 * @author shuji.w6e
 */
public class DateDependencyExampleTest {

    @Ignore
    @Test
    public void doSomethingでdateに現在時刻が設定される() throws Exception {
        DateDependencyExample sut = new DateDependencyExample();
        sut.doSomething();
        // このアサーションは実行タイミングによって成功にも失敗にもなる
        assertThat(sut.date, is(new Date()));
    }

}
