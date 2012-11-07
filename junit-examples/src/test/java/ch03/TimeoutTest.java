package ch03;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Test;

/**
 * リスト3.11 Testアノテーションのtimeout属性
 * @author shuji.w6e
 */
public class TimeoutTest {

    @Test(timeout = 100L)
    public void timeoutTest() throws Exception {
        Timeout sut = new Timeout();
        int actual = sut.doLongTask();
        assertThat(actual, is(100));
    }
}
