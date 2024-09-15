package com.example.calculator.service;

import org.springframework.stereotype.Service;

@Service
public class CalculatorService {
    public Integer plus(Integer a, Integer b) {
        return a + b;
    }
    public Integer minus(Integer a, Integer b) {
        return a - b;
    }
    public Integer multiply(Integer a, Integer b) {
        return a * b;
    }
    public double divide(Integer a, Integer b) {
        return (double) a / b;
    }
}
