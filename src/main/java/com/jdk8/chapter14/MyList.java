package com.jdk8.chapter14;

/**
 * @classname: MyList
 * @description: MyList
 * @author: wuxiaojian
 * @create: 2021-04-20 08:57
 */
public interface MyList<T> {

    /**
     * head
     * @return: T
     **/
    T head();

    /**
     * tail
     * @return: com.jdk8.chapter14.MyList<T>
     **/
    MyList<T> tail();

    /**
     * isEmpty
     * @return: boolean
     **/
    default boolean isEmpty() {
        return true;
    }
}
