package ch07;

import java.util.ArrayList;
import java.util.List;

public class BookStore {

    List<Book> cart = new ArrayList<Book>();

    public void addToCart(Book book, int num) {
        for (int i = 0; i < num; i++) {
            cart.add(book);
        }
    }

    public int getTotalPrice() {
        int result = 0;
        for (Book book : cart) {
            result += book.getPrice();
        }
        return result;
    }

    public Book get(int idx) {
        return cart.get(idx);
    }
}
