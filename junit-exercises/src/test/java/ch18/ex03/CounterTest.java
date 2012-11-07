package ch18.ex03;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * リスト18.6 副作用を持つメソッドのテスト
 * @author shuji.w6e
 */
@RunWith(Enclosed.class)
public class CounterTest {
    public static class 初期状態の場合 {
        Counter sut;

        @Before
        public void setUp() {
            sut = new Counter();
        }

        @Test
        public void incrementで1が取得できる() {
            assertThat(sut.increment(), is(1));
        }
    }

    public static class incrementが1回実行された場合 {
        Counter sut;

        @Before
        public void setUp() {
            sut = new Counter();
            sut.increment();
        }

        @Test
        public void incrementで2が取得できる() {
            assertThat(sut.increment(), is(2));
        }
    }

    public static class incrementが50回実行された場合 {
        Counter sut;

        @Before
        public void setUp() {
            sut = new Counter();
            for (int i = 0; i < 50; i++)
                sut.increment();
        }

        @Test
        public void incrementで51が取得できる() {
            assertThat(sut.increment(), is(51));
        }
    }
    
}
