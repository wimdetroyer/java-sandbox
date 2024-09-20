package be.wimdetroyer.javasandbox.jcip.semaphores.connectionpool;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Semaphore;

public class BoundedHashSet<E> extends HashSet<E> {

    private final Set<Connection> internalHashSet = Collections.synchronizedSet(new HashSet<>());
    private final Semaphore boundSemaphore;

    public BoundedHashSet(int bound) {
        this.boundSemaphore = new Semaphore(bound);
    }

    public Connection add() {
        return null;
    }

    public void remove() {

    }
}
