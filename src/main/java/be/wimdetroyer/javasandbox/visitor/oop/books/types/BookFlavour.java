package be.wimdetroyer.javasandbox.visitor.oop.books.types;

import lombok.Getter;

@Getter
public abstract class BookFlavour {

    private final BookFlavourDiscriminator bookFlavourDiscriminator;

    protected BookFlavour(BookFlavourDiscriminator bookFlavourDiscriminator) {
        this.bookFlavourDiscriminator = bookFlavourDiscriminator;
    }

    public enum BookFlavourDiscriminator {

        BANNED_BOOK,
        BEST_SELLING_BOOK,
        ORDINARY_BOOK;

    }
}
