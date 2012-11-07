package ch10;

import org.junit.Test;
import org.junit.experimental.categories.Category;

/**
 * リスト10.4 テストクラスのカテゴリ指定
 * @author shuji.w6e
 */
@Category(FastTests.class)
public class BarTest {

    @Test
    public void test01() throws Exception {
        System.out.println("BarTest#test01");
    }

    @Test
    public void test02() throws Exception {
        System.out.println("BarTest#test02");
    }
}
