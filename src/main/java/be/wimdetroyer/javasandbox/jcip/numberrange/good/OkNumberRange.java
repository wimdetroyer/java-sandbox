package be.wimdetroyer.javasandbox.jcip.numberrange.good;

public class OkNumberRange {


    private int lower;
    private int upper;


    // note that synchronized also has a happens-before guarantee, so no need for volatile anymore
    public synchronized void setLower(int lower) {
        // but it does not assure atomicity... thread interleaving could cause the invariants to break
        if (lower > upper) {
            throw new IllegalArgumentException("lower must be less than upper");
        }
        this.lower = lower;
    }

    public synchronized void setUpper(int upper) {
        if (upper < lower) {
            throw new IllegalArgumentException("upper must be less than lower");
        }
        this.upper = upper;
    }
}
