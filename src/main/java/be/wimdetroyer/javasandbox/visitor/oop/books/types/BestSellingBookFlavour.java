package be.wimdetroyer.javasandbox.visitor.oop.books.types;

import lombok.Getter;

@Getter
public class BestSellingBookFlavour extends BookFlavour {

    private final int copiesSold;

    public BestSellingBookFlavour(int copiesSold) {
        if(copiesSold < 1000) {
            throw new IllegalArgumentException("Best selling books must have at least 1000 copies sold.");
        }
        super(BookFlavourDiscriminator.BEST_SELLING_BOOK);
        this.copiesSold = copiesSold;
    }

}
