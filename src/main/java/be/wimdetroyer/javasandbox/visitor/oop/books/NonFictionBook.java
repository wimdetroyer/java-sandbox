package be.wimdetroyer.javasandbox.visitor.oop.books;

import be.wimdetroyer.javasandbox.visitor.oop.visitor.Visitable;
import be.wimdetroyer.javasandbox.visitor.oop.visitor.BooksVisitor;

public class NonFictionBook extends Book implements Visitable {

    private InterestingnessFactor interestingnessFactor;

    public InterestingnessFactor getInterestingnessFactor() {
        return interestingnessFactor;
    }

    public void setInterestingnessFactor(InterestingnessFactor interestingnessFactor) {
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
