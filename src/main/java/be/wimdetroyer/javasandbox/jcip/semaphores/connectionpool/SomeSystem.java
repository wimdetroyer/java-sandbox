package be.wimdetroyer.javasandbox.jcip.semaphores.connectionpool;

public class SomeSystem {

    private final FixedConnectionPool fixedConnectionPool = new FixedConnectionPool();



    public void communicate() {
        var connection = fixedConnectionPool.acquireConnection();
        connection.openConnection();
        connection.doSomething();
        connection.doSomething();
        connection.release();
    }
}
