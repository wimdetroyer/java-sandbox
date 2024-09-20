package be.wimdetroyer.javasandbox.jcip.testing;


import net.jcip.annotations.GuardedBy;

import java.util.concurrent.Semaphore;

/**
 * BoundedBuffer implements a fixed-length array-based queue with blocking
 * put and take methods controlled by a pair of counting semaphores. The availableItems semaphore represents the number of elements that can be removed from
 * the buffer, and is initially zero (since the buffer is initially empty). Similarly,
 * availableSpaces represents how many items can be inserted into the buffer, and
 * is initialized to the size of the buffer.
 *
 * @param <E>
 */
public class BoundedBuffer<E> implements IBoundedBuffer<E> {


    private final Semaphore availableItemsToPut;
    private final Semaphore availableItemsToTake;
    @GuardedBy("this")
    private final E[] internalArray;
    @GuardedBy("this")
    private int putIndex = 0;
    @GuardedBy("this")
    private int takeIndex = 0;


    public BoundedBuffer(int capacity) {
        this.internalArray = (E[]) new Object[capacity];
        availableItemsToTake = new Semaphore(0);
        availableItemsToPut = new Semaphore(capacity);
    }


    public boolean isEmpty() {
        return availableItemsToTake.availablePermits() == 0;
    }

    public boolean isFull() {
        return availableItemsToPut.availablePermits() == 0;
    }


    @Override
    public void put(E elem) throws InterruptedException {
        availableItemsToPut.acquire();
        putSynchronized(elem);
        availableItemsToTake.release();
    }

    @Override
    public E take() throws InterruptedException {
        availableItemsToTake.acquire();
        var takenElement = takeSynchronized();
        availableItemsToPut.release();
        return takenElement;
    }

    private synchronized void putSynchronized(E elem) {
        internalArray[putIndex] = elem;
        putIndex++;
        if (putIndex == internalArray.length) {
            putIndex = 0;
        }
    }

    private synchronized E takeSynchronized() {
        var takenElement = internalArray[takeIndex];
        internalArray[takeIndex] = null;
        takeIndex++;
        if (takeIndex == internalArray.length) {
            takeIndex = 0;
        }
        return takenElement;
    }
}
