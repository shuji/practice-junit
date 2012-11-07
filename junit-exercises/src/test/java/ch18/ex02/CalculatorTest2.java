package ch18.ex02;

import org.junit.Test;

/**
 * リスト18.5 例外が送出されるため変数への代入が行われないテストコード
 * @author shuji.w6e
 */
@SuppressWarnings("unused")
public class CalculatorTest2 {

    @Test(expected = IllegalArgumentException.class)
    public void divideの第2引数に0を指定すると例外が発生する() throws Exception {
        Calculator sut = new Calculator();
        // 例外がthrowされるため代入されることはない 
        int actual = sut.divide(1, 0);
    }
}
