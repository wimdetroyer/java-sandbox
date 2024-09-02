package be.wimdetroyer.javasandbox.jcip.futuretask.efficientconcurrentcache.secondattempt;

public class CacheableDoubleNumberService {

    private final DoubleNumberService doubleNumberService = new DoubleNumberService();
    private final ConcurrentlyMemoisableTask<Integer, Integer> cacheableCalculation = new ConcurrentlyMemoisableTask<>();


    public int doubleEfficiently(int num) {
        return cacheableCalculation.calculate(doubleNumberService::doubleNumber, num);
    }
}
