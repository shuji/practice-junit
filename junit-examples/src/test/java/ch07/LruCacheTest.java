package ch07;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * リスト7.4 ネストしたクラスごとに行われる暗黙的セットアップ
 * @author shuji.w6e
 */
@RunWith(Enclosed.class)
public class LruCacheTest {

    public static class AとBを追加している場合 {
        LruCache<String> sut;

        @Before
        public void setUp() throws Exception {
            sut = new LruCache<String>();
            sut.put("A", "valueA");
            sut.put("B", "valueB");
        }

        @Test
        public void sizeは2() throws Exception {
            assertThat(sut.size(), is(2));
        }

        @Test
        public void get_AでvalueAを返しkeysはBA() throws Exception {
            assertThat(sut.get("A"), is("valueA"));
            assertThat(sut.keys.size(), is(2));
            assertThat(sut.keys.get(0), is("B"));
            assertThat(sut.keys.get(1), is("A"));
        }

        @Test
        public void get_BでvalueBを返しkeysはAB() throws Exception {
            assertThat(sut.get("B"), is("valueB"));
            assertThat(sut.keys.size(), is(2));
            assertThat(sut.keys.get(0), is("A"));
            assertThat(sut.keys.get(1), is("B"));
        }

        @Test
        public void get_Cでnullを返しkeysはAB() throws Exception {
            assertThat(sut.get("C"), is(nullValue()));
            assertThat(sut.keys.size(), is(2));
            assertThat(sut.keys.get(0), is("A"));
            assertThat(sut.keys.get(1), is("B"));
        }

        @Test
        public void put_Cでsizeは3_keysはABCとなる() throws Exception {
            // Set up
            String key = "C";
            String item = "valueC";
            // Exercise
            sut.put(key, item);
            // Verify
            assertThat(sut.size(), is(3));
            assertThat(sut.keys.size(), is(3));
            assertThat(sut.keys.get(0), is("A"));
            assertThat(sut.keys.get(1), is("B"));
            assertThat(sut.keys.get(2), is("C"));
        }
    }
}
