package ch18.ex02;

/**
 * リスト18.4 Calculatorクラス
 * @author shuji.w6e
 */
public class Calculator {

    public int divide(int x, int y) {
        if (y == 0) throw new IllegalArgumentException("y is null");
        return x / y;
    }
}
