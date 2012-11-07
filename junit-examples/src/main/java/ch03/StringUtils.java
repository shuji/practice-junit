package ch03;

/**
 * リスト3.4 副作用のないメソッド
 * @author shuji.w6e
 */
public class StringUtils {

    public static boolean isEmptyOrNull(String value) {
        return value == null || value.isEmpty();
    }
}
