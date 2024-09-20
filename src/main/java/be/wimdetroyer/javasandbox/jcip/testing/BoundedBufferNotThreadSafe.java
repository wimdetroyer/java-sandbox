package be.wimdetroyer.javasandbox.jcip.testing;


import java.util.concurrent.Semaphore;

// Not thread safe variant because lack of synchronization when read modify write the put and takeindex.
public class BoundedBufferNotThreadSafe<E> implements IBoundedBuffer<E> {


    private final E[] internalArray;
    private final Semaphore availableItemsToPut;
    private final Semaphore availableItemsToTake;
    private int putIndex = 0;
    private int takeIndex = 0;
    public BoundedBufferNotThreadSafe(int capacity) {
        this.internalArray = (E[]) new Object[capacity];
        availableItemsToTake = new Semaphore(0);
        availableItemsToPut = new Semaphore(capacity);
    }


    public void put(E elem) throws InterruptedException {
        availableItemsToPut.acquire();
        internalArray[putIndex] = elem;
        putIndex++;
        if(putIndex == internalArray.length) {
            putIndex = 0;
        }
        availableItemsToTake.release();
    }

    public E take() throws InterruptedException {
        availableItemsToTake.acquire();
        var takenElement = internalArray[takeIndex];
        takeIndex++;
        if(takeIndex == internalArray.length) {
            takeIndex = 0;
        }
        availableItemsToPut.release();
        return takenElement;
    }

}
