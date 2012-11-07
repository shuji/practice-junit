package ch03;

/**
 * リスト3.A JUnit3スタイルのテスト
 * @author shuji.w6e
 */
public class JUnit3StyleTest extends junit.framework.TestCase {

    protected void setUp() throws Exception {
    }

    protected void tearDown() throws Exception {
    }

    public void test加算のテスト() throws Exception {
        assertEquals(7, 3 + 4);
    }
}
