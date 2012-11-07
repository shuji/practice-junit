package ch04;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Test;

/**
 * リスト4.1 assertThatによる比較検証
 * @author shuji.w6e
 */
public class AssertionTest {
    
    @Test
    public void assertion() {
        String actual = "Hello" + " " + "World";
        assertThat(actual, is("Hello World"));
    }
}
