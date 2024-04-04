package be.wimdetroyer.javasandbox.visitor.oop.books;

import be.wimdetroyer.javasandbox.visitor.oop.visitor.Visitable;
import be.wimdetroyer.javasandbox.visitor.oop.visitor.BooksVisitor;

public class FictionBook extends Book implements Visitable {

    private FictionScale fictionScale;

    public FictionScale getFictionScale() {
        return fictionScale;
    }

    public void setFictionScale(FictionScale fictionScale) {
        this.fictionScale = fictionScale;
    }

    @Override
    public void accept(BooksVisitor v) {
        v.visitFictionBook(this);
    }

    public enum FictionScale {

        I_COULD_SEE_THIS_HAPPENING,
        SEEMS_UNLIKELY,
        NOT_IN_THIS_LIFETIME;
    }

}
