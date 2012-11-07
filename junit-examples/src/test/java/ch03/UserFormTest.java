package ch03;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Test;

/**
 * リスト3.2 テスト対象オブジェクトと変数名
 * リスト3.3 期待値と実測値
 * @author shuji.w6e
 */
public class UserFormTest {

    @Test
    public void isValidはuserNameとpasswordが空でない場合にtrueを返す() throws Exception {
        UserForm sut = new UserForm("user01", "1234");
        assertThat(sut.isValid(), is(true));
    }

    @Test
    public void userNameが空のときにエラーメッセージが取得できる() throws Exception {
        UserForm sut = new UserForm("", "1234");
        String expected = "ユーザIDは必須項目です。";
        String actual = sut.getErrorMessage();
        assertThat(actual, is(expected));
    }
}
