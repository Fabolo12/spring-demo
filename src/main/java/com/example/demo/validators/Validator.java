package com.example.demo.validators;

public interface Validator<T> {
    void valid(T value);
}
