package ch08;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;
import static org.junit.Assume.*;

import org.junit.Test;

/**
 * リスト8.20 Windows環境のみで実行するテストケース
 * @author shuji.w6e
 */
public class WindowsOnlyTest {

    @Test
    public void windows環境では改行はrn() throws Exception {
        assumeTrue(System.getProperty("os.name").contains("Windows"));
        assertThat(System.getProperty("line.separator"), is("\r\n"));
    }
}
