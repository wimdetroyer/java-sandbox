package be.wimdetroyer.javasandbox.jcip.numberrange.good;


import net.jcip.annotations.Immutable;
import net.jcip.annotations.ThreadSafe;

import java.util.concurrent.atomic.AtomicReference;

@ThreadSafe
public class BestNumberRange {


    private final AtomicReference<NumPair> numPairAtomicReference = new AtomicReference<>(new NumPair(0,10));


    public void setLower(int lower) {
        while (true) {
            var oldNumPair = numPairAtomicReference.get();
            if(lower > oldNumPair.upper()) {
                throw new IllegalArgumentException("Lower bound cannot be greater than upper bound");
            }
            var newNumPair = new NumPair(lower, oldNumPair.upper());
            if(numPairAtomicReference.compareAndSet(oldNumPair, newNumPair)) {
                return;
            }
        }

    }

    public void setUpper(int upper) {
        // Keep trying until CAS works for this thread
        while(true) {
            var oldNumPair = numPairAtomicReference.get(); // get the curr ref
            if(upper < oldNumPair.lower()) {
                throw new IllegalArgumentException("Upper bound cannot be less than lower bound");
            }
            var newNumPair = new NumPair(oldNumPair.lower(), upper);
            // value in the atomic reference from LOC 33 until 39 could have changed by now.
            if(numPairAtomicReference.compareAndSet(oldNumPair, newNumPair)) {
                return;
            }
        }
    }

}

@Immutable
record NumPair(int lower, int upper) {

    public NumPair {
        if(lower > upper) {
            throw new IllegalArgumentException("Lower bound must be less than upper bound");
        }
    }
}
