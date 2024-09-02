package be.wimdetroyer.javasandbox.jcip.futuretask.efficientconcurrentcache.secondattempt;

import java.util.concurrent.*;
import java.util.function.Function;

public class ConcurrentlyMemoisableTask<I,O> {

    private final ConcurrentHashMap<I, FutureTask<O>> resultCache = new ConcurrentHashMap<>();

    // note that instead of passing inputFn, we couuld do like JCIP and provide this as an interface method
    public O calculate(Function<I,O> inputFn, I arg) {
        // Note that computeifabsent will NOT publish the value to the map incase the mapping function throws a runtime
        // exception, which makes it so cache pollution is not a thing
        try {
            return resultCache.computeIfAbsent(arg, i -> {
                var futureTask = new FutureTask<>(() -> inputFn.apply(arg));
                futureTask.run();
                return futureTask;
            }).get();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }
    }
}
