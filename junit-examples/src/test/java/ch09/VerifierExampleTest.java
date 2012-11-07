package ch09;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Verifier;

/**
 * リスト9.6 Verifierによる事後検証
 * @author shuji.w6e
 */
public class VerifierExampleTest {

    @Rule
    public Verifier verifier = new Verifier() {
        protected void verify() throws Throwable {
            assertThat("value should be 0.", sut.value, is(0));
        }
    };
    VerifierExample sut;

    @Before
    public void setUp() throws Exception {
        sut = new VerifierExample();
    }

    @Ignore("後処理としてsut.set(0)を実行していないため、テストは失敗する")
    @Test
    public void getValueで計算結果を取得する() throws Exception {
        sut.set(200);
        sut.add(100);
        sut.minus(50);
        int actual = sut.getValue();
        assertThat(actual, is(250));
    }
}
