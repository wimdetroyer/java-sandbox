package be.wimdetroyer.javasandbox.jcip.semaphores.connectionpool;

public enum ConnectionState {

    NEW,
    IDLE,
    ACTIVE,
    CLOSED;
}
