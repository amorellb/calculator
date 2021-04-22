package com.calculator.service;

/*Clase que contiene las operaciones posibles que se pueden realizar*/
public class Operations {

    /*Método para calcular la suma*/
    public static Double addition(Double firstNumber, Double secondNumber) {
        return firstNumber + secondNumber;
    }

    /*Método para calcular la resta*/
    public static Double subtraction(Double firstNumber, Double secondNumber) {
        return firstNumber - secondNumber;
    }

    /*Método para calcular la multiplicación*/
    public static Double multiplication(Double firstNumber, Double secondNumber) {
        return firstNumber * secondNumber;
    }

    /*Método para calcular la división. Este método muestra un mensaje específico en caso de fallo*/
    public static Double division(Double firstNumber, Double secondNumber) throws Exception {
        if (secondNumber != 0) {
            return firstNumber / secondNumber;
        } else {
            throw new Exception("Division by 0");
        }
    }

    /*Método para calcular el resto*/
    public static Double remainder(Double firstNumber, Double secondNumber) {
        return firstNumber % secondNumber;
    }
}
