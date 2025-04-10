package com.epam.tat.module4;

public class FixedCalculator extends Calculator {

    @Override
    public double cos(double a) {
        return Math.cos(a);
    }

    @Override
    public double ctg(double a) {
        return 1 / Math.tan(a);
    }
}