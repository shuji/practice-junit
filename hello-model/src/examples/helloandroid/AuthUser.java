package examples.helloandroid;

/**
 * リスト13.5 AuthUserクラス
 * @author shuji.w6e
 */
public class AuthUser {

    public final String userId;
    public final String password;

    public AuthUser(String userId, String password) {
        if (userId == null || userId.length() < 4) {
            throw new IllegalArgumentException("userId: " + userId); 
        }
        if (password == null || password.length() < 4) {
            throw new IllegalArgumentException("password:" + password); 
        }
        this.userId = userId;
        this.password = password;
    }
}
