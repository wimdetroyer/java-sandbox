package be.wimdetroyer.javasandbox.jcip.testing;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

class BoundedBufferPerformanceTest {


    @Test
    void testPerf_OK() throws InterruptedException {
        int tpt = 100000; // trials per thread
        for (int cap = 10; cap <= 1000; cap *= 10) {
            System.out.println("Capacity: " + cap);
            for (int pairs = 1; pairs <= 128; pairs *= 2) {
                BoundedBufferPerformanceTestHarness t =
                        new BoundedBufferPerformanceTestHarness(new BoundedBuffer<>(cap), pairs, tpt);
                System.out.print("Pairs: " + pairs + "\t");
                t.run();
                System.out.print("\t");
                Thread.sleep(1000);
                t.run();
                System.out.println();
                Thread.sleep(1000);
            }

        }
    }



    class BoundedBufferPerformanceTestHarness {

        private final ExecutorService exec = Executors.newCachedThreadPool();
        private final IBoundedBuffer<Integer> buffer;
        private final int numConsumersAndProducers, trialsToRun;
        private final CyclicBarrier barrier;
        private final AtomicInteger sumOfPuts, sumOfTakes;
        private final TimedBarrierAction timer;

        BoundedBufferPerformanceTestHarness(IBoundedBuffer<Integer> buffer, int numConsumersAndProducers, int trialsToRun) {
            this.buffer = buffer;
            this.trialsToRun = trialsToRun;
            this.numConsumersAndProducers = numConsumersAndProducers;
            // 2x because we Produce and then Consume
            // sumOfPuts num of consumers/producers (for instance 10 consumers and producers
            timer = new TimedBarrierAction();
            this.barrier = new CyclicBarrier(2 * numConsumersAndProducers + 1, timer);
            sumOfTakes = new AtomicInteger(0);
            sumOfPuts = new AtomicInteger(0);
        }

        public Pair run() {
            for (int i = 0; i < numConsumersAndProducers; i++) {
                exec.execute(new Producer());
                exec.execute(new Consumer());
            }
            try {
                barrier.await(); // 1st barrier will trip
                // ... blocking at 2nd barrier
                barrier.await(); // 2nd barrier will trip
                long nsPerItem = timer.getDuration() / (numConsumersAndProducers * (long)trialsToRun);
                System.out.print("Throughput: " + nsPerItem + " ns/item");
                return new Pair(sumOfPuts.get(), sumOfTakes.get());
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

        public void shutDown() {
                exec.shutdown();
        }

        private class Producer implements Runnable {

            @Override
            public void run() {
                try {
                    int seed = this.hashCode() ^ (int) System.nanoTime();
                    int sumForThread = 0;
                    barrier.await(); // Barrier that waits until ALL threads have their initial seed value set
                    for (int i = 0; i < trialsToRun; i++) {
                        buffer.put(seed);
                        sumForThread += seed;
                        seed = xorShift(seed);
                    }
                    //TODO: why not addandget?
                    sumOfPuts.getAndAdd(sumForThread);
                    barrier.await(); // wait to fizzle out the thread until all others are done
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        }

        private class Consumer implements Runnable {

            @Override
            public void run() {
                try {
                    int sumForThread = 0;
                    barrier.await(); // Wait until all the consumer threads are ready...

                    // Do the execution...
                    for (int i = 0; i < trialsToRun; i++) {
                        sumForThread += buffer.take();
                    }
                    sumOfTakes.getAndAdd(sumForThread);
                    // Wait until all the other consumer threads are finished...
                    barrier.await();
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        }


    }

    // part of the random generator
    //TODO: explain why
    /*
    To ensure that your test actually tests what you think it does, it is important
that the checksums themselves not be guessable by the compiler. It would be
a bad idea to use consecutive integers as your test data because then the result
would always be the same, and a smart compiler could conceivably just precompute it.
To avoid this problem, test data should be generated randomly, but many otherwise effective tests are compromised by a poor choice of random number generator (RNG). Random number generation can create couplings between classes
and timing artifacts because most random number generator classes are threadsafe and therefore introduce additional synchronization.4 Giving each thread its
own RNG allows a non-thread-safe RNG to be used.
Rather than using a general-purpose RNG, it is better to use simple pseudorandom functions. You don’t need high-quality randomness; all you need is
enough randomness to ensure the numbers change from run to run. The xorShift function in Listing 12.4 (Marsaglia, 2003) is among the cheapest mediumquality random number functions. Starting it off with values based on hashCode
and nanoTime makes the sums both unguessable and almost always different for
each run.
     */
    static int xorShift(int y) {
        y ^= (y << 6);
        y ^= (y >>> 21);
        y ^= (y << 7);
        return y;
    }

    public record Pair(int sumOfPuts, int sumOfTakes){

    }
}