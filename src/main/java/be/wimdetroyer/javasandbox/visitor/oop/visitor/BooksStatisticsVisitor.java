package be.wimdetroyer.javasandbox.visitor.oop.visitor;

import be.wimdetroyer.javasandbox.visitor.oop.books.FictionBook;
import be.wimdetroyer.javasandbox.visitor.oop.books.NonFictionBook;

import java.util.HashSet;
import java.util.Set;

public class BooksStatisticsVisitor implements BooksVisitor {

    // Internal state of the visitor - see: https://stackoverflow.com/questions/29593091/visitor-design-pattern-return-type
    private final Set<String> fictionAuthorsSet = new HashSet<>();
    private int countLifeChangingNonFictionBooks = 0;

    @Override
    public void visitFictionBook(FictionBook fictionBook) {
        fictionAuthorsSet.add(fictionBook.getAuthor());
    }

    @Override
    public void visitNonFictionBook(NonFictionBook nonFictionBook) {
        if (nonFictionBook.getInterestingnessFactor() == NonFictionBook.InterestingnessFactor.LIFE_CHANGING) {
            countLifeChangingNonFictionBooks++;
        }
    }

    public String printStatistics() {
        return String.format("Fiction Authors: %d\nLife Changing Non-Fiction Books: %d", fictionAuthorsSet.size(), countLifeChangingNonFictionBooks);
    }

}
