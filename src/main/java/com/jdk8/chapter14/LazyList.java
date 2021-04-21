package com.jdk8.chapter14;

import java.util.function.Supplier;

/**
 * @classname: LazyList
 * @description: 数字构成的无限延迟列表
 * @author: wuxiaojian
 * @create: 2021-04-20 09:08
 */
public class LazyList<T> implements MyList<T> {
    final T head;
    final Supplier<MyList<T>> tail;

    public LazyList(T head, Supplier<MyList<T>> tail) {
        this.head = head;
        this.tail = tail;
    }

    @Override
    public T head() {
        return head;
    }

    @Override
    public MyList<T> tail() {
        return tail.get();
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    public static LazyList<Integer> from(int n) {
        return new LazyList<>(n, () -> from(n + 1));
    }

    public static void main(String[] args) {
        LazyList<Integer> numbers = from(4);
        int two = numbers.head();
        int three = numbers.tail().head();
        int four = numbers.tail().tail().head();
        int five = numbers.tail().tail().tail().head();
        System.out.println(two + " " + three + " " + four + " " + five);
    }
}
