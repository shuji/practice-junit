package ch06;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * リスト6.6 構造化されたArrayListのテストクラス
 * @author shuji.w6e
 */
@RunWith(Enclosed.class)
public class ArrayListEnclosedTest {

    public static class listに1件追加してある場合 {
        private ArrayList<String> sut;

        @Before
        public void setUp() throws Exception {
            sut = new ArrayList<String>();
            sut.add("A");
        }

        @Test
        public void sizeは1を返す() throws Exception {
            int actual = sut.size();
            assertThat(actual, is(1));
        }
    }

    public static class listに2件追加してある場合 {
        private ArrayList<String> sut;

        @Before
        public void setUp() throws Exception {
            sut = new ArrayList<String>();
            sut.add("A");
            sut.add("B");
        }

        @Test
        public void sizeは2を返す() throws Exception {
            int actual = sut.size();
            assertThat(actual, is(2));
        }
    }
}
