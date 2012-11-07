package ch08;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;
import static ch08.Janken.Hand.*;
import static ch08.Janken.Result.*;

import org.junit.Before;
import org.junit.Test;

/**
 * リスト8.3 じゃんけんのテストコード
 * @author shuji.w6e
 */
public class JankenTest {

    private Janken sut;

    @Before
    public void setUp() throws Exception {
        sut = new Janken();
    }

    @Test
    public void グーとチョキなら勝利() throws Exception {
        assertThat(sut.judge(GU, TYOKI), is(WIN));
    }

    @Test
    public void グーとパーなら敗北() throws Exception {
        assertThat(sut.judge(GU, PA), is(LOSE));
    }

    @Test
    public void グーとグーなら引き分け() throws Exception {
        assertThat(sut.judge(GU, GU), is(DRAW));
    }

    @Test
    public void チョキとパーなら勝利() throws Exception {
        assertThat(sut.judge(TYOKI, PA), is(WIN));
    }
    
    // 以下略
}
