package be.wimdetroyer.javasandbox.visitor.oop.books;

import be.wimdetroyer.javasandbox.visitor.oop.books.types.BookFlavour;

import be.wimdetroyer.javasandbox.visitor.oop.visitor.Visitable;
import be.wimdetroyer.javasandbox.visitor.oop.visitor.BooksVisitor;
import lombok.Getter;

@Getter
public class FictionBook extends Book implements Visitable {

    private final FictionScale fictionScale;
    private final BookFlavour bookFlavour;

    public FictionBook(String isbn, String title, String author, String summary, FictionScale fictionScale, BookFlavour bookFlavour) {
        if(bookFlavour.getBookFlavourDiscriminator() == BookFlavour.BookFlavourDiscriminator.BANNED_BOOK) {
            throw new IllegalArgumentException("Fiction Books can't be of BANNED BookType");
        }
        super(isbn, title, author, summary, bookFlavour);
        this.fictionScale = fictionScale;

        this.bookFlavour = bookFlavour;
    }

    public enum FictionScale {

        I_COULD_SEE_THIS_HAPPENING,
        SEEMS_UNLIKELY,
        NOT_IN_THIS_LIFETIME
    }


    @Override
    public void accept(BooksVisitor v) {
        v.visitFictionBook(this);
    }

}
