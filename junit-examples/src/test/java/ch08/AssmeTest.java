package ch08;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;
import static org.junit.Assume.*;

import org.junit.Test;

/**
 * リスト8.18 assumeの利用
 * @author shuji.w6e
 */
public class AssmeTest {

    @Test
    public void assume() throws Exception {
        assumeThat(1, is(0));
        fail("この行は実行されない");
    }
}
