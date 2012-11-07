package ch09;

import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

/**
 * リスト9.11 例外の発生とメッセージを検証するテスト
 * @author shuji.w6e
 */
public class ExpectedExceptionExampleTest {
    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Ignore("例外メッセージが一致しないため、テストは失敗する")
    @Test
    public void 例外の発生とメッセージを検証するテスト() throws Exception {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("argument is null.");
        throw new IllegalArgumentException();
    }
}
