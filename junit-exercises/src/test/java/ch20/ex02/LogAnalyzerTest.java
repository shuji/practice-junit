package ch20.ex02;

import static org.mockito.Mockito.*;

import java.io.IOException;

import org.hamcrest.BaseMatcher;
import org.hamcrest.Description;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

/**
 * リスト20.5 例外ハンドリングのテスト
 * @author shuji.w6e
 */
public class LogAnalyzerTest {

    @Rule
    public ExpectedException ex = ExpectedException.none();

    @Test
    public void LogLoaderが例外を送出する時AnalyzeExceptionが再送出されること() throws Exception {
        // SetUp
        LogAnalyzer sut = new LogAnalyzer();
        final IOException errorCause = new IOException("error by stub");
        LogLoader mockLoader = mock(LogLoader.class);
        sut.logLoader = mockLoader;
        when(mockLoader.load("test")).thenThrow(errorCause);
        ex.expect(LogAnalyzer.AnalyzeException.class);
        ex.expectMessage("error by stub");
        ex.expect(new BaseMatcher<Object>() {
            Throwable cause;

            @Override
            public boolean matches(Object item) {
                Throwable t = (Throwable) item;
                cause = t.getCause();
                return cause == errorCause;
            }

            @Override
            public void describeTo(Description description) {
                description.appendValue(cause);
            }
        });
        // Exercise
        sut.analyze("test");
    }

}
