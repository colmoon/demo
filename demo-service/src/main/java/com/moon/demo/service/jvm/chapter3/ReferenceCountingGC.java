package com.moon.demo.service.jvm.chapter3;
public class ReferenceCountingGC {
    public Object instance = null;
    private static final int ONE_MB = 1024 * 1024;

    private byte[] bigSize = new byte[2 * ONE_MB];

    public static void main(String[] args) {
        testGC();


    }

    public static void testGC() {
            ReferenceCountingGC objA = new ReferenceCountingGC();
            ReferenceCountingGC objB = new ReferenceCountingGC();
            objA.instance = objB;
            objB.instance = objA;

            objA = null;
            objB = null;

            System.gc();
    }
}