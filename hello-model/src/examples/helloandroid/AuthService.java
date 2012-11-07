package examples.helloandroid;

import java.io.IOException;

/**
 * リスト13.4 AuthServiceインタフェース
 * @author shuji.w6e
 */
public interface AuthService {
    
    boolean login(AuthUser authUser) throws IOException;
}
