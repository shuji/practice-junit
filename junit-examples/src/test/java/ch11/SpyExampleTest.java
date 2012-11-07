package ch11;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;
import static org.mockito.Matchers.*;
import static org.mockito.Mockito.*;

import java.util.logging.Logger;

import org.junit.Test;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

/**
 * リスト11.22 ロガーオブジェクトにログを記録していることを検証するテスト
 * リスト11.30 スパイオブジェクトの作成
 * リスト11.32 ロガーのスパイオブジェクトの利用
 * @author shuji.w6e
 */
public class SpyExampleTest {

    @Test
    public void SpyLoggerを利用したテスト() {
        SpyExample sut = new SpyExample();
        SpyLogger spy = new SpyLogger(sut.logger);
        sut.logger = spy;
        sut.doSomething();
        assertThat(spy.log.toString(), is("doSomething"));
    }

    @Test
    public void Mockitoのspyを使ったテスト() throws Exception {
        // SetUp
        SpyExample sut = new SpyExample();
        Logger spy = spy(sut.logger);
        final StringBuilder infoLog = new StringBuilder();
        doAnswer(new Answer<Void>() {

            @Override
            public Void answer(InvocationOnMock invocation) throws Throwable {
                infoLog.append(invocation.getArguments()[0]);
                invocation.callRealMethod();
                return null;
            }
        }).when(spy).info(anyString());
        sut.logger = spy;
        // Exercise
        sut.doSomething();
        // Verify
        assertThat(infoLog.toString(), is("doSomething"));
    }
}
