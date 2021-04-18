package com.calculator.service;

import com.calculator.data.PossibleOperations;

import java.util.Locale;
import java.util.Scanner;

public class Util {

    public static Double doOperation(String operation, Double firstNumber, Double secondNumber) throws Exception {
        Double result = 0.0;
        switch (operation.toLowerCase()) {
            case "addition":
                result = Operations.addition(firstNumber, secondNumber);
                break;
            case "subtraction":
                result = Operations.subtraction(firstNumber, secondNumber);
                break;
            case "multiplication":
                result = Operations.multiplication(firstNumber, secondNumber);
                break;
            case "division":
                result = Operations.division(firstNumber, secondNumber);
                break;
            case "remainder":
                result = Operations.remainder(firstNumber, secondNumber);
                break;
            default:
                break;
        }
        return result;
    }

    public static String askOperation() throws Exception {
        try {
            Scanner input = new Scanner(System.in);
            return input.nextLine().toLowerCase();
        } catch (Exception exp) {
            throw new Exception("Not a valid operation");
        }
    }

    public static Double askNumber() throws Exception {
        try {
            Scanner input = new Scanner(System.in);
            input.useLocale(Locale.US);
            return input.nextDouble();
        } catch (Exception ex) {
            throw new Exception("Not a valid number");
        }
    }

    public static Boolean isAValidOperationInput(String input) {
        boolean flag = false;
        for (int i = 0; i < PossibleOperations.values().length; i++) {
            if (input.equals(PossibleOperations.values()[i].toString().toLowerCase())) {
                flag = true;
            }
        }
        return flag;
    }

    public static Boolean isAValidNumberInput(Double input) {
        boolean flag = false;
        if (!input.isNaN() || !input.isInfinite()) {
            flag = true;
        }
        return flag;
    }
}