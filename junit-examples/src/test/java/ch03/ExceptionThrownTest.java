package ch03;

import org.junit.Test;

/**
 * リスト3.10 Testアノテーションのexpected属性
 * リスト3.18  例外の送出を検証するテスト
 * @author shuji.w6e
 */
public class ExceptionThrownTest {
    ExceptionThrown sut = new ExceptionThrown();

    @Test(expected = IllegalArgumentException.class)
    public void 例外テスト() throws Exception {
        sut.doSomething();
    }
}
