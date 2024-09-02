package be.wimdetroyer.javasandbox.jcip;

import java.util.*;


// NOT THREAD SAFE!!
class ListHelper<E> {
    public final List<E> list =
            Collections.synchronizedList(new ArrayList<E>());

    // NOT THREAD SAFE!!
    // 1. does not use the same lock as the underlying list
    // 2. when used in combination with  calls on the underyling list (note it is public)
    // ie: list.add() it will cause thread safety issues
    public synchronized boolean putIfAbsent(E x) {
        boolean absent = !list.contains(x);
        if (absent)
            list.add(x);
        return absent;
    }

    public boolean putIfAbsentThreadSafe(E x) {
        synchronized (list) {
            boolean absent = !list.contains(x);
            if (absent)
                list.add(x);
            return absent;
        }
    }
}

public class ImprovedList<T> implements List<T> {

    private final List<T> underlyingList;

    public ImprovedList(List<T> underlyingList) {
        this.underlyingList = underlyingList;
    }

    // No need to use the intrinsic lock of the underlyingList, because all other methods of the underlyingList
    // Are overridden here: it means all operations pass thru here anyway so there is no possible thread safety conflict issue at play.
    // In contrast to ListHelper
    public synchronized void putIfAbsent(T elem) {
        if(!underlyingList.contains(elem)) {
            underlyingList.add(elem);
        }
    }

    // Delegate to other methods, synchronizing if necessary
    @Override
    public synchronized int size() {
        return underlyingList.size();
    }

    @Override
    public synchronized boolean isEmpty() {
        return false;
    }

    @Override
    public synchronized boolean contains(Object o) {
        return false;
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {
        return null;
    }

    @Override
    public boolean add(T t) {
        return false;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        return false;
    }

    @Override
    public boolean addAll(int index, Collection<? extends T> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public T get(int index) {
        return null;
    }

    @Override
    public T set(int index, T element) {
        return null;
    }

    @Override
    public void add(int index, T element) {

    }

    @Override
    public T remove(int index) {
        return null;
    }

    @Override
    public int indexOf(Object o) {
        return 0;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public ListIterator<T> listIterator() {
        return null;
    }

    @Override
    public ListIterator<T> listIterator(int index) {
        return null;
    }

    @Override
    public List<T> subList(int fromIndex, int toIndex) {
        return List.of();
    }

}

