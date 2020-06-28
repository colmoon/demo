package com.goldcard.dto;

public interface DTOConvert<S,T> {
    T convert(S s);
}
