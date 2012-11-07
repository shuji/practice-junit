package ch05;

import static org.junit.Assert.*;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.experimental.categories.Category;

/**
 * リスト5.7 テストメソッドのカテゴリ化
 * @author shuji.w6e
 */
@Ignore("EclipseからJUnitテストを実行した場合、このテストクラスに含まれるテストが実行され、テストが失敗となります")
public class SlowAndFastTest {
    @Test
    public void fastTest_01() throws Exception {
    }

    @Test
    @Category(SlowTests.class)
    public void slowTest_01() throws Exception {
        fail();
    }

    @Test
    @Category(SlowTests.class)
    public void slowTest_02() throws Exception {
        fail();
    }
}
