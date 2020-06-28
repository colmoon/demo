package com.goldcard.dto;

import java.util.function.Function;

public abstract class Converter<A, B> implements Function<A, B> {
    protected abstract B doForward(A a);
    protected abstract A doBackward(B b);
    //其他略
}