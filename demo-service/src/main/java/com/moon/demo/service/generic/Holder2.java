package com.moon.demo.service.generic;

public class Holder2<T> {

    private T a;
    public Holder2(T a) {
        this.a = a;
    }

    public T get() {
        return a;
    }

    public void set(T a) {
        this.a = a;
    }

    public static void main(String[] args) {
        Holder2<String> holder2 = new Holder2<>("generic");
//        ArrayList<String> arrayList = new ArrayList<String>();
//        String s = holder2.get();

        holder2.set("test");
        System.out.println(holder2.get());
//        holder2.set(1);//无法编译   参数 1 不是 String 类型

    }
}