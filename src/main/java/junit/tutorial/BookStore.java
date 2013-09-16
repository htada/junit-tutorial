package junit.tutorial;

import java.util.ArrayList;
import java.util.List;

public class BookStore {
    
    private List<Book> books = new ArrayList<Book>();

    public void addToCart(Book book, int quantity) {
        for (int i = 0; i < quantity; i++) {
            books.add(book);
        }
    }

    public int getTotalPrice() {
        int amount = 0;
        for (Book b : books) {
            amount += b.getPrice();
        }
        return amount;
    }

    public Book get(int index) {
        if (books.size() <= index) {
            return new Book();
        }
        return books.get(index);
    }

}
