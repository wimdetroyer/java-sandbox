package be.wimdetroyer.javasandbox.jcip.numberrange.bad;


import net.jcip.annotations.NotThreadSafe;

@NotThreadSafe
public class BadNumberRangeVolatile {

    // volatile ensures memory visibility: latest changes will be available to all threads...
    private volatile int lower;
    private volatile int upper;


    public void setLower(int lower) {
        // but it does not assure atomicity... thread interleaving could cause the invariants to break
        if (lower > upper) {
            throw new IllegalArgumentException("lower must be less than upper");
        }
        this.lower = lower;
    }

    public void setUpper(int upper) {
        if (upper < lower) {
            throw new IllegalArgumentException("upper must be less than lower");
        }
        this.upper = upper;
    }
}
