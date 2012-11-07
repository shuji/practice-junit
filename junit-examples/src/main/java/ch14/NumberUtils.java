package ch14;

import java.text.DecimalFormat;

/**
 * リスト14.1 privateコンストラクタ
 * @author shuji.w6e
 */
public class NumberUtils {

    private NumberUtils() {
        // このコードは実行されない（カバレッジも通せない）
    }

    public static String format(int num) {
        return new DecimalFormat("###,###,###,###,###").format(num);
    }
}
