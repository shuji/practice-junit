package ch03;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

/**
 * リスト3.9 Testアノテーションの利用
 * リスト3.12 Ignoreアノテーションによるテストのスキップ
 * リスト3.13 Beforeアノテーションによる初期化処理
 * リスト3.14 Afterアノテーションによる後処理
 * リスト3.17 標準的な振る舞いを検証するテスト
 * @author shuji.w6e
 */
public class CalculatorTest {

    @Test
    public void addに3と4を与えると7を返す() throws Exception {
        // SetUp - 初期化
        Calculator sut = new Calculator();
        sut.init();
        // Exercise - テストの実行
        int actual = sut.add(3, 4);
        // Verify - 検証
        assertThat(actual, is(7));
        // TearDown - 後処理
        sut.shutdown();
    }

    Calculator sut;

    @Before
    public void setUp() throws Exception {
        sut = new Calculator();
        sut.init();
    }

    @After
    public void tearDown() throws Exception {
        sut.shutdown();
    }

    @Ignore("未実装")
    @Test
    public void divideに4と2を与えると2を返す() throws Exception {
        // Exercise - テストの実行
        int actual = sut.divide(3, 4);
        // Verify - 検証 
        assertThat(actual, is(7));
    }

}
