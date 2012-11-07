package ch09;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Verifier;

/**
 * リスト9.7 ErrorLogのサイズの検証を行うVerifier
 * @author shuji.w6e
 */
public class VerifierExternalObjectExampleTest {
    ErrorLog log = new ErrorLog();

    @Rule
    public ErrorLogVerifier errorLogVerifier = new ErrorLogVerifier(log);

    @Ignore("事後条件でErrorLogが空であるため、テストは失敗する")
    @Test
    public void testCase() throws Exception {
    }
}

class ErrorLogVerifier extends Verifier {
    final ErrorLog log;

    ErrorLogVerifier(ErrorLog log) {
        this.log = log;
    }

    @Override
    protected void verify() throws Throwable {
        assertThat(log.size(), is(not(0)));
    }
}