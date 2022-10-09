package com.util;

public class MathCalculation {

    static double roundOff(double number) {
        double scale = (Math.pow(10, 2));
        return Math.round(number * scale) / scale;
    }

}
