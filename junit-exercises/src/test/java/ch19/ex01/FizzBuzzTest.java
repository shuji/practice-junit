package ch19.ex01;

import static ch19.ex01.Lists.*;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

/**
 * リスト19.1 リストを1つずつ検証するテスト
 * リスト19.3 リストを作成して検証する
 * リスト19.5 カスタムMatcherを使ったテストコード
 * @author shuji.w6e
 */
public class FizzBuzzTest {

    @Test
    public void createFizzBuzzListで16まで取得できる() {
        List<String> actual = FizzBuzz.createFizzBuzzList(16);
        assertThat(actual, is(notNullValue()));
        assertThat(actual.size(), is(16));
        assertThat(actual.get(0), is("1"));
        assertThat(actual.get(1), is("2"));
        assertThat(actual.get(2), is("Fizz"));
        assertThat(actual.get(3), is("4"));
        assertThat(actual.get(4), is("Buzz"));
        assertThat(actual.get(5), is("Fizz"));
        assertThat(actual.get(6), is("7"));
        assertThat(actual.get(7), is("8"));
        assertThat(actual.get(8), is("Fizz"));
        assertThat(actual.get(9), is("Buzz"));
        assertThat(actual.get(10), is("11"));
        assertThat(actual.get(11), is("Fizz"));
        assertThat(actual.get(12), is("13"));
        assertThat(actual.get(13), is("14"));
        assertThat(actual.get(14), is("FizzBuzz"));
        assertThat(actual.get(15), is("16"));
    }

    @Test
    public void createFizzBuzzListで16まで取得できる2() {
        List<String> expected = new ArrayList<String>(16);
        expected.add("1");
        expected.add("2");
        expected.add("Fizz");
        expected.add("4");
        expected.add("Buzz");
        expected.add("Fizz");
        expected.add("7");
        expected.add("8");
        expected.add("Fizz");
        expected.add("Buzz");
        expected.add("11");
        expected.add("Fizz");
        expected.add("13");
        expected.add("14");
        expected.add("FizzBuzz");
        expected.add("16");
        List<String> actual = FizzBuzz.createFizzBuzzList(16);
        assertThat(actual, is(expected));
    }

    @Test
    public void createFizzBuzzListで6まで取得できる() {
        List<String> actual = FizzBuzz.createFizzBuzzList(6);
        assertThat(actual, is(list("1", "2", "Fizz", "4", "Buzz", "Fizz")));
    }

}
