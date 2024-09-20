package be.wimdetroyer.javasandbox.jcip.testing;

public interface IBoundedBuffer<E> {

    void put(E elem) throws InterruptedException;

    E take() throws InterruptedException;
}
