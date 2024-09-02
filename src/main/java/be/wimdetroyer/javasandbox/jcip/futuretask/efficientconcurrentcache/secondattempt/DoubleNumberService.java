package be.wimdetroyer.javasandbox.jcip.futuretask.efficientconcurrentcache.secondattempt;

import lombok.SneakyThrows;

public class DoubleNumberService {

    @SneakyThrows
    public int doubleNumber(int x) {
        System.out.println("Calculating number " +  x + " for the first time");
        Thread.sleep(250);
        return x * x;
    }
}
