package be.wimdetroyer.javasandbox.visitor.oop;

import be.wimdetroyer.javasandbox.visitor.oop.books.Book;
import be.wimdetroyer.javasandbox.visitor.oop.books.FictionBook;
import be.wimdetroyer.javasandbox.visitor.oop.books.NonFictionBook;
import be.wimdetroyer.javasandbox.visitor.oop.books.types.BannedBookFlavour;
import be.wimdetroyer.javasandbox.visitor.oop.books.types.BestSellingBookFlavour;
import be.wimdetroyer.javasandbox.visitor.oop.books.types.OrdinaryBookFlavour;

import java.util.ArrayList;
import java.util.List;

public class MockLibraryProvider {


    public static List<Book> createMockLibrary() {
        List<Book> library = new ArrayList<>();

        // Fiction Books
        FictionBook fictionBook1 = new FictionBook(
                "978-1-234567-89-0",
                "The Lost Kingdom",
                "John Smith",
                "In the mystical land of Avaloria, a long-forgotten kingdom resurfaces, bringing with it ancient prophecies and untold dangers.",
                FictionBook.FictionScale.I_COULD_SEE_THIS_HAPPENING,
                new BestSellingBookFlavour(1500)
        );

        FictionBook fictionBook2 = new FictionBook(
                "978-1-234567-89-1",
                "Echoes of Eternity",
                "Emily Jones",
                "When a mysterious artifact is discovered, it sets off a chain of events that threatens to unravel the fabric of time itself.",
                FictionBook.FictionScale.SEEMS_UNLIKELY,
                new BestSellingBookFlavour(2500)
        );

        FictionBook fictionBook3 = new FictionBook(
                "978-1-234567-89-2",
                "The Last Stand",
                "David Brown",
                "In a post-apocalyptic world, humanity's last hope lies in a small band of survivors who must confront their inner demons to rebuild civilization.",
                FictionBook.FictionScale.NOT_IN_THIS_LIFETIME,
                new BestSellingBookFlavour(3000)
        );

        FictionBook fictionBook4 = new FictionBook(
                "978-1-234567-89-3",
                "Whispers in the Dark",
                "Sarah Adams",
                "When strange whispers begin haunting the residents of a small town, a group of friends embarks on a journey to uncover the truth behind the chilling voices.",
                FictionBook.FictionScale.I_COULD_SEE_THIS_HAPPENING,
                new BestSellingBookFlavour(5000)
        );

        FictionBook fictionBook5 = new FictionBook(
                "978-1-234567-89-4",
                "Shadows of Betrayal",
                "Michael Johnson",
                "As kingdoms clash and alliances crumble, a young prince must navigate the treacherous waters of politics and deception to reclaim his rightful throne.",
                FictionBook.FictionScale.SEEMS_UNLIKELY,
                new BestSellingBookFlavour(10000)
        );

        // Non-Fiction Books
        NonFictionBook nonFictionBook1 = new NonFictionBook(
                "978-1-234567-90-0",
                "The Power of Habit",
                "Charles Duhigg",
                "Drawing on the latest research in psychology and neuroscience, this book explores the science behind habits and how they shape our lives.",
                new BestSellingBookFlavour(50000),
                NonFictionBook.InterestingnessFactor.LIFE_CHANGING
        );

        NonFictionBook nonFictionBook2 = new NonFictionBook(
                "978-1-234567-90-1",
                "Sapiens: A Brief History of Humankind",
                "Yuval Noah Harari",
                "From the emergence of Homo sapiens to the present day, this book provides a sweeping narrative of human history and the forces that have shaped our species.",
                new BestSellingBookFlavour(1000000),
                NonFictionBook.InterestingnessFactor.LIFE_CHANGING
        );

        NonFictionBook nonFictionBook3 = new NonFictionBook(
                "978-1-234567-90-2",
                "The Subtle Art of Not Giving a F*ck",
                "Mark Manson",
                "By embracing the uncomfortable truths of life, this book offers a refreshing approach to living a meaningful and fulfilling existence.",
                new BannedBookFlavour(BannedBookFlavour.BanReasonCategory.TOO_OBSCENE, "Contains explicit language and mature themes. Seriously, it's too much, even for me. and some more gibberish to get to the character limit"),
                NonFictionBook.InterestingnessFactor.LIFE_CHANGING
        );

        NonFictionBook nonFictionBook4 = new NonFictionBook(
                "978-1-234567-90-3",
                "Educated",
                "Tara Westover",
                "A powerful memoir of resilience and self-discovery, this book chronicles the author's journey from a survivalist upbringing to earning a PhD from Cambridge University.",
                new BannedBookFlavour(BannedBookFlavour.BanReasonCategory.DISINFORMATION, "Contains misleading information and false claims."),
                NonFictionBook.InterestingnessFactor.INTERESTING
        );

        // Books with Ordinary Book Flavour
        NonFictionBook nonFictionBook5 = new NonFictionBook(
                "978-1-234567-90-4",
                "How to Win Friends and Influence People",
                "Dale Carnegie",
                "This timeless classic offers practical advice on how to improve communication skills and build meaningful relationships.",
                new OrdinaryBookFlavour(),
                NonFictionBook.InterestingnessFactor.LIFE_CHANGING
        );

        // Add all books to the library
        library.add(fictionBook1);
        library.add(fictionBook2);
        library.add(fictionBook3);
        library.add(fictionBook4);
        library.add(fictionBook5);
        library.add(nonFictionBook1);
        library.add(nonFictionBook2);
        library.add(nonFictionBook3);
        library.add(nonFictionBook4);
        library.add(nonFictionBook5);

        return library;
    }
}
