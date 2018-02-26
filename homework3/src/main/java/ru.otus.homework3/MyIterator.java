package ru.otus.homework3;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by Антон Дементьев on 20.02.2018.
 */
class MyIterator<E> implements Iterator<E> {
    int cursor;
    int lastRet = -1;
    private int size;
    MyArrayList<E> array;

    MyIterator(MyArrayList<E> arrayList, int cursor) {
        this.array = arrayList;
        this.cursor = cursor;
        this.size = arrayList.size();

    }

    @Override
    public boolean hasNext() {
        return cursor != size;
    }

    @Override
    public E next() {
        int i = cursor;
        if (i >= size)
            throw new NoSuchElementException();
        Object[] elementData = array.getArray();
        if (i >= elementData.length)
            throw new ConcurrentModificationException();
        cursor = i + 1;
        return (E) elementData[lastRet = i];
    }

    @Override
    public void remove() {
        if (lastRet < 0)
            throw new IllegalStateException();
        try {
            array.remove(lastRet);
            cursor = lastRet;
            lastRet = -1;
        } catch (IndexOutOfBoundsException ex) {
            throw new ConcurrentModificationException();
        }

    }

}
