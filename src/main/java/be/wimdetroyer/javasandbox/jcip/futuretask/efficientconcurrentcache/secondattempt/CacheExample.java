package be.wimdetroyer.javasandbox.jcip.futuretask.efficientconcurrentcache.secondattempt;

import lombok.SneakyThrows;

public class CacheExample {

    @SneakyThrows
    public static void main(String[] args) {
        var doubleNumberService = new CacheableDoubleNumberService();


        // simulating  a thread/per/request model @ 100 reqs per 10/ms
        for (int i = 0; i < 10; i++) {
            Thread.sleep(10);
            System.out.println("New batch of 100 req per 10/ms");
            for (int j = 0; j < 100; j++) {
                System.out.println("simulating a thread/per/request model");
                new Thread(() -> {
                    int randomNumber = (int) (Math.random() * 1001) + 1;
                    doubleNumberService.doubleEfficiently(randomNumber);
                }).start();
            }
        }
    }
}
