package be.wimdetroyer.javasandbox.jcip;

import java.util.*;

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

    // Delegate to other methods
    @Override
    public int size() {
        return underlyingList.size();
    }

}

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