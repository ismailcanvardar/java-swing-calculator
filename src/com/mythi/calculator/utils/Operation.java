package com.mythi.calculator.utils;

public abstract class Operation extends Converter
{
    public static int add(String num1, String num2) {
        int[] numbers = convertToInt(num1, num2);

        return numbers[0] + numbers[1];
    }

    public static int subtract(String num1, String num2) {
        int numbers[] = convertToInt(num1, num2);

        return numbers[0] - numbers[1];
    }

    public static int multiple(String num1, String num2) {
        int numbers[] = convertToInt(num1, num2);

        return numbers[0] * numbers[1];
    }

    public static int divide(String num1, String num2) {
        int numbers[] = convertToInt(num1, num2);

        return numbers[0] / numbers[1];
    }
}
