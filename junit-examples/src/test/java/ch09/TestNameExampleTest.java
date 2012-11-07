package ch09;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;

/**
 * リスト9.15 テスト名の取得
 * @author shuji.w6e
 */
public class TestNameExampleTest {

    @Rule
    public TestName testName = new TestName();

    @Test
    public void テスト名() throws Exception {
        assertThat(testName.getMethodName(), is("テスト名"));
    }

}
