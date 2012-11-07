package ch03;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

/**
 * リスト3.5 ArrayListのaddメソッドのテスト
 * リスト3.6 4フェーズをコメントしたテストコード
 * @author shuji.w6e
 */
public class ArrayListTest {

    @Test
    public void addで要素を追加するとサイズが1となりgetで取得できる() throws Exception {
        ArrayList<String> sut = new ArrayList<String>();
        sut.add("Hello");
        assertThat(sut.size(), is(1));
        assertThat(sut.get(0), is("Hello"));
    }

    @Test
    public void 要素が2つ追加された状態で要素をremoveするとsizeが1となる() throws Exception {
        // SetUp
        ArrayList<String> sut = new ArrayList<String>();
        sut.add("Hello");
        sut.add("World");
        // Exercise
        sut.remove(0);
        // Verify
        assertThat(sut.size(), is(1));
        assertThat(sut.get(0), is("World"));
    }
}
