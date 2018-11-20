package com.ua.sutty.lab11;

import java.util.Collection;

import com.ua.sutty.lab5.ArrayCollectionImpl;
import org.slf4j.LoggerFactory;
import org.apache.log4j.Logger;

import interfaces.logging.LoggingArrayCollection;

public class LoggingArrayCollectionImpl2<E> extends ArrayCollectionImpl implements LoggingArrayCollection {

    private static final Logger logger = Logger.getLogger(LoggingArrayCollection.class);
//    protected final Logger logger = LoggerFactory
//        .getLogger(LoggingArrayCollectionImpl.class.getName());


//    @Override
//    public Logger getLogger() {
//        return logger;
//    }

    public LoggingArrayCollectionImpl2() {
        super();
        logger.trace("Initialize collection without param");
    }

    public LoggingArrayCollectionImpl2(int i) {
        super(i);
        logger.trace("Initialize collection with capacity");
    }

    @Override
    public int size() {
        logger.trace("Get size");
        try {
            return super.size();
        } catch (RuntimeException e) {
            logger.error(e.getMessage(), e);
        }
        return 0;
    }

    @Override
    public boolean isEmpty() {
        logger.trace("Check on empty");
        try {
            return super.isEmpty();
        } catch (RuntimeException e) {
            logger.error(e.getMessage(), e);
        }
        return false;
    }

    @Override
    public boolean contains(Object o) {
        logger.trace("Check on contains");
        try {
            return super.contains(o);
        } catch (RuntimeException e) {
            logger.error(e.getMessage(), e);
        }
        return false;
    }

    @Override
    public Object[] getArray() {
        logger.trace("Get array with collection");
        try {
            return super.getArray();
        } catch (RuntimeException e) {
            logger.error(e.getMessage(), e);
        }
        return null;
    }

    @Override
    public void setArray(Object[] array) {
        logger.trace("Set array in collection");
        try {
            super.setArray(array);
        } catch (RuntimeException e) {
            logger.error(e.getMessage(), e);
        }

    }

    @Override
    public Object[] toArray() {
        logger.trace("Lead collection to array");
        Object[] result = null;
        try {
            result = super.toArray();
        } catch (RuntimeException e) {
            logger.error(e.getMessage(), e);
        }
        return result;
    }

    @Override
    public Object[] toArray(Object[] a) {
        logger.trace("Lead collection to array");
        Object[] result = null;
        try {
            result = super.toArray(a);
        } catch (RuntimeException e) {
            logger.error(e.getMessage(), e);
        }
        return result;
    }

    @Override
    public boolean add(Object e) {
        logger.trace("Add object in collection");
        boolean result = false;
        try {
            result = super.add(e);
        } catch (RuntimeException exc) {
            logger.error(exc.getMessage(), exc);
        }
        return result;
    }

    @Override
    public boolean remove(Object o) {
        logger.trace("Remove object with collection");
        boolean result = false;
        try {
            result = super.remove(o);
        } catch (RuntimeException exc) {
            logger.error(exc.getMessage(), exc);
        }
        return result;
    }

    @Override
    public boolean containsAll(Collection c) {
        logger.trace("Contains all element two collection");
        return super.containsAll(c);
    }

    @Override
    public boolean addAll(Collection c) {
        logger.trace("Add all element with first collection to second collection");
        boolean result = false;
        try {
            result = super.addAll(c);
        } catch (RuntimeException exc) {
            logger.error(exc.getMessage(), exc);
        }
        return result;
    }

    @Override
    public boolean removeAll(Collection c) {
        logger.trace("Remove all object with collection");
        boolean result = false;
        try {
            result = super.removeAll(c);
        } catch (RuntimeException e) {
            logger.error(e.getMessage(), e);
        }
        return result;
    }

    @Override
    public boolean retainAll(Collection c) {
        logger.trace("Retain all collection");
        boolean result = false;
        try {
            result = super.retainAll(c);
        } catch (RuntimeException e) {
            logger.error(e.getMessage(), e);
        }
        return result;
    }

    @Override
    public void clear() {
        logger.trace("Clear collection");
        super.clear();
    }

    @Override
    public org.slf4j.Logger getLogger() {
        return null;
    }
}