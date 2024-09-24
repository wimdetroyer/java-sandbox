package be.wimdetroyer.javasandbox.jcip.latch;

import lombok.SneakyThrows;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

public class CountDownLatchExample {


    public static final int THREAD_COUNT = 1000;

    public static void main(String[] args) {
        runWith100();
    }

    @SneakyThrows
    public static void runWith100() {
        final CountDownLatch threadsAllDoneExecutingLatch = new CountDownLatch(THREAD_COUNT);
        final CountDownLatch unblockExecutionLatch = new CountDownLatch(1);
        final AtomicInteger counter = new AtomicInteger(0);
        for (int i = 0; i < THREAD_COUNT; i++) {
            var thread = new Thread(new Runnable() {
                @SneakyThrows
                @Override
                public void run() {
                    System.out.println("I am thread " + Thread.currentThread().getName() + "and i am waiting to go");
                    unblockExecutionLatch.await();
                    System.out.println("Executing some garbage in the context of thread " + Thread.currentThread().getName());
                    threadsAllDoneExecutingLatch.countDown();
                    counter.incrementAndGet();
                }
            });
                    thread.start();
        }

        System.out.println("Set up the execution with a 100 threads");
        unblockExecutionLatch.countDown();
        System.out.println("Waiting for threads to finish");
        threadsAllDoneExecutingLatch.await();
        System.out.println("All threads finished" + counter.get());
    }

}
