package be.wimdetroyer.javasandbox.jcip.interruption;

import lombok.SneakyThrows;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class InterruptionExampleScheduler {


    @SneakyThrows
    public static void main(String[] args) {
        var randomGibberishTask = new Runnable() {
            @Override
            public void run() {
                System.out.println("Spitting out random gibberish " + Math.random());
            }
        };

        try (var pool = Executors.newSingleThreadScheduledExecutor()) {
            ScheduledFuture<?> gibbberishEverySec = pool.scheduleAtFixedRate(randomGibberishTask, 0, 1, TimeUnit.SECONDS);
            pool.schedule(() -> gibbberishEverySec.cancel(false), 10, TimeUnit.SECONDS);
            gibbberishEverySec.get();
        }

    }
}
