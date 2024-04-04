package be.wimdetroyer.javasandbox.visitor.oop.books;

import be.wimdetroyer.javasandbox.visitor.oop.visitor.BooksVisitor;
import be.wimdetroyer.javasandbox.visitor.oop.visitor.Visitable;

public class BestSellingFictionBook extends BestSellingBook implements Visitable {

    //TODO: duplication because it is a fictionbook...
    private FictionBook.FictionScale fictionScale;

    public FictionBook.FictionScale getFictionScale() {
        return fictionScale;
    }

    public void setFictionScale(FictionBook.FictionScale fictionScale) {
        this.fictionScale = fictionScale;
    }

    @Override
    public void accept(BooksVisitor v) {
        v.visitBestSellingFictionBook(this);
    }

    public BestSellingFictionBook(int copiesSold) {
        super(copiesSold);
    }
}
