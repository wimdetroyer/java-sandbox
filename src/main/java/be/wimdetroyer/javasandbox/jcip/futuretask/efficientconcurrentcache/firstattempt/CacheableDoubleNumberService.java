package be.wimdetroyer.javasandbox.jcip.futuretask.efficientconcurrentcache.firstattempt;

import java.util.function.Function;

public class CacheableDoubleNumberService {

    private final DoubleNumberService doubleNumberService = new DoubleNumberService();
    private final ConcurrentlyMemoisableFunction<Function<Integer, Integer>, Integer, Integer> cacheableCalculation = new ConcurrentlyMemoisableFunction<>(doubleNumberService::doubleNumber);


    public int doubleEfficiently(int num) {
        return cacheableCalculation.calculate(num);
    }
}
