package be.wimdetroyer.javasandbox.jcip.numberrange.bad;


import net.jcip.annotations.NotThreadSafe;

import java.util.concurrent.atomic.AtomicInteger;

@NotThreadSafe
public class BadNumberRangeAtomicInt {

    private final AtomicInteger lower = new AtomicInteger(0);
    private final AtomicInteger upper = new AtomicInteger(10);


    public void setLower(int lower) {
        // Not thread safe: the value in upper could have been changed...
        if (lower > upper.get()) {
            throw new IllegalArgumentException("lower must be less than upper");
        }
        // even if the following operation is atomic!
        this.lower.set(lower);
    }

    public void setUpper(int upper) {
        if (upper < lower.get()) {
            throw new IllegalArgumentException("upper must be less than lower");
        }
        this.upper.set(upper);
    }
}
