package org.zyq.swing_utils.console;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by Yuquan Zou on 2016/1/2.
 */
public class LimiteList<E> extends ArrayList<E> {

    private int initialCapacity;

    public LimiteList(int initialCapacity) {
        super(initialCapacity);
        this.initialCapacity = initialCapacity;
    }

    public int getInitialCapacity() {
        return initialCapacity;
    }

    public boolean add(E e) {
        boolean result = false;
        synchronized (this) {
            if (this.size() + 1 > initialCapacity) {
                this.remove(0);
            }
            super.add(e);
        }
        return result;
    }

    public void add(int index, E element) {
    }

    public boolean addAll(Collection<? extends E> c) {
        return false;
    }

    public boolean addAll(int index, Collection<? extends E> c) {
        return false;
    }
}
