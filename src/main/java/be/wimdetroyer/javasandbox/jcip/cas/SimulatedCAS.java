package be.wimdetroyer.javasandbox.jcip.cas;


import net.jcip.annotations.NotThreadSafe;

/**
 * Simulate a Compare-And-Swap operation which would be atomic if we were operating on the hardware level.
 * This is java code so it would need synchronization (via the synchronized keyword) to function correctly here (or an atomic integer)
 */
@NotThreadSafe
public class SimulatedCAS {

    private int value;



    // would be atomic if it was at the hardware level.
    public int compareAndSwap(int expectedValue, int newValue) {
        int oldValue = value;

        if(oldValue == expectedValue) {
            value = newValue;
        }

        return oldValue;
    }

    // false if the old value was the expected value ie: the operation did not succeed
    // true otherwise.
    public boolean compareAndSet(int expectedValue, int newValue) {
        return expectedValue == compareAndSwap(expectedValue, newValue);
    }
}
