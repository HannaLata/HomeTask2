package com.mainacad.service;

public class Num {
    private final int digit;
    private final int pointPosition;

    public Num(int value, int pointPosition) {
        this.digit = value;
        this.pointPosition = pointPosition;
    }

    public int getDigit() {
        return digit;
    }

    public int getPointPosition() {
        return pointPosition;
    }

    public double getValue() {
        double result = digit;
        for (int i = 0; i < pointPosition; i++) {
            result *= 10;
        }
        return result;
    }
}

