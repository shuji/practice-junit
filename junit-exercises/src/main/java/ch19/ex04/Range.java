package ch19.ex04;

/**
 * リスト19.12 Rangeクラスのcontainsメソッド
 * @author shuji.w6e
 */
public class Range {
    public final double min;
    public final double max;

    public Range(double min, double max) {
        this.min = min;
        this.max = max;
    }

    public boolean contains(double value) {
        return min <= value && value <= max;
    }
}
