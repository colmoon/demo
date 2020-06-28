package com.anhen.aviator;

import com.googlecode.aviator.AviatorEvaluator;

public class SimpleExample {
    public static void main(String[] args) {
        Long result = (Long) AviatorEvaluator.execute("1+2+3");
        System.out.println(result);
    }
}