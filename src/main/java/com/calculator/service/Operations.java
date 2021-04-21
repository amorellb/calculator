package com.calculator.service;

public class Operations {

    public static Double addition(Double firstNumber, Double secondNumber) {
        return firstNumber + secondNumber;
    }

    public static Double subtraction(Double firstNumber, Double secondNumber) {
        return firstNumber - secondNumber;
    }

    public static Double multiplication(Double firstNumber, Double secondNumber) {
        return firstNumber * secondNumber;
    }

    public static Double division(Double firstNumber, Double secondNumber) throws Exception {
        if (secondNumber != 0) {
            return firstNumber / secondNumber;
        } else {
            throw new Exception("Division by 0");
        }
    }

    public static Double remainder(Double firstNumber, Double secondNumber) {
        return firstNumber % secondNumber;
    }
}
