package be.wimdetroyer.javasandbox.visitor.oop.books;

import be.wimdetroyer.javasandbox.visitor.oop.books.types.BookFlavour;
import be.wimdetroyer.javasandbox.visitor.oop.visitor.Visitable;
import be.wimdetroyer.javasandbox.visitor.oop.visitor.BooksVisitor;
import lombok.Getter;

@Getter
public class NonFictionBook extends Book implements Visitable {

    private InterestingnessFactor interestingnessFactor;

    public NonFictionBook(String isbn, String title, String author, String summary, BookFlavour bookFlavour, InterestingnessFactor interestingnessFactor) {
        if(bookFlavour.getBookFlavourDiscriminator() == BookFlavour.BookFlavourDiscriminator.BEST_SELLING_BOOK) {
            if(interestingnessFactor != InterestingnessFactor.LIFE_CHANGING) {
                throw new IllegalArgumentException("Interestingness factor must be LIFE_CHANGING if this is a best seller!");
            }
        }
        super(isbn, title, author, summary, bookFlavour);
        this.interestingnessFactor = interestingnessFactor;
    }


    @Override
    public void accept(BooksVisitor v) {
        v.visitNonFictionBook(this);
    }

    public enum InterestingnessFactor {

        MILDLY_INTERESTING,
        INTERESTING,
        LIFE_CHANGING;
    }

}
