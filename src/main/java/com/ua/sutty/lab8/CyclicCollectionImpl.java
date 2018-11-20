package com.ua.sutty.lab8;

import interfaces.task8.CyclicCollection;
import interfaces.task8.CyclicItem;

import java.io.Serializable;

public class CyclicCollectionImpl implements CyclicCollection, Serializable {

    private CyclicItem firstCyclicItem;
    private CyclicItem lastCyclicItem;
    private int length;

    @Override
    public boolean add(CyclicItem cyclicItem) {
        if (length == 0) {
            this.firstCyclicItem = cyclicItem;
            this.firstCyclicItem.setNextItem(this.firstCyclicItem);
            this.lastCyclicItem = this.firstCyclicItem;
            length++;
        } else {
            if (matchCheck(cyclicItem)) {
                throw new IllegalArgumentException();
            } else {
                this.lastCyclicItem.setNextItem(cyclicItem);
                this.lastCyclicItem = cyclicItem;
                this.lastCyclicItem.setNextItem(this.firstCyclicItem);
                length++;
            }
        }
        return true;
    }

    @Override
    public void insertAfter(CyclicItem cyclicItem, CyclicItem newCyclicItem) {
        if (cyclicItem == null || newCyclicItem == null) {
            throw new NullPointerException();
        }
        if (!matchCheck(cyclicItem)) {
            throw new IllegalArgumentException();
        }
        if (matchCheck(newCyclicItem)) {
            throw new IllegalArgumentException();
        }
        CyclicItem currentItem = this.firstCyclicItem;
        CyclicItem nextItem = this.firstCyclicItem.nextItem();
        for (int i = 0; i < length; i++) {
            if (currentItem.equals(cyclicItem)) {
                if (length > 2) {
                    currentItem.setNextItem(newCyclicItem);
                    newCyclicItem.setNextItem(nextItem);
                    length++;
                    return;
                } else if (length == 2) {
                    currentItem.setNextItem(newCyclicItem);
                    newCyclicItem.setNextItem(nextItem);
                    this.firstCyclicItem = nextItem;
                    length++;
                    return;
                }
            }
            lastCyclicItem = currentItem;
            currentItem = nextItem;
            nextItem = nextItem.nextItem();
        }
    }

    @Override
    public CyclicItem getFirst() {
        if (length == 0){
            return null;
        }
        if (this.firstCyclicItem == null) {
            throw new NullPointerException();
        }
        return this.firstCyclicItem;
    }

    @Override
    public boolean remove(CyclicItem cyclicItem) {
        if (cyclicItem == null) {
            throw new NullPointerException();
        }
        if (length == 0) {
            return false;
        }
        CyclicItem previouslyCyclicItem = lastCyclicItem;
        CyclicItem currentCyclicItem = firstCyclicItem;
        CyclicItem nextCyclicItem = firstCyclicItem.nextItem();
        for (int i = 0; i < length; i++) {
            if (currentCyclicItem.equals(cyclicItem)) {
                if (length > 2) {
                    previouslyCyclicItem.setNextItem(
                        currentCyclicItem.nextItem());
                    length--;
                    return true;
                } else if (length == 2) {
                    currentCyclicItem.setNextItem(null);
                    previouslyCyclicItem.setNextItem(nextCyclicItem);
                    firstCyclicItem = nextCyclicItem;
                    length--;
                    return true;
                } else {
                    firstCyclicItem = null;
                    length--;
                    return true;
                }
            }
            previouslyCyclicItem = currentCyclicItem;
            currentCyclicItem = nextCyclicItem;
            nextCyclicItem = nextCyclicItem.nextItem();
        }
        return false;
    }

    @Override
    public int size() {
        return length;
    }

    private boolean matchCheck(CyclicItem cyclicItem) {
        int n = length;
        CyclicItem currentCyclicItem = firstCyclicItem;
        while (n != 0) {
            boolean cont = currentCyclicItem.equals(cyclicItem);
            if (cont) {
                return true;
            }
            currentCyclicItem = currentCyclicItem.nextItem();
            n--;
        }
        return false;
    }

    @Override
    public String toString() {
        return "CyclicCollectionImpl{" +
            "firstCyclicItem=" + firstCyclicItem +
            ", lastCyclicItem=" + lastCyclicItem +
            ", length=" + length +
            '}';
    }
}
