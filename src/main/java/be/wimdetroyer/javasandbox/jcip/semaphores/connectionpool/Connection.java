package be.wimdetroyer.javasandbox.jcip.semaphores.connectionpool;

import lombok.SneakyThrows;

/**
 * A connection. A connection is always assigned to one thread.
 * It cannot be re-used
 */
public final class Connection {

    private ConnectionState connectionState;

    @SneakyThrows
    public Connection() {
        this.connectionState = ConnectionState.NEW;
        System.out.println("creating the connection object.. . this is expensive");
        Thread.sleep(500);
        this.connectionState = ConnectionState.IDLE;
    }

    @SneakyThrows
    public void openConnection() {
        if(connectionState == ConnectionState.ACTIVE) {
            return;
        }
        System.out.println("Opening connection... This can take a while...");
        Thread.sleep(500);
        connectionState = ConnectionState.ACTIVE;
    }


    @SneakyThrows
    public void doSomething() {
        if(connectionState != ConnectionState.ACTIVE) {
            throw new IllegalStateException("Connection must be open before we do something");
        }
        System.out.println("Started doing something");
        Thread.sleep(500);
        System.out.println("Finished doing something");
    }


    @SneakyThrows
    public void destroy() {
        System.out.println("Destroying connection... This can take a while...");
        Thread.sleep(500);
        //TODO: ...
    }

    public void close() {
        connectionState = ConnectionState.CLOSED;
    }

    public void release() {
        //TODO: return it to the connection pool
        connectionState = ConnectionState.IDLE;

    }
}
