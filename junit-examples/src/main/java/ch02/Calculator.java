package ch02;

/**
 * 計算機プログラム.
 * リスト2.1 乗算メソッドのドキュメント
 * @author shuji.w6e
 */
public class Calculator {

    /**
     * 引数で与えられた2つの値を掛け合わせた値を返す
     * @param x 1つ目の引数
     * @param y 2つ目の引数
     * @return xとyを掛け合わせた値
     */
    public int multiply(int x, int y) {
        return x * y;
    }

    /**
     * 1つ目の引数を2つ目の引数で除算する.
     * @param x 1つ目の引数
     * @param y 2つ目の引数
     * @return xとyの除算結果
     * @throws IllegalArgumentException yが0の場合
     */
    public float divide(int x, int y) {
        if (y == 0) throw new IllegalArgumentException("divide by zero.");
        return (float) x / (float) y;
    }
}
