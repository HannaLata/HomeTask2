package com.mainacad.service;

import java.util.logging.Logger;

public class NumberService {

    private static final Logger LOGGER = Logger.getLogger(NumberService.class.getName());


    public static String divide(int dividend, int divider) throws Exception {
        String out = "";

        int maxLen = 1 + Math.max(Integer.valueOf(dividend).toString().length(), Integer.valueOf(divider).toString().length());
        String intFormat = "%" + maxLen + "d";
        out += "\n " + String.format(intFormat, dividend) + "|" + String.format(intFormat, divider) + "\n";
        int result = 0;

        while (true) {

            Num num = divideNext(dividend, divider);
            if (num.getDigit() == 0) {
                break;
            }

            String numFormat = "%" + (maxLen - num.getPointPosition()) + "d";
            out += " " + String.format(numFormat, -divider * num.getDigit()) + generateTab(num.getPointPosition(), ' ')
                    + "|" + String.format(numFormat, num.getDigit()) + "\n";

            result += num.getValue();
            dividend -= num.getValue() * divider;

            out += generateTab(maxLen + maxLen + 2, '_') + '\n';
            out += " " + String.format(intFormat, dividend) + "|" + String.format(intFormat, result) + "\n";

        }
        return out;
    }

    private static Num divideNext(int dividend, int divider) {
        int pointPosition = 0;
        if (dividend < divider) {
            return new Num(0, 0);
        }
        while (dividend > divider * 10) {
            pointPosition++;
            divider *= 10;
        }
        int count = 1;
        while (dividend > divider * (count + 1)) {
            count++;
        }
        return new Num(count, pointPosition);
    }

    private static String generateTab ( int length, char ch){
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < length; i++) {
            result.append(ch);
        }
        return result.toString();
    }


}
