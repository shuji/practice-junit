package ch18.ex04;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Test;

/**
 * リスト18.8 同値クラスによるテスト
 * @author shuji.w6e
 */
public class NumberUtilsTest {

    @Test
    public void isEvenは10でtrueを返す() throws Exception {
        assertThat(NumberUtils.isEven(10), is(true));
    }

    @Test
    public void isEvenは7でfalseを返す() throws Exception {
        assertThat(NumberUtils.isEven(7), is(false));
    }
}
