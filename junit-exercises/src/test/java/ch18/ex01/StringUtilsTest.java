package ch18.ex01;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Test;

/**
 * リスト18.1 状態を持たないメソッドのテスト
 * @author shuji.w6e
 */
public class StringUtilsTest {

    @Test
    public void toSnakeCaseはスネークケースを返す_aaaの場合() {
        assertThat(StringUtils.toSnakeCase("aaa"), is("aaa"));
    }

    @Test
    public void toSnakeCaseはスネークケースを返す_HelloWorldの場合() {
        assertThat(StringUtils.toSnakeCase("HelloWorld"), is("hello_world"));
    }

    @Test
    public void toSnakeCaseはスネークケースを返す_practiceJunitの場合() {
        assertThat(StringUtils.toSnakeCase("practiceJunit"), is("practice_junit"));
    }
}
