package ch07;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Test;

/**
 * リスト7.2 複雑なフィクスチャのセットアップ
 * @author shuji.w6e
 */
public class BookStoreComplexSetupTest {

    @Test
    public void getTotalPrice() throws Exception {
        // SetUp
        Book book = new Book();
        book.setTitle("Refactoring");
        book.setPrice(4500);
        Author author = new Author();
        author.setFirstName("Martin");
        author.setLastName("Fowler");
        book.setAuthor(author);
        BookStore sut = new BookStore();
        sut.addToCart(book, 1);
        // Exercise & Verify
        assertThat(sut.getTotalPrice(), is(4500));
    }
}
