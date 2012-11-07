package examples.helloandroid;

import java.io.IOException;
import java.util.Map;

/**
 * リスト13.9 外部サービスを定義したインタフェース
 * @author shuji.w6e
 */
public interface JsonHttpClient {

    String sendRequest(String url, Map<String, String> params) throws IOException;
}
