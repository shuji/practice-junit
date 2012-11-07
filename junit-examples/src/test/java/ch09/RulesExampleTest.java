package ch09;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.rules.TestName;

/**
 * リスト9.2 複数のルールの宣言
 * @author shuji.w6e
 */
public class RulesExampleTest {

    @Rule
    public TestName testName = new TestName();
    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void test() throws Exception {
    }
}
