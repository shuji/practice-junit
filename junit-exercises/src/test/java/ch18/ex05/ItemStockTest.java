package ch18.ex05;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * リスト18.10 void型を戻り値とするメソッドのテスト
 * @author shuji.w6e
 */
@RunWith(Enclosed.class)
public class ItemStockTest {
    public static class 初期状態の場合 {
        ItemStock sut;
        Item book;

        @Before
        public void setUp() throws Exception {
            book = new Item("book", 3800);
            sut = new ItemStock();
        }

        @Test
        public void getNumはbookで0を返す() throws Exception {
            assertThat(sut.getNum(book), is(0));
        }

        @Test
        public void addでbookを追加するとgetNumで1を返す() throws Exception {
            sut.add(book);
            assertThat(sut.getNum(book), is(1));
        }
    }

    public static class bookが1回追加されている場合 {
        ItemStock sut;
        Item book;

        @Before
        public void setUp() throws Exception {
            book = new Item("book", 3800);
            sut = new ItemStock();
            sut.add(book);
        }

        @Test
        public void getNumは1を返す() throws Exception {
            assertThat(sut.getNum(book), is(1));
        }

        @Test
        public void addでbookを追加するとgetNumで2を返す() throws Exception {
            sut.add(book);
            assertThat(sut.getNum(book), is(2));
        }

        @Test
        public void addでbikeを追加するとgetNumでbookとbikeは1を返す() throws Exception {
            Item bike = new Item("bike", 57000);
            sut.add(bike);
            assertThat(sut.getNum(book), is(1));
            assertThat(sut.getNum(bike), is(1));
        }

    }
}
