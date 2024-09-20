package be.wimdetroyer.javasandbox.jcip.testing;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BoundedBufferSequentialAndBlockingTest {

    public static final int MAX_WAIT_TIME_TAKE_BEFORE_TIMEOUT = 1000;
    public static final int MAX_WAIT_TIME_PUT_BEFORE_TIMEOUT = 1000;
    private BoundedBuffer<String> stringBoundedBuffer = new BoundedBuffer<>(10);

    @Nested
    class SequentialTests {
        @Test
        void initiallyEmpty() throws InterruptedException {
            assertTrue(stringBoundedBuffer.isEmpty());
            assertFalse(stringBoundedBuffer.isFull());
        }

        @Test
        void fullAfterPuts() throws InterruptedException {
            for (int i = 0; i < 10; i++)
                stringBoundedBuffer.put(String.valueOf(i));
            assertTrue(stringBoundedBuffer.isFull());
            assertFalse(stringBoundedBuffer.isEmpty());
        }

    }

    @Nested
    class BlockingTests {
        @Test
        void blocksAfterReachingCapacity() throws InterruptedException {
            Thread putThread = new Thread(() -> {
                for (int i = 0; i < 10; i++) {
                    try {
                        stringBoundedBuffer.put(String.valueOf(i));
                    } catch (InterruptedException e) {
                        // Do nothing
                    }
                }
                // should block indefinetely
                try {
                    System.out.println("Trying to put an element in the bounded buffer when it is full...");
                    stringBoundedBuffer.put("A");
                    System.out.println("I should have been blocked!");
                    fail();
                } catch (InterruptedException e) {
                    // Success, thread is interrupted by us after achieving timeout
                    // upon reaching this do nothing to restore the thread alive
                }

            });

            putThread.start();
            Thread.sleep(MAX_WAIT_TIME_PUT_BEFORE_TIMEOUT);
            putThread.interrupt();
            putThread.join(MAX_WAIT_TIME_PUT_BEFORE_TIMEOUT);
            Assertions.assertThat(putThread.isAlive()).isFalse();
        }


        @Test
        void blocksWhenNothingToTake() throws InterruptedException {
            Thread takeThread = new Thread(() -> {
                try {
                    System.out.println("Trying to take an element of the bounded buffer when it is empty...");
                    stringBoundedBuffer.take();
                    System.out.println("I should have been blocked!");
                    fail(); // It should block on taking...
                } catch (InterruptedException e) {
                    // Success, thread is interrupted by us after achieving timeout
                    // upon reaching this do nothing to restore the thread alive
                    System.out.println("I was interrupted by the test! (hopefully)");
                }
            });

            takeThread.start();
            Thread.sleep(MAX_WAIT_TIME_TAKE_BEFORE_TIMEOUT);
            takeThread.interrupt();
            takeThread.join(MAX_WAIT_TIME_TAKE_BEFORE_TIMEOUT);
            Assertions.assertThat(takeThread.isAlive()).isFalse();
        }
    }

}