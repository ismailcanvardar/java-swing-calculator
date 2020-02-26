package com.mythi.calculator;

public abstract class Converter {
    public static int[] convertToInt(String number1, String number2) {
        int a = Integer.parseInt(number1);
        int b = Integer.parseInt(number2);

        return new int[]{ a, b };
    }

    public String convertToString(int number1) {
        String convertedInteger = String.valueOf(number1);

        return convertedInteger;
    }
}
