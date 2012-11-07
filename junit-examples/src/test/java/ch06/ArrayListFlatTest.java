package ch06;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

/**
 * リスト6.5 構造化されていないArrayListのテストクラス
 * @author shuji.w6e
 */
public class ArrayListFlatTest {

    private ArrayList<String> sut;

    @Before
    public void setUp() throws Exception {
        sut = new ArrayList<String>();
    }

    @Test
    public void listに1件追加してある場合_sizeは1を返す() throws Exception {
        sut.add("A");
        int actual = sut.size();
        assertThat(actual, is(1));
    }

    @Test
    public void listに2件追加してある場合_sizeは2を返す() throws Exception {
        sut.add("A");
        sut.add("B");
        int actual = sut.size();
        assertThat(actual, is(2));
    }
}
