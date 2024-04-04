package be.wimdetroyer.javasandbox.visitor.oop.books;

// Decorate a fiction or nonfiction
public abstract class BannedBook extends Book {

    private BanReason banReason;


    public enum BanReason {
        DISINFORMATION,
        TOO_OBSCENE;
    }


    public BanReason getBanReason() {
        return banReason;
    }

    public void setBanReason(BanReason banReason) {
        this.banReason = banReason;
    }
}
