package ch07;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Test;
import org.yaml.snakeyaml.Yaml;

/**
 * リスト7.8 YnakeYamlによるYAMLファイルの読み込み
 * @author shuji.w6e
 */
public class BookStoreYamlTest {

    @Test
    public void getTotalPrice() throws Exception {
        // SetUp
        BookStore sut = new BookStore();
        Book book = (Book) new Yaml().load(getClass().getResourceAsStream("book_fixtures.yaml"));
        sut.addToCart(book, 1);
        // Exercise & Verify
        assertThat(sut.getTotalPrice(), is(4500));
    }

    @Test
    public void get_0() throws Exception {
        // SetUp
        BookStore sut = new BookStore();
        Book book = (Book) new Yaml().load(getClass().getResourceAsStream("book_fixtures.yaml"));
        sut.addToCart(book, 1);
        // Exercise & Verify
        assertThat(sut.get(0), is(sameInstance(book)));
    }
}
