package com.simple.transfromer;

public interface Transformer<S, T> {
    T convert(S s);
}

