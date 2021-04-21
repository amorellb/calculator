package com.calculator.service;

import com.calculator.data.PossibleOperations;

import java.util.Scanner;

public class Util {

    public static Double doOperation(String operation, Double firstNumber, Double secondNumber) throws Exception {
        Double result = 0.0;
        switch (operation.toLowerCase()) {
            case "addition":
            case "sumar":
            case "suma":
                result = Operations.addition(firstNumber, secondNumber);
                break;
            case "subtraction":
            case "restar":
            case "resta":
                result = Operations.subtraction(firstNumber, secondNumber);
                break;
            case "multiplication":
            case "multiplicar":
            case "multiplicacion":
                result = Operations.multiplication(firstNumber, secondNumber);
                break;
            case "division":
            case "dividir":
                result = Operations.division(firstNumber, secondNumber);
                break;
            case "remainder":
            case "resto":
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
        String number;
        try {
            Scanner input = new Scanner(System.in);
            number = input.nextLine();
            while (!isDouble(number)) {
                System.out.println("Not a valid number");
                System.out.println(" ");
                System.out.println("------------------------------------------------");
                System.out.println("                 Write a number                 ");
                System.out.println("------------------------------------------------");
                number = input.nextLine();
            }
        } catch (Exception ex) {
            throw new Exception("Not a valid number");
        }
        return Double.parseDouble(number);
    }

    public static Boolean isDouble(String input) {
        try {
            Double.parseDouble(input);
            return true;
        } catch (NumberFormatException nfe) {
            return false;
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
