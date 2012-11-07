package ch20.ex03;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.io.ByteArrayInputStream;

import org.junit.Test;

/**
 * リスト20.6 外部システムに依存するテスト
 * @author shuji.w6e
 */
public class NetworkResourcesTest {

    @Test
    public void loadでネットワークから取得した文字列を返す() throws Exception {
        // SetUp
        String expected = "Hello World";
        NetworkLoader mockLoader = mock(NetworkLoader.class);
        when(mockLoader.getInput()).thenReturn(new ByteArrayInputStream(expected.getBytes()));
        NetworkResources sut = new NetworkResources();
        sut.loader = mockLoader;
        // Exercise
        String actual = sut.load();
        // Assertion
        assertThat(actual, is(expected));
    }

}
