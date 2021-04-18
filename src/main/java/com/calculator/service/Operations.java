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
        if (secondNumber == 0) {
            throw new Exception("Division by 0");
        } else {
            return firstNumber / secondNumber;
        }
    }

    public static Double remainder(Double firstNumber, Double secondNumber) {
        return firstNumber % secondNumber;
    }
}
