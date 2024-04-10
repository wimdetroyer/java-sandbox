package be.wimdetroyer.javasandbox.visitor.oop.books.types;

import static be.wimdetroyer.javasandbox.visitor.oop.books.types.BookFlavour.BookFlavourDiscriminator.ORDINARY_BOOK;

public class OrdinaryBookFlavour extends BookFlavour {

    public OrdinaryBookFlavour() {
        super(ORDINARY_BOOK);
    }
}
