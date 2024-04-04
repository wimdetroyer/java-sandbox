package be.wimdetroyer.javasandbox.visitor.oop.visitor;

import be.wimdetroyer.javasandbox.visitor.oop.books.BestSellingFictionBook;
import be.wimdetroyer.javasandbox.visitor.oop.books.FictionBook;
import be.wimdetroyer.javasandbox.visitor.oop.books.NonFictionBook;

public interface BooksVisitor {

    void visitFictionBook(FictionBook fictionBook);
    void visitNonFictionBook(NonFictionBook nonFictionBook);

    void visitBestSellingFictionBook(BestSellingFictionBook bestSellingFictionBook);

//    void visitBestSellingBannedNonFictionBook(BestSellingBannedNonFictionBook bestSellingBannedNonFictionBook);
}
