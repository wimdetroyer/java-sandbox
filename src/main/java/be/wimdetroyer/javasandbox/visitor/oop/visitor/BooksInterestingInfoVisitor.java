package be.wimdetroyer.javasandbox.visitor.oop.visitor;

import be.wimdetroyer.javasandbox.visitor.oop.books.FictionBook;
import be.wimdetroyer.javasandbox.visitor.oop.books.NonFictionBook;

import java.util.ArrayList;
import java.util.List;

public class BooksInterestingInfoVisitor implements BooksVisitor {

    // Internal state of the visitor - see: https://stackoverflow.com/questions/29593091/visitor-design-pattern-return-type
    private final List<String> interestingInformationCollection = new ArrayList<>();
    @Override
    public void visitFictionBook(FictionBook fictionBook) {
        var fictionScale = fictionBook.getFictionScale();
        var summary = fictionBook.getSummary();
        var title = fictionBook.getTitle();
        var interestingInfoFiction = "book number %s | %s | %s | %s".formatted(interestingInformationCollection.size() + 1, title, summary, fictionScale.name());
        interestingInformationCollection.add(interestingInfoFiction);
    }

    @Override
    public void visitNonFictionBook(NonFictionBook nonFictionBook) {
        var interestingnessFactor = nonFictionBook.getInterestingnessFactor();
        var title = nonFictionBook.getTitle();
        var interestingInfoNonFiction = "book number %s | %s | %s".formatted(interestingInformationCollection.size() + 1, title, interestingnessFactor);
        interestingInformationCollection.add(interestingInfoNonFiction);

    }

    public String printOutInterestingInformation() {
        return String.join("\n", interestingInformationCollection);
    }
}
