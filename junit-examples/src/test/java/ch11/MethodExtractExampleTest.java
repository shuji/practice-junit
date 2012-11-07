package ch11;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Test;

/**
 * リスト11.4 newDateメソッドをオーバーライドしたテスト
 * @author shuji.w6e
 */
public class MethodExtractExampleTest {

    @Test
    public void doSomethingを実行するとdateに現在時刻が設定される() throws Exception {
        final Date current = new Date();
        MethodExtractExample sut = new MethodExtractExample() {
            @Override
            Date newDate() {
                return current;
            }
        };
        sut.doSomething();
        assertThat(sut.date, is(sameInstance(current)));
    }
}
