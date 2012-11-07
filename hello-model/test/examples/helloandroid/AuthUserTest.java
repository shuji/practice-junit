package examples.helloandroid;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Test;

/**
 * リスト13.8 AuthUserクラスのテスト
 * @author shuji.w6e
 */
public class AuthUserTest {

    @Test
    public void userIdとpasswordが4文字以上の時_正しく設定されていること() throws Exception {
        String userId = "userId";
        String password = "password";
        AuthUser instance = new AuthUser(userId, password);
        assertThat(instance.userId, is(userId));
        assertThat(instance.password, is(password));
    }

    @Test(expected = IllegalArgumentException.class)
    public void userIdがnullの場合に例外が発生すること() {
        new AuthUser(null, "password");
    }

    @Test(expected = IllegalArgumentException.class)
    public void userIdが3文字の場合に例外が発生すること() {
        new AuthUser("bad", "password");
    }

    @Test(expected = IllegalArgumentException.class)
    public void passwordがnullの場合に例外が発生すること() {
        new AuthUser("userId", null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void passwordが3文字の場合に例外が発生すること() {
        new AuthUser("userId", "bad");
    }
}
