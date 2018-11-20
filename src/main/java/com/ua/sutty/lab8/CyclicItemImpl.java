package com.ua.sutty.lab8;

import interfaces.task8.CyclicItem;

import java.io.Serializable;

public class CyclicItemImpl implements CyclicItem, Serializable {

    private Object value;

    private transient Object temp;

    private CyclicItem nextItem = this;

    public CyclicItemImpl() {

    }

    public CyclicItemImpl(Object value) {
        this.value = value;
    }

    @Override
    public void setValue(Object o) {
        this.value = o;
    }

    @Override
    public Object getValue() {
        return value;
    }

    @Override
    public void setTemp(Object o) {
        this.temp = o;
    }

    @Override
    public Object getTemp() {
        return this.temp;
    }

    @Override
    public CyclicItem nextItem() {
        return this.nextItem;
    }

    @Override
    public void setNextItem(CyclicItem cyclicItem) {
        this.nextItem = cyclicItem;
    }

    @Override
    public String toString() {
        return "CyclicItemImpl{" +
            "value=" + value +
            ", temp=" + temp +
            '}';
    }

}
