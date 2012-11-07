package examples.helloandroid;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

/**
 * リスト13.11 AuthServiceImplのユニットテスト
 * @author shuji.w6e
 */
public class AuthServiceImplTest {

    AuthServiceImpl sut;
    JsonHttpClient httpClient;
    AuthUser authUser;
    Map<String, String> params;

    @Before
    public void setup() throws Exception {
        sut = new AuthServiceImpl();
        httpClient = mock(JsonHttpClient.class);
        sut.httpClient = httpClient;
        authUser = new AuthUser("u000001", "123456");
        params = new HashMap<String, String>();
        params.put("userId", "u000001");
        params.put("password", "123456");
    }

    @Test(expected = IllegalArgumentException.class)
    public void authUserがnullの時_例外() throws Exception {
        sut.login(null);
    }

    @Test
    public void httpClientがsucessを含むJSONを返す時にtrueを返すこと() throws Exception {
        when(httpClient.sendRequest("http://localhost/api/login", params))
                       .thenReturn("{ result: 'success'}");
        assertThat(sut.login(authUser), is(true));
    }

    @Test
    public void httpClientがfailを含むJSONを返す時にfalseを返すこと() throws Exception {
        when(httpClient.sendRequest("http://localhost/api/login", params))
                       .thenReturn("{ result: 'fail'}");
        assertThat(sut.login(authUser), is(false));
    }

    @Test(expected = IOException.class)
    public void httpClientがIOExceptionを送出する時にそのまま送出する() throws Exception {
        when(httpClient.sendRequest("http://localhost/api/login", params))
                       .thenThrow(new IOException());
        sut.login(authUser);
    }
}
