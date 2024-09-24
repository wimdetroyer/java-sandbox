package be.wimdetroyer.javasandbox.jcip.interruption;

import lombok.SneakyThrows;

public class InterruptionExampleThreads {


    @SneakyThrows
    public static void main(String[] args) {


        // Polls for the interrupted flag in the _current thread_ (instance method) without CLEARING the interrupted status
        // this is preferable here because after the isInterrupted flag is true, the thread will naturally exit after having ran execution
        var randomGibberishThread = new Thread(() -> {
            while (!Thread.currentThread().isInterrupted()) {
                    System.out.println("Spitting out random gibberish " + Math.random());
            }
        });

        // static method which checks the _interrupted_ flag and then proceeds to reset it.
        // the first option is preferable.
        var randomGibberishThread2 = new Thread(() -> {
            while (!Thread.interrupted()) {
                    System.out.println("Spitting out random gibberish " + Math.random());

            }
        });

        // spit out gibberish for about one second

        randomGibberishThread.start();
        Thread.sleep(1000);
        randomGibberishThread.interrupt();
    }
}
