package be.wimdetroyer.javasandbox.visitor.oop.visitor;

import be.wimdetroyer.javasandbox.visitor.oop.books.Book;
import be.wimdetroyer.javasandbox.visitor.oop.books.FictionBook;
import be.wimdetroyer.javasandbox.visitor.oop.books.NonFictionBook;
import be.wimdetroyer.javasandbox.visitor.oop.books.types.BannedBookFlavour;
import be.wimdetroyer.javasandbox.visitor.oop.books.types.BestSellingBookFlavour;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

public class BooksInterestingInfoVisitor implements BooksVisitor {

    private final List<String> interestingInformationCollection = new ArrayList<>();

    @Override
    public void visitFictionBook(FictionBook fictionBook) {
        StringJoiner stringBuilder = new StringJoiner(System.lineSeparator());
        writeHeader(stringBuilder, fictionBook);
        writeBookInformation(stringBuilder, fictionBook);
        writeBookFlavourInformation(stringBuilder, fictionBook);
        writeFooter(stringBuilder);
        interestingInformationCollection.add(stringBuilder.toString());
    }

    private void writeBookInformation(StringJoiner stringBuilder, Book book) {
        stringBuilder.add("--- BEGIN INTERESTING INFO ---");
        if (book instanceof FictionBook fictionBook) {
            stringBuilder.add("Summary: %s | FictionScale: %s".formatted(fictionBook.getSummary(), fictionBook.getFictionScale().name()));
        } else if (book instanceof NonFictionBook nonFictionBook) {
            stringBuilder.add("Interestingnessfactor: %s".formatted(nonFictionBook.getInterestingnessFactor().name()));
        }
        stringBuilder.add("--- END INTERESTING INFO ---");
    }

    @Override
    public void visitNonFictionBook(NonFictionBook nonFictionBook) {
        StringJoiner stringBuilder = new StringJoiner(System.lineSeparator());
        writeHeader(stringBuilder, nonFictionBook);
        writeBookInformation(stringBuilder, nonFictionBook);
        writeBookFlavourInformation(stringBuilder, nonFictionBook);
        writeFooter(stringBuilder);
        interestingInformationCollection.add(stringBuilder.toString());
    }
    

    private void writeBookFlavourInformation(StringJoiner stringBuilder, Book book) {
        stringBuilder.add("--- BEGIN OF BOOK FLAVOUR INFO ---");
        if (book instanceof FictionBook fictionBook) {
            // we know this because of invariants
            var bestSellingBookFlavour = (BestSellingBookFlavour) fictionBook.getBookFlavour();
            stringBuilder.add("Copies sold: %s".formatted(bestSellingBookFlavour.getCopiesSold()));
        } else if (book instanceof NonFictionBook nonFictionBook) {
            var bookFlavour = nonFictionBook.getBookFlavour();
            if(bookFlavour instanceof BannedBookFlavour bannedBookFlavour) {
                stringBuilder.add("This book is banned because %s explanation: %s".formatted(bannedBookFlavour.getBanReasonCategory(), bannedBookFlavour.getBanExplanation()));
            } else if (bookFlavour instanceof BestSellingBookFlavour bestSellingBookFlavour) {
                stringBuilder.add("Copies sold: %s".formatted(bestSellingBookFlavour.getCopiesSold()));

            }
        }
        stringBuilder.add("--- END OF BOOK FLAVOUR INFO ---");
    }

    private void writeHeader(StringJoiner stringBuilder, Book book) {
        stringBuilder.add("--- BEGIN BOOK INFORMATION ---");
        stringBuilder.add("book number %s - %s".formatted(interestingInformationCollection.size() + 1, book.getTitle()));
    }

    private void writeFooter(StringJoiner stringBuilder) {
        stringBuilder.add("--- END BOOK INFORMATION ---");
    }

    public String printOutInterestingInformation() {
        return String.join(System.lineSeparator(), interestingInformationCollection);
    }
}
