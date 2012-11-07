package ch10;

import org.junit.Test;
import org.junit.experimental.categories.Category;

/**
 * リスト10.3 テストメソッドのカテゴリ指定
 * @author shuji.w6e
 */
public class FooTest {

    @Category(FastTests.class)
    @Test
    public void fastTest() throws Exception {
        System.out.println("FooTest#fastTest");
    }

    @Category(SlowTests.class)
    @Test
    public void slowTest() throws Exception {
        System.out.println("FooTest#slowTest");
    }
}
