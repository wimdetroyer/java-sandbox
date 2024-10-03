package be.wimdetroyer.javasandbox.jcip.numberrange.good;


import net.jcip.annotations.Immutable;
import net.jcip.annotations.ThreadSafe;

import java.util.concurrent.atomic.AtomicReference;

@ThreadSafe
public class BestNumberRange {


    private final AtomicReference<NumPair> numPairAtomicReference = new AtomicReference<>(new NumPair(0,10));


    public void setLower(int lower) {
        // keep trying until we win the CAS race. Note that this approach is prone to livelock; another thread could always be just in time
        // to not let us be able to setLower, causing us to keep trying again ad infinitum.
        while (true) {
            // 1. get the current numpair from the atomic reference. a thread local (stack confined) _snapshot_ of the current state!
            var oldNumPair = numPairAtomicReference.get();
            //2.  check if lower is smaller than upper, so the thread does not break the invariant
            // fail fast in this caseinstead of trying again, because otherwise we would risk livelock
            if(lower > oldNumPair.upper()) {
                throw new IllegalArgumentException("Lower bound cannot be greater than upper bound");
            }
            // 3. construct the new numpair using the old snapshot
            var newNumPair = new NumPair(lower, oldNumPair.upper());
            //4. finally do the CAS operation to see if by the time we constructed oour new pair, the snapshot we took from the state still holds up to the current ref
            // if it doesn't, we retry the operation
            if(numPairAtomicReference.compareAndSet(oldNumPair, newNumPair)) {
                return;
            }
        }

    }

    public void setUpper(int upper) {
        while(true) {
            var oldNumPair = numPairAtomicReference.get(); // get the curr ref
            if(upper < oldNumPair.lower()) {
                throw new IllegalArgumentException("Upper bound cannot be less than lower bound");
            }
            var newNumPair = new NumPair(oldNumPair.lower(), upper);
            if(numPairAtomicReference.compareAndSet(oldNumPair, newNumPair)) {
                return;
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

}

