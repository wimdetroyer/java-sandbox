package be.wimdetroyer.javasandbox.visitor.oop.books;

// Decorate a fiction or nonfiction
public abstract class BestSellingBook extends Book {

    private int copiesSold;

    public BestSellingBook(int copiesSold) {
        if(copiesSold < 1000) {
            throw new IllegalArgumentException("Best selling books must have at least 1000 copies sold.");
        }
        this.copiesSold = copiesSold;
    }

    public int getCopiesSold() {
        return copiesSold;
    }

    public void setCopiesSold(int copiesSold) {
        this.copiesSold = copiesSold;
    }
}
