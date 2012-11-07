package ch05;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * リスト5.5 Enclosedで構造化されたテストクラス
 * @author shuji.w6e
 */
@RunWith(Enclosed.class)
public class ItemStockTest {
    public static class 空の場合 {
        ItemStock sut;

        @Before
        public void setUp() throws Exception {
            sut = new ItemStock();
        }

        @Test
        public void size_Aが0を返す() throws Exception {
            assertThat(sut.size("A"), is(0));
        }

        @Test
        public void contains_Aはfalseを返す() throws Exception {
            assertThat(sut.contains("A"), is(false));
        }
    }

    public static class 商品Aを1件含む場合 {
        ItemStock sut;

        @Before
        public void setUp() throws Exception {
            sut = new ItemStock();
            sut.add("A", 1);
        }

        @Test
        public void sizeが1を返す() throws Exception {
            assertThat(sut.size("A"), is(1));
        }

        @Test
        public void contains_Aはtrueを返す() throws Exception {
            assertThat(sut.contains("A"), is(true));
        }
    }
}
