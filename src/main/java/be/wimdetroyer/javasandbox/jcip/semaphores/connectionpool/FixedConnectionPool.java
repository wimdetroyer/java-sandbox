package be.wimdetroyer.javasandbox.jcip.semaphores.connectionpool;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Semaphore;

public class FixedConnectionPool {


    public static final int CONNECTION_POOL_SIZE = 100;
    private final Semaphore semaphore = new Semaphore(CONNECTION_POOL_SIZE);
    private final Set<Connection> connectionPool = Collections.synchronizedSet(new HashSet<>());



    /**
     * Acquires a connection from the connection pool. Blocks until a connection is available.
     * @return
     */
    public Connection acquireConnection() {
        try {
            semaphore.acquire();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return null;
    }


}
