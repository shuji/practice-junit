package ch08;

/**
 * リスト8.A 値の制約がある年齢クラス
 * @author shuji.w6e
 */
public class Age {
    public final int value;

    public Age(int value) {
        if (value < 0 || 150 <= value) throw new IllegalArgumentException();
        this.value = value;
    }

}
