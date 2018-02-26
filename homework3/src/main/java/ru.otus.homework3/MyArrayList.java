package ru.otus.homework3;

import java.util.*;

/**
 * Created by Антон Дементьев on 18.02.2018.
 */
public class MyArrayList<E> implements List<E> {

    private static final int DEFAULT_CAPACITY = 10;
    private int size = 0;
    private int capacity;
    private Object[] array;

    public MyArrayList() {
        capacity = DEFAULT_CAPACITY;
        array = new Object[DEFAULT_CAPACITY];
    }

    public MyArrayList(E[] array) {
        size = array.length;
        capacity = size;
        this.array = new Object[capacity];
        System.arraycopy(this.array, 0, array, 0, size);
    }

    public MyArrayList(MyArrayList arrayList) {
        size = arrayList.size();
        capacity = size;
        array = new Object[capacity];
        System.arraycopy(arrayList, 0, array, 0, size);

    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean contains(Object o) {
        return indexOf(o) >= 0;
    }

    public Iterator<E> iterator() {
        return listIterator();
    }

    public Object[] toArray() {
        Object[] objects = new Object[size];
        System.arraycopy(array, 0, objects, 0, size);
        return objects;
    }

    public <T> T[] toArray(T[] a) {

        throw new  RuntimeException();
    }

    public boolean add(E e) {
        if (size == capacity) {
            capacity = (int) (capacity * 1.5);
            Object[] temp = new Object[capacity];
            System.arraycopy(array, 0, temp, 0, size);
            array = temp;
        }
        array[size++] = e;
        return true;
    }

    public boolean remove(Object o) {
        throw new  RuntimeException();
    }

    public boolean containsAll(Collection<?> c) {
        throw new  RuntimeException();
    }

    public boolean addAll(Collection<? extends E> c) {
        Object[] a = c.toArray();
        int numNew = a.length;
        int sizeNew = size + numNew;
        if (sizeNew > (capacity - size)) {
            Object[] b = new Object[size];
            System.arraycopy(array, 0, b, 0, size);
            array = new Object[(int) (sizeNew * 1.5)];
            System.arraycopy(b, 0, array, 0, size);
        }
        System.arraycopy(a, 0, array, size, numNew);
        size += numNew;
        return numNew != 0;
    }


    public boolean addAll(int index, Collection<? extends E> c) {
        throw new  RuntimeException();
    }

    public boolean removeAll(Collection<?> c) {
        throw new  RuntimeException();
    }

    public boolean retainAll(Collection<?> c) {
        throw new  RuntimeException();
    }

    public void clear() {
        for (int i = 0; i < size; i++)
            array[i] = null;

        size = 0;

    }

    @SuppressWarnings("unchecked")
    public E get(int index) {
        if (index < 0 && index >= size) {
            throw new IndexOutOfBoundsException();
        }
        return (E) array[index];
    }

    @SuppressWarnings("unchecked")
    public E set(int index, E element) {
        if (index < 0 && index >= size) {
            throw new IndexOutOfBoundsException();
        }
        array[index] = element;
        return (E) array[index];
    }

    public void add(int index, E element) {
        if (index < 0 && index > size) {
            throw new IndexOutOfBoundsException();
        }
        array[index] = element;

    }

    @SuppressWarnings("unchecked")
    public E remove(int index) {
        if (index < 0 && index >= size) {
            throw new IndexOutOfBoundsException();
        }
        E element = (E) array[index];
        array[index] = null;
        int numMoved = --size - index;
        if (numMoved > 0)
            System.arraycopy(array, index + 1, array, index, numMoved);

        return element;
    }

    public int indexOf(Object o) {
        if (o == null) {
            for (int i = 0; i < size; i++)
                if (array[i] == null)
                    return i;
        } else {
            for (int i = 0; i < size; i++)
                if (o.equals(array[i]))
                    return i;
        }
        return -1;
    }

    public int lastIndexOf(Object o) {
        if (o == null) {
            for (int i = size - 1; i >= 0; i--)
                if (array[i] == null)
                    return i;
        } else {
            for (int i = size - 1; i >= 0; i--)
                if (o.equals(array[i]))
                    return i;
        }
        return -1;
    }

    public ListIterator<E> listIterator() {
        return new MyListIterator<>(this, 0);
    }

    public ListIterator<E> listIterator(int index) {
        throw new  RuntimeException();

    }

    public List<E> subList(int fromIndex, int toIndex) {
        throw new  RuntimeException();
    }

    Object[] getArray() {
        return array;
    }
}
