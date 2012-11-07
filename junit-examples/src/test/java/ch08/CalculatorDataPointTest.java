package ch08;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.experimental.theories.DataPoint;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;

/**
 * リスト8.13 フィクスチャオブジェクトによるパラメータ化テスト
 * @author shuji.w6e
 */
@RunWith(Theories.class)
public class CalculatorDataPointTest {
    @DataPoint
    public static Fixture PARAM_1 = new Fixture(3, 4, 7);
    @DataPoint
    public static Fixture PARAM_2 = new Fixture(0, 5, 5);
    @DataPoint
    public static Fixture PARAM_3 = new Fixture(-3, 1, -2);

    @Theory
    public void add(Fixture p) throws Exception {
        Calculator sut = new Calculator();
        assertThat(sut.add(p.x, p.y), is(p.expected));
    }

    static class Fixture {
        int x;
        int y;
        int expected;

        Fixture(int x, int y, int expected) {
            this.x = x;
            this.y = y;
            this.expected = expected;
        }
    }

}
