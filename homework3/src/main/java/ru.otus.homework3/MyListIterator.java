package ru.otus.homework3;

import java.util.ConcurrentModificationException;
import java.util.ListIterator;
import java.util.NoSuchElementException;

/**
 * Created by adementev on 26.02.2018.
 */
public class MyListIterator<E> extends MyIterator<E> implements ListIterator<E> {
    MyListIterator(MyArrayList<E> arrayList, int i) {
        super(arrayList, i);
    }

    @Override
    public boolean hasPrevious() {
        return cursor != 0;
    }

    @Override
    public E previous() {
        int i = cursor - 1;
        if (i < 0)
            throw new NoSuchElementException();
        Object[] elementData = super.array.getArray();
        if (i >= elementData.length)
            throw new ConcurrentModificationException();
        cursor = i;
        return (E) elementData[lastRet = i];
    }

    @Override
    public int nextIndex() {
        return cursor;
    }

    @Override
    public int previousIndex() {
        return cursor - 1;
    }

    @Override
    public void set(E e) {
        if (lastRet < 0)
            throw new IllegalStateException();
        try {
            array.set(lastRet, e);
        } catch (IndexOutOfBoundsException ex) {
            throw new ConcurrentModificationException();
        }
    }

    @Override
    public void add(E e) {
        try {
            int i = cursor;
            array.add(i, e);
            cursor = i + 1;
            lastRet = -1;
        } catch (IndexOutOfBoundsException ex) {
            throw new ConcurrentModificationException();
        }
    }
}
