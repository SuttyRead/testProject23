package com.ua.sutty.lab5;

import interfaces.task5.ArrayCollection;
import interfaces.task5.ArrayIterator;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class ArrayCollectionImpl<E> implements ArrayCollection<E> {

    private static final int DEFAULT_CAPACITY = 10;
    private int size;
    private int capacity;
    private Object[] array;

    public ArrayCollectionImpl() {
        capacity = DEFAULT_CAPACITY;
        array = new Object[capacity];
    }

    public ArrayCollectionImpl(int capacity) {
        this.capacity = capacity;
        array = new Object[capacity];
    }

    private void increaseCapacity() {
        capacity *= 2;
        Object[] tempArray = new Object[capacity];
        for (int i = 0; i < size; i++) {
            tempArray[i] = array[i];
            array[i] = null;
        }
        array = tempArray;
    }

    private void trimToSizeArray() {
        capacity = size + 1;
        Object[] newArray = new Object[capacity];
        System.arraycopy(array, 0, newArray, 0, size);
        array = newArray;
    }

    @Override
    public Object[] getArray() {
        return Arrays.copyOfRange(array, 0, size);
    }

    @Override
    public void setArray(Object[] objects) {
        if (objects == null){
            throw new NullPointerException();
        }
        array = objects;
        size = objects.length;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(Object o) {
        return indexOf(o) >= 0;
    }

    public int indexOf(Object o) {
        if (o == null) {
            for (int i = 0; i < size; i++) {
                if (array[i] == null) {
                    return i;
                }
            }
        } else {
            for (int i = 0; i < size; i++) {
                if (o.equals(array[i])) {
                    return i;
                }
            }
        }
        return -1;
    }

    @Override
    public Iterator<E> iterator() {
        return new ArrayIteratorImpl<>();
    }


    @Override
    public Object[] toArray() {
        Object[] tempArray = new Object[size];
        System.arraycopy(array, 0, tempArray, 0, size);
        return tempArray;
    }

    @Override
    public boolean add(E o) {
        if (size >= capacity) {
            increaseCapacity();
        }
        array[size++] = o;
        return true;
    }

    private void shiftToLeft(int start) {
        size--;
        if (size <= 0) {
            return;
        }
        if (size != start) {
            System.arraycopy(array, start + 1, array, start, size - start);
        }
        array[size] = null;
    }

    @Override
    public boolean remove(Object o) {
        if ((size == 0)) {
            return false;
        }
        int i;
        for (i = 0; i < size; i++) {
            if (array[i] == null && o == null) {
                break;
            }
            if ((array[i] != null) && (array[i].equals(o))) {
                break;
            }
        }
        if (i < size) {
            shiftToLeft(i);
            return true;
        }
        return false;
    }

    private boolean removeIndex(int index) {
        if (index < size) {
            E[] temp = (E[]) Arrays.copyOf(array, size);
            array = new Object[--size];
            System.arraycopy(temp, 0, array, 0, index);
            System.arraycopy(temp, index + 1, array, index, size - index);
            return true;
        }
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {

        if (c == this){
            throw new IllegalArgumentException();
        }

        Object[] a = c.toArray();
        int numNew = a.length;
        capacity = size + numNew;
        System.arraycopy(a, 0, array, size, numNew);
        size += numNew;
        return numNew != 0;
    }

    @Override
    public void clear() {
        for (int i = 0; i < size; i++) {
            array[i] = null;
        }
        size = 0;
    }

    @Override
    public boolean retainAll(Collection c) {
        if (c == null) {
            throw new NullPointerException();
        }
        if (c.size() == 0) {
            clear();
            return true;
        }
        int i = 0;
        boolean modifier = false;
        while (i < size) {
            if (c.contains(array[i])) {
                i++;
            } else {
                shiftToLeft(i);
                modifier = true;
            }
        }
        return modifier;
    }

    @Override
    public boolean removeAll(Collection c) {
        if (c == null) {
            throw new NullPointerException();
        }
        if ((c.size() == 0) || (size == 0)) {
            return false;
        }
        boolean modified = false;
        int i = 0;
        while (i < size) {
            if (c.contains(array[i])) {
                shiftToLeft(i);
                modified = true;
            } else {
                i++;
            }
        }
        return modified;
    }

    @Override
    public boolean containsAll(Collection c) {
        if (c == null) {
            throw new NullPointerException();
        }
        for (Object e : c) {
            if (!contains(e)) {
                return false;
            }
        }
        return true;
    }

    @SuppressWarnings("unchecked")
    @Override
    public Object[] toArray(Object[] a) {
        if (a.length < size) {
            return Arrays.copyOf(array, size, a.getClass());
        }
        System.arraycopy(array, 0, a, 0, size);
        if (a.length > size) {
            a[size] = null;
        }
        return a;
    }


    public class ArrayIteratorImpl<E> implements ArrayIterator<E> {

        private int index;

        public ArrayIteratorImpl() {
            index = -1;
        }

        @Override
        public Object[] getArray() {
            return ArrayCollectionImpl.this.getArray();
        }

        @Override
        public boolean hasNext() {
            return index < (size - 1);
        }

        @Override
        public E next() {
            if (hasNext()) {
                return (E) array[++index];
            }
            throw new NoSuchElementException();
        }

        @Override
        public void remove() {
            if (index < 0) {
                throw new IllegalStateException();
            }
           ArrayCollectionImpl.this.removeIndex(index);
        }
    }

}
