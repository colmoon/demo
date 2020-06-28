package com.anhen.structures;

/**
 * @ClassName ArrayQueue
 * @Description TODO
 * @Author wuxiaojian
 * @Date 2019/6/11 11:01
 * @Version 1.0
 **/

public class ArrayQueue<T> implements ISeqList<T> {
    private T[] q;       // queue elements
    private int length;          // number of elements on queue
    private int first;      // index of first element of queue
    private int last;       // index of next available slot

    @Override
    public boolean isEmpty() {
        return length == 0 ? true : false;
    }

    @Override
    public int length() {
        return length;
    }

    @Override
    public T get(int index) {

        return null;
    }

    @Override
    public T set(int index, T data) {
        return null;
    }

    @Override
    public boolean add(int index, T data) {
        return false;
    }

    @Override
    public boolean add(T data) {
        return false;
    }

    @Override
    public T remove(int index) {
        return null;
    }

    @Override
    public boolean remove(T data) {
        return false;
    }

    @Override
    public boolean removeAll(T data) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public boolean contains(T data) {
        return false;
    }

    @Override
    public int indexOf(T data) {
        return 0;
    }

    @Override
    public int lastIndexOf(T data) {
        return 0;
    }
}
