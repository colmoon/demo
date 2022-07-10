package com.moon.demo.service.jdk8.function;

import java.util.function.Function;

public class Operation{

/**
 * 下面这个方法接受一个int类型参数a,返回a+1,符合我上面说的接受一个参数,返回一个值
 *     所以呢这个方法就符合Function接口的定义,那要怎么用呢,继续看例子
 **/
public static int addOne(int a){
    return a+1;
}

/**
 * 该方法第二个参数接受一个function类型的行为,然后调用apply，对a执行这段行为
 **/
public static int oper(int a, Function<Integer,Integer> action){
    return action.apply(a);
}

/* 下面调用这个oper方法,将addOne方法作为参数传递 */
public static void main(String[] args){
    int n = 1;

    //这里可以换成方法引用的写法 int y = oper(x,Operation::addOne)
    int y = oper(n, Operation::addOne);
    // 打印结果 x=1, y=2
    System.out.printf("x= %d, y = %d", n, y);
    
    /* 当然你也可以使用lambda表达式来表示这段行为,只要保证一个参数,一个返回值就能匹配 */
    // y = 4
    y = oper(n, x -> x + 3);
    // y = 3
    y = oper(n, x -> x * 3);
}

}