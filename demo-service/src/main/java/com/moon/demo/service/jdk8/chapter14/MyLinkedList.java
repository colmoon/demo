package com.moon.demo.service.jdk8.chapter14;


/**
 * @classname: MyLinkedList
 * @description: MyLinkedList
 * @author: wuxiaojian
 * @create: 2021-04-20 08:57
 */
public class MyLinkedList<T> implements MyList<T> {
    private final T head;
    private final MyList<T> tail;

    public MyLinkedList(T head, MyList<T> tail) {
        this.head = head;
        this.tail = tail;
    }

    @Override
    public T head() {
        return head;
    }

    @Override
    public MyList<T> tail() {
        return tail;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }
}