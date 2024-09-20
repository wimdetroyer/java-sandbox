package be.wimdetroyer.javasandbox.jcip.semaphores.connectionpool;

import lombok.SneakyThrows;

/**
 * Connection pool example
 */
public class SemaphoreConnectionPoolExample {

    public static void main(String[] args) {
        simulateRequests(new SomeSystem());
    }

    @SneakyThrows
    private static void simulateRequests(SomeSystem someSystem) {
        // Simulate an incoming request once every 10 ms, thread per request.
        for (int i = 0; i < 1000; i++) {
            simulateIncomingRequest(someSystem);
        }
    }

    private static void simulateIncomingRequest(SomeSystem someSystem) throws InterruptedException {
        var thread = new Thread(someSystem::communicate);
        thread.start();
        Thread.sleep(10);
    }


}
