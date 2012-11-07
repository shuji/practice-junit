package ch14;

import java.io.UnsupportedEncodingException;

/**
 * リスト14.2 再現困難な例外処理
 * @author shuji.w6e
 */
public class StringUtils {

    public static String toString(byte[] bytes) {
        try {
            return new String(bytes, "utf-8").intern();
        } catch (UnsupportedEncodingException e) {
            // この例外を発生させるのは難しい
            throw new RuntimeException("発生する筈がない", e);
        }
    }
}
