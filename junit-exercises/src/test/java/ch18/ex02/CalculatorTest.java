package ch18.ex02;

import org.junit.Test;

/**
 * リスト18.3 例外を送出するメソッドのテスト
 * @author shuji.w6e
 */
public class CalculatorTest {

    @Test(expected = IllegalArgumentException.class)
    public void divideの第2引数に0を指定すると例外が発生する() throws Exception {
        Calculator sut = new Calculator();
        sut.divide(1, 0);
    }
}
