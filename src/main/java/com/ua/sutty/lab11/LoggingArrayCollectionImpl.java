package com.ua.sutty.lab11;

import interfaces.logging.LoggingArrayCollection;
import interfaces.task5.ArrayCollection;
import interfaces.task5.ArrayIterator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class LoggingArrayCollectionImpl<E> implements ArrayCollection<E>, LoggingArrayCollection<E> {

//    private static final org.apache.log4j.Logger LOGGER1 = org.apache.log4j.Logger.getLogger(LoggingArrayCollectionImpl.class);

    protected final Logger LOGGER = LoggerFactory
        .getLogger(LoggingArrayCollectionImpl.class.getName());

    @Override
    public Logger getLogger() {
        return LOGGER;
    }

    private static final int DEFAULT_CAPACITY = 10;
    private int size;
    private int capacity;
    private Object[] array;

    public LoggingArrayCollectionImpl() {
        LOGGER.trace("Initialize collection without param");
        capacity = DEFAULT_CAPACITY;
        array = new Object[capacity];
    }

    public LoggingArrayCollectionImpl(int capacity) {
        LOGGER.trace("Initialize collection with capacity");
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
        LOGGER.trace("Get array with collection");
        return Arrays.copyOfRange(array, 0, size);
    }

    @Override
    public void setArray(Object[] objects) {
        LOGGER.trace("Set array in collection");
        if (objects == null){
            LOGGER.error("Flew out NullPointerException");
            throw new NullPointerException();
        }
        array = objects;
        size = objects.length;
    }

    @Override
    public int size() {
        LOGGER.trace("Get size collection");
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        LOGGER.trace("Check on empty");
        return size == 0;
    }

    @Override
    public boolean contains(Object o) {
        LOGGER.trace("Check on contains");
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
        return new LoggingArrayIteratorImpl<>();
    }


    @Override
    public Object[] toArray() {
        LOGGER.trace("Lead collection to array");
        Object[] tempArray = new Object[size];
        System.arraycopy(array, 0, tempArray, 0, size);
        return tempArray;
    }

    @Override
    public boolean add(E o) {
        LOGGER.trace("Add object in collection");
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
        LOGGER.trace("Remove object with collection");

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
        LOGGER.trace("Add all element with first collection to second collection");

        if (c == this){
            LOGGER.error("This is the same collection");
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
        LOGGER.trace("Clear collection");
        for (int i = 0; i < size; i++) {
            array[i] = null;
        }
        size = 0;
    }

    @Override
    public boolean retainAll(Collection c) {
        LOGGER.trace("Retain all collection");

        if (c == null) {
            LOGGER.error("String == null, null pointer exception");
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
        LOGGER.trace("Remove all object with collection");

        if (c == null) {
            LOGGER.error("String == null, null pointer exception");
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
        LOGGER.trace("Contains all element two collection");

        if (c == null) {
            LOGGER.error("String == null, null pointer exception");
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


    public class LoggingArrayIteratorImpl<E> implements ArrayIterator<E> {

        private int index;

        public LoggingArrayIteratorImpl() {
            LOGGER.trace("Initialize iterator");
            index = -1;
        }

        @Override
        public Object[] getArray() {
            LOGGER.trace("Get array");
            return LoggingArrayCollectionImpl.this.getArray();
        }

        @Override
        public boolean hasNext() {
            LOGGER.trace("Call hasNext");
            return index < (size - 1);
        }

        @Override
        public E next() {
            LOGGER.trace("Get next element in collection");
            if (hasNext()) {
                return (E) array[++index];
            }
            LOGGER.error("Don't have next element");
            throw new NoSuchElementException();
        }

        @Override
        public void remove() {
            LOGGER.trace("Remove element with collection");
            if (index < 0) {
                LOGGER.error("Index < 0, Illegal Argument");
                throw new IllegalStateException();
            }
            LoggingArrayCollectionImpl.this.removeIndex(index);
        }
    }


}
