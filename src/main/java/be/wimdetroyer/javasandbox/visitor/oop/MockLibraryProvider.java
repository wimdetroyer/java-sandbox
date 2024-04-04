package be.wimdetroyer.javasandbox.visitor.oop;

import be.wimdetroyer.javasandbox.visitor.oop.books.Book;
import be.wimdetroyer.javasandbox.visitor.oop.books.FictionBook;
import be.wimdetroyer.javasandbox.visitor.oop.books.NonFictionBook;

import java.util.ArrayList;
import java.util.List;

public class MockLibraryProvider {


    public static List<Book> createMockLibrary() {
        List<Book> library = new ArrayList<>();

        // Fiction Books
        FictionBook fictionBook1 = new FictionBook();
        fictionBook1.setFictionScale(FictionBook.FictionScale.I_COULD_SEE_THIS_HAPPENING);
        fictionBook1.setAuthor("John Smith");
        fictionBook1.setTitle("The Lost Kingdom");
        fictionBook1.setSummary("In the mystical land of Avaloria, a long-forgotten kingdom resurfaces, " +
                "bringing with it ancient prophecies and untold dangers.");

        FictionBook fictionBook2 = new FictionBook();
        fictionBook2.setFictionScale(FictionBook.FictionScale.SEEMS_UNLIKELY);
        fictionBook2.setAuthor("Emily Jones");
        fictionBook2.setTitle("Echoes of Eternity");
        fictionBook2.setSummary("When a mysterious artifact is discovered, it sets off a chain of events " +
                "that threatens to unravel the fabric of time itself.");

        FictionBook fictionBook3 = new FictionBook();
        fictionBook3.setFictionScale(FictionBook.FictionScale.NOT_IN_THIS_LIFETIME);
        fictionBook3.setAuthor("David Brown");
        fictionBook3.setTitle("The Last Stand");
        fictionBook3.setSummary("In a post-apocalyptic world, humanity's last hope lies in a small band " +
                "of survivors who must confront their inner demons to rebuild civilization.");

        FictionBook fictionBook4 = new FictionBook();
        fictionBook4.setFictionScale(FictionBook.FictionScale.I_COULD_SEE_THIS_HAPPENING);
        fictionBook4.setAuthor("Sarah Adams");
        fictionBook4.setTitle("Whispers in the Dark");
        fictionBook4.setSummary("When strange whispers begin haunting the residents of a small town, " +
                "a group of friends embarks on a journey to uncover the truth behind the chilling voices.");

        FictionBook fictionBook5 = new FictionBook();
        fictionBook5.setFictionScale(FictionBook.FictionScale.SEEMS_UNLIKELY);
        fictionBook5.setAuthor("Michael Johnson");
        fictionBook5.setTitle("Shadows of Betrayal");
        fictionBook5.setSummary("As kingdoms clash and alliances crumble, a young prince must navigate " +
                "the treacherous waters of politics and deception to reclaim his rightful throne.");

        FictionBook fictionBook6 = new FictionBook();
        fictionBook6.setFictionScale(FictionBook.FictionScale.NOT_IN_THIS_LIFETIME);
        fictionBook6.setAuthor("Jessica White");
        fictionBook6.setTitle("Beyond the Horizon");
        fictionBook6.setSummary("In a world torn apart by war, two star-crossed lovers embark on a " +
                "dangerous journey to find a legendary sanctuary rumored to bring peace to the land.");

        FictionBook fictionBook7 = new FictionBook();
        fictionBook7.setFictionScale(FictionBook.FictionScale.I_COULD_SEE_THIS_HAPPENING);
        fictionBook7.setAuthor("Daniel Wilson");
        fictionBook7.setTitle("The Forgotten City");
        fictionBook7.setSummary("Deep within the heart of the Amazon rainforest lies a hidden city " +
                "shrouded in mystery and danger, waiting to be discovered by those brave enough to seek it.");

        FictionBook fictionBook8 = new FictionBook();
        fictionBook8.setFictionScale(FictionBook.FictionScale.SEEMS_UNLIKELY);
        fictionBook8.setAuthor("Sophia Martinez");
        fictionBook8.setTitle("The Crimson Empire");
        fictionBook8.setSummary("In a world ruled by bloodthirsty tyrants, a lone warrior " +
                "rises from the ashes to challenge the oppressive regime and ignite a rebellion.");

        FictionBook fictionBook9 = new FictionBook();
        fictionBook9.setFictionScale(FictionBook.FictionScale.NOT_IN_THIS_LIFETIME);
        fictionBook9.setAuthor("Nathan Thompson");
        fictionBook9.setTitle("Eternal Twilight");
        fictionBook9.setSummary("When darkness descends upon the realm, a group of unlikely heroes " +
                "must embark on a perilous quest to restore light to a world on the brink of oblivion.");

        FictionBook fictionBook10 = new FictionBook();
        fictionBook10.setFictionScale(FictionBook.FictionScale.I_COULD_SEE_THIS_HAPPENING);
        fictionBook10.setAuthor("Isabella Brown");
        fictionBook10.setTitle("The Forbidden Tome");
        fictionBook10.setSummary("Within the forbidden halls of an ancient library lies a " +
                "book of unimaginable power, waiting to be unleashed by those who dare to defy destiny.");

        // Non-Fiction Books
        NonFictionBook nonFictionBook1 = new NonFictionBook();
        nonFictionBook1.setInterestingnessFactor(NonFictionBook.InterestingnessFactor.MILDLY_INTERESTING);
        nonFictionBook1.setAuthor("Robert Johnson");
        nonFictionBook1.setTitle("The Power of Habit");
        nonFictionBook1.setSummary("Drawing on the latest research in psychology and neuroscience, " +
                "this book explores the science behind habits and how they shape our lives.");

        NonFictionBook nonFictionBook2 = new NonFictionBook();
        nonFictionBook2.setInterestingnessFactor(NonFictionBook.InterestingnessFactor.INTERESTING);
        nonFictionBook2.setAuthor("Jennifer Davis");
        nonFictionBook2.setTitle("Sapiens: A Brief History of Humankind");
        nonFictionBook2.setSummary("From the emergence of Homo sapiens to the present day, " +
                "this book provides a sweeping narrative of human history and the forces that have shaped our species.");

        NonFictionBook nonFictionBook3 = new NonFictionBook();
        nonFictionBook3.setInterestingnessFactor(NonFictionBook.InterestingnessFactor.LIFE_CHANGING);
        nonFictionBook3.setAuthor("David Smith");
        nonFictionBook3.setTitle("The Subtle Art of Not Giving a F*ck");
        nonFictionBook3.setSummary("By embracing the uncomfortable truths of life, this book " +
                "offers a refreshing approach to living a meaningful and fulfilling existence.");

        NonFictionBook nonFictionBook4 = new NonFictionBook();
        nonFictionBook4.setInterestingnessFactor(NonFictionBook.InterestingnessFactor.MILDLY_INTERESTING);
        nonFictionBook4.setAuthor("Emily Wilson");
        nonFictionBook4.setTitle("Educated");
        nonFictionBook4.setSummary("A powerful memoir of resilience and self-discovery, " +
                "this book chronicles the author's journey from a survivalist upbringing to earning a PhD from Cambridge University.");

        NonFictionBook nonFictionBook5 = new NonFictionBook();
        nonFictionBook5.setInterestingnessFactor(NonFictionBook.InterestingnessFactor.INTERESTING);
        nonFictionBook5.setAuthor("Michael Brown");
        nonFictionBook5.setTitle("Atomic Habits");
        nonFictionBook5.setSummary("Through practical strategies and actionable advice, this book " +
                "guides readers on how to build good habits and break bad ones to achieve remarkable results.");

        NonFictionBook nonFictionBook6 = new NonFictionBook();
        nonFictionBook6.setInterestingnessFactor(NonFictionBook.InterestingnessFactor.LIFE_CHANGING);
        nonFictionBook6.setAuthor("Sophia Garcia");
        nonFictionBook6.setTitle("Becoming");
        nonFictionBook6.setSummary("In this deeply personal memoir, former First Lady Michelle Obama " +
                "reflects on her life's journey and the experiences that have shaped her into the woman she is today.");

        NonFictionBook nonFictionBook7 = new NonFictionBook();
        nonFictionBook7.setInterestingnessFactor(NonFictionBook.InterestingnessFactor.MILDLY_INTERESTING);
        nonFictionBook7.setAuthor("Benjamin Taylor");
        nonFictionBook7.setTitle("The Art of War");
        nonFictionBook7.setSummary("An ancient Chinese military treatise, this timeless classic " +
                "offers profound insights into strategy, tactics, and the nature of conflict.");

        // Add all books to the library
        library.add(fictionBook1);
        library.add(fictionBook2);
        library.add(fictionBook3);
        library.add(fictionBook4);
        library.add(fictionBook5);
        library.add(fictionBook6);
        library.add(fictionBook7);
        library.add(fictionBook8);
        library.add(fictionBook9);
        library.add(fictionBook10);
        library.add(nonFictionBook1);
        library.add(nonFictionBook2);
        library.add(nonFictionBook3);
        library.add(nonFictionBook4);
        library.add(nonFictionBook5);
        library.add(nonFictionBook6);
        library.add(nonFictionBook7);

        return library;
    }
}
