package ch04;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

/**
 * リスト4.2 failメソッドによるテストの失敗
 * リスト4.3 特定のステップが呼び出されると失敗となるテスト
 * @author shuji.w6e
 */
public class AssertionFailTest {

    AssertionFail sut;

    @Before
    public void setUp() throws Exception {
        sut = new AssertionFail();
    }

    @Ignore("動作確認する時は@Ignoreをコメントアウトしてください")
    @Test
    public void なにか難しいけど重要なテストケース() {
        fail("TODO テストコードを実装する");
    }

    @Test(expected = IllegalStateException.class)
    public void timeoutがtrueのときにロジックが実行されないこと() {
        // SetUp
        Runnable logic = new Runnable() {
            public void run() {
                fail("run が呼ばれてしまった");
            }
        };
        sut.timeOut = true;
        // Exercise
        sut.invoke(logic);
    }
}
