package ch07;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

/**
 * リスト7.1 単純なフィクスチャのセットアップ
 * @author shuji.w6e
 */
public class CalculatorTest {

    public void multiplyで3と4の乗算結果が取得できること() throws Exception {
        Calculator calc = new Calculator();
        int expected = 12;
        int actual = calc.multiply(3, 4);
        assertThat(actual, is(expected));
    }
}
