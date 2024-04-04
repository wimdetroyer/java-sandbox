package be.wimdetroyer.javasandbox.visitor.oop;

import be.wimdetroyer.javasandbox.visitor.oop.books.Book;
import be.wimdetroyer.javasandbox.visitor.oop.books.FictionBook;
import be.wimdetroyer.javasandbox.visitor.oop.books.NonFictionBook;
import be.wimdetroyer.javasandbox.visitor.oop.visitor.BooksInterestingInfoVisitor;
import be.wimdetroyer.javasandbox.visitor.oop.visitor.BooksStatisticsVisitor;

import java.util.List;


public class VisitorExample {


    public static void main(String[] args) {
        var mockLibrary = MockLibraryProvider.createMockLibrary();
        System.out.println("--- Interesting info ---");
        printOutInterestingInfo(mockLibrary);
        System.out.println("--- Statistics ---");
        printStatistics(mockLibrary);
    }

    private static void printStatistics(List<Book> mockLibrary) {
        var booksStatisticsVisitor = new BooksStatisticsVisitor();
        for (Book book : mockLibrary) {
            if(book instanceof NonFictionBook nonFictionBook) {
                booksStatisticsVisitor.visitNonFictionBook(nonFictionBook);
            }
            if(book instanceof FictionBook fictionBook) {
                booksStatisticsVisitor.visitFictionBook(fictionBook);
            }
        }

        System.out.println(booksStatisticsVisitor.printStatistics());
    }

    private static void printOutInterestingInfo(List<Book> mockLibrary) {
        var booksInterestingInfoVisitor = new BooksInterestingInfoVisitor();
        for (Book book : mockLibrary) {
            if(book instanceof NonFictionBook nonFictionBook) {
                booksInterestingInfoVisitor.visitNonFictionBook(nonFictionBook);
            }
            if(book instanceof FictionBook fictionBook) {
                booksInterestingInfoVisitor.visitFictionBook(fictionBook);
            }
        }

        System.out.println(booksInterestingInfoVisitor.printOutInterestingInformation());
    }


}
