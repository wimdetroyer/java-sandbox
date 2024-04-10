package be.wimdetroyer.javasandbox.visitor.oop.books;

import be.wimdetroyer.javasandbox.visitor.oop.books.types.BookFlavour;
import lombok.Getter;

@Getter
public abstract class Book {

    private final String isbn;
    private final String title;
    private final String author;
    private final String summary;
    private final BookFlavour bookFlavour;

    public Book(String isbn, String title, String author, String summary, BookFlavour bookFlavour) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.summary = summary;
        this.bookFlavour = bookFlavour;
    }

}
