package be.wimdetroyer.javasandbox.jcip.futuretask.efficientconcurrentcache.firstattempt;

import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;

public class ConcurrentlyMemoisableFunction<F extends Function<I,O> ,I, O> {

    private final ConcurrentHashMap<I, O> resultCache = new ConcurrentHashMap<>();
    private final Function<I,O> function;

    public ConcurrentlyMemoisableFunction(Function<I, O> function) {
        this.function = function;
    }

    // use of concurrent hashmap with atomic computeifabsent method to allow multiple threads to access this method
    // this in contrast to using a sychronized lock with a hashmap which would stall throughput to this calc method to 1 thread
    // TODO: Defect here though is that with unlucky timing, thread A could be calculating the output O for input I, and thread B
    // will not yet see the value in the map, so a second, unnecessary calculation would be started.
    public O calculate(I input) {
        return resultCache.computeIfAbsent(input, function);
    }



}
