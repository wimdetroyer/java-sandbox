package be.wimdetroyer.javasandbox.jcip.futuretask;

import lombok.SneakyThrows;

import java.util.concurrent.*;

public class FutureTaskExample {

    private final FutureTask<String> longRunningTask = new FutureTask<>(LongRunningTaskService::getResult);
    private final Thread runTaskThread = new Thread(longRunningTask);
    private final ExecutorService executorService = Executors.newSingleThreadExecutor();

    // Note that a futuretask not wrapped inside an executorservice or a Thread would defeat the purpose, since running
    // the .run() method of a longRunningTask directly would delegate it to the calling/main thread instead of a 2nd thread.
    public void startExecution() {
        runTaskThread.start();
    }

    public void startExecutionWithExecutor() {
        executorService.execute(longRunningTask);
    }

    public String queryResultAvailable() {
        try {
            var currentTimeMillis = System.currentTimeMillis();
            System.out.println("trying to get result");
            var result = longRunningTask.get();
            System.out.println("got result, it took " + (System.currentTimeMillis() - currentTimeMillis) + "ms");
            return result;
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        } catch (CancellationException e) {
            System.out.println("cancelled execution");
            throw new RuntimeException(e);
        }
    }
    @SneakyThrows
    public static void main(String[] args) {
        shave5secsOffComputationExample();
        cancelledWhileRunning();
    }

    private static void shave5secsOffComputationExample() throws InterruptedException {
        var futureTaskExample = new FutureTaskExample();
        // Application starts, run the long running task (10 sec long) in the background:
        futureTaskExample.startExecutionWithExecutor();
        // Application has been running for 5 seconds now:
        Thread.sleep(5000);
        // user wants to query the result now, we've shaved off 5 secs off the computation time:
        futureTaskExample.queryResultAvailable();
    }

    private static void cancelledWhileRunning() throws InterruptedException {
        var futureTaskExample = new FutureTaskExample();
        // Application starts, run the long running task (10 sec long) in the background:
        futureTaskExample.startExecution();
        // Application has been running for 5 seconds now:
        Thread.sleep(5000);
        futureTaskExample.longRunningTask.cancel(false);
        futureTaskExample.queryResultAvailable();
    }
}


class LongRunningTaskService {


    @SneakyThrows
    public static String getResult() {
        System.out.println("Starting computations");
        Thread.sleep(10000);
        System.out.println("Done!");
        return "Result";

    }
}