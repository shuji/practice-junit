package ch09;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Ignore;
import org.junit.Test;

/**
 * リスト9.9 例外の発生を検証する標準的なテスト
 * リスト9.10 例外の発生とメッセージを検証する標準的なテスト
 * @author shuji.w6e
 */
public class ExceptionTest {

    @Test(expected = IllegalArgumentException.class)
    public void 例外の発生を検証する標準的なテスト() throws Exception {
        throw new IllegalArgumentException();
    }

    @Ignore("例外が発生しないため、テストは失敗する")
    @Test
    public void 例外の発生とメッセージを検証する標準的なテスト() throws Exception {
        try {
            throwNewIllegalArgumentException();
            fail("例外が発生しない");
        } catch (IllegalArgumentException e) {
            assertThat(e.getMessage(), is("argument is null."));
        }
    }

    private void throwNewIllegalArgumentException() {
    }

}
