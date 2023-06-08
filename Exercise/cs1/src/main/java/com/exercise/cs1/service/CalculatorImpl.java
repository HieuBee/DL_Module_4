package com.exercise.cs1.service;

import org.springframework.stereotype.Service;

@Service
public class CalculatorImpl implements ICalculator{
    @Override
    public double currency(double usd) {
        double vnd = usd * 23000;
        return vnd;
    }
}
