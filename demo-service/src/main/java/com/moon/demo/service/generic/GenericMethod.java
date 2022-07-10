package com.moon.demo.service.generic;

public class GenericMethod {
    public <K, V> void f(K k, V v) {
        System.out.println(k.getClass().getSimpleName());
        System.out.println(v.getClass().getSimpleName());
    }

    public static void main(String[] args) {
        GenericMethod gm = new GenericMethod();
//        gm.f(new Integer(0),new String("generic"));
        gm.f(0, "generic");
    }
}