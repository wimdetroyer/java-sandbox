package be.wimdetroyer.javasandbox.visitor.oop.books.types;

import lombok.Getter;

import java.util.Objects;

@Getter
public class BannedBookFlavour extends BookFlavour {

    private final BanReasonCategory banReasonCategory;
    private final String banExplanation;

    public BannedBookFlavour(BanReasonCategory banReasonCategory, String banExplanation) {
        Objects.requireNonNull(banReasonCategory);
        Objects.requireNonNull(banExplanation);
        if(banReasonCategory == BanReasonCategory.TOO_OBSCENE) {
            if(banExplanation.length() < 100) {
                throw new IllegalArgumentException("That explanation just won't do. ");
            }
        }
        super(BookFlavourDiscriminator.BANNED_BOOK);
        this.banReasonCategory = banReasonCategory;
        this.banExplanation = banExplanation;
    }


    public enum BanReasonCategory {
        DISINFORMATION,
        TOO_OBSCENE;
    }


}
