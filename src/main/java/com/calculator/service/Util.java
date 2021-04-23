package com.calculator.service;

import com.calculator.data.PossibleOperations;
import java.util.Scanner;

/*Clase que contiene algunos métodos útiles para la ejecución del programa*/
public class Util {

    /*Método que realizará la operación específica en función del tipo de operación seleccionada por el usuario*/
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

    /*Método para recoger el valor de la petición del tipo de operación introducido por el usuario.
    * En caso de fallo mostrará un mensaje específico*/
    public static String askOperation() throws Exception {
        try {
            Scanner input = new Scanner(System.in);
            return input.nextLine().toLowerCase();
        } catch (Exception exp) {
            throw new Exception("Error: Not a valid operation");
        }
    }

    /*Método para recoger el valor de la petición del número introducido por el usuario.
     * En caso de fallo mostrará un mensaje específico*/
    public static Double askNumber() throws Exception {
        String number;
        try {
            Scanner input = new Scanner(System.in);
            number = input.nextLine();
            while (!isDouble(number)) {
                System.out.println("\u001B[41mError: Not a valid number\u001B[0m");
                System.out.println(" ");
                System.out.println("------------------------------------------------");
                System.out.println("                 \u001B[36mWrite a number\u001B[0m");
                System.out.println("------------------------------------------------");
                number = input.nextLine();
            }
        } catch (Exception ex) {
            throw new Exception("Error: Not a valid number");
        }
        return Double.parseDouble(number);
    }

    /*Método para validar que el input es de tipo double*/
    public static Boolean isDouble(String input) {
        try {
            Double.parseDouble(input);
            return true;
        } catch (NumberFormatException nfe) {
            return false;
        }
    }

    /*Método para validar que el usuario ha introducido una de las opciones correctas para elegir la operación
    * a realizar*/
    public static Boolean isAValidOperationInput(String input) {
        boolean flag = false;
        for (int i = 0; i < PossibleOperations.values().length; i++) {
            if (input.equals(PossibleOperations.values()[i].toString().toLowerCase())) {
                flag = true;
            }
        }
        return flag;
    }

    /*Método para validar que el input es un valor numérico*/
    public static Boolean isAValidNumberInput(Double input) {
        return !input.isNaN() || !input.isInfinite();
    }
}
