package com.calculator;

import com.calculator.data.PossibleOperations;
import com.calculator.service.Util;

public class CalculatorApp {
    public static void main(String[] args) throws Exception {
        System.out.println("************************************************");
        System.out.println("*     Welcome to the best calculator app!      *");
        System.out.println("************************************************");

        System.out.println(" ");

        /*Do-while mediante el que se le pedirá al usuario qué operación quiere realizar de las disponibles*/
        String operation;
        do {
            System.out.println("------------------------------------------------");
            System.out.println("        You can do this five operations         ");
            System.out.println("------------------------------------------------");
            System.out.println("+----------------------------------------------+");
            System.out.println("|                Addition (+)                  |");
            System.out.println("|                Subtraction (-)               |");
            System.out.println("|                Multiplication (*)            |");
            System.out.println("|                Division (/)                  |");
            System.out.println("|                Remainder (%)                 |");
            System.out.println("|                Shutdown :(                   |");
            System.out.println("+----------------------------------------------+");
            System.out.println("Choose one:");

            operation = Util.askOperation();

            if (!Util.isAValidOperationInput(operation)) {
                System.out.println("Error: Not a valid operation");
                System.out.println(" ");
            }
        } while (!Util.isAValidOperationInput(operation));

        /*While mediante el que controlamos el proceso del cálculo mientras la opción seleccionada sea válida
        * y ésta no sea la de apagado*/
        while (Util.isAValidOperationInput(operation) &&
                (!operation.equals(PossibleOperations.SHUTDOWN.toString().toLowerCase()) &&
                        !operation.equals(PossibleOperations.APAGAR.toString().toLowerCase()))) {

            /*Pedimos los valores con los que se realizará el cálculo seleccionado. Estos valores se pedirán mientras
            * se introduzca una opción no válida*/
            double firstNumber;
            double secondNumber = 0.0;
            do {
                System.out.println(" ");

                System.out.println("------------------------------------------------");
                System.out.println("                 Write a number                 ");
                System.out.println("------------------------------------------------");
                firstNumber = Util.askNumber();

                /*Switch para mostrar un mensaje específico en función del tipo de operación seleccionada, al
                * pedir el segundo valor de la operación*/
                switch (operation) {
                    case "addition":
                    case "sumar":
                    case "suma":
                        System.out.println(" ");
                        System.out.println("------------------------------------------------");
                        System.out.println(" Which number would you like to add to " + firstNumber + "?");
                        System.out.println("------------------------------------------------");
                        secondNumber = Util.askNumber();
                        break;
                    case "subtraction":
                    case "restar":
                    case "resta":
                        System.out.println(" ");
                        System.out.println("------------------------------------------------");
                        System.out.println(" Which number would you like to subtract to " + firstNumber + "? ");
                        System.out.println("------------------------------------------------");
                        secondNumber = Util.askNumber();
                        break;
                    case "multiplication":
                    case "multiplicar":
                    case "multiplicacion":
                        System.out.println(" ");
                        System.out.println("------------------------------------------------");
                        System.out.println("Which number would you like to multiply by " + firstNumber + "?");
                        System.out.println("------------------------------------------------");
                        secondNumber = Util.askNumber();
                        break;
                    case "division":
                    case "dividir":
                        do {
                            System.out.println(" ");
                            System.out.println("------------------------------------------------");
                            System.out.println(" By which number would you like to divide " + firstNumber + "?");
                            System.out.println("------------------------------------------------");
                            secondNumber = Util.askNumber();
                            if (secondNumber == 0) {
                                System.out.println(" ");
                                System.out.println("Can't divide by 0");
                            }
                        } while (secondNumber == 0);
                        break;
                    case "remainder":
                    case "resto":
                        System.out.println(" ");
                        System.out.println("------------------------------------------------");
                        System.out.println(" Which number would you like to use to find the ");
                        System.out.println(" reminder when dividing " + firstNumber + "?    ");
                        System.out.println("------------------------------------------------");
                        secondNumber = Util.askNumber();
                        break;
                    default:
                        System.out.println("Oops! Something went wrong :(");
                        break;
                }

                if (!Util.isAValidNumberInput(firstNumber) || !Util.isAValidNumberInput(secondNumber)) {
                    System.out.println("Error: Not a valid number");
                }
            } while (!Util.isAValidNumberInput(firstNumber) || !Util.isAValidNumberInput(secondNumber));

            /*Realizamos la operación*/
            Double result = Util.doOperation(operation, firstNumber, secondNumber);

            /*Switch que mostrará un mensaje específico en función de la operación seleccionada para mostrar el
            * resultado de la operación por pantalla*/
            switch (operation) {
                case "addition":
                case "sumar":
                case "suma":
                    System.out.println(" ");
                    System.out.println("################################################");
                    System.out.println("       The result of " + firstNumber + " + " + secondNumber + " is: " + result);
                    System.out.println("################################################");
                    break;
                case "subtraction":
                case "restar":
                case "resta":
                    System.out.println(" ");
                    System.out.println("################################################");
                    System.out.println("       The result of " + firstNumber + " - " + secondNumber + " is: " + result);
                    System.out.println("################################################");
                    break;
                case "multiplication":
                case "multiplicar":
                case "multiplicacion":
                    System.out.println(" ");
                    System.out.println("################################################");
                    System.out.println("       The result of " + firstNumber + " * " + secondNumber + " is: " + result);
                    System.out.println("################################################");
                    break;
                case "division":
                case "dividir":
                    System.out.println(" ");
                    System.out.println("################################################");
                    System.out.println("       The result of " + firstNumber + " / " + secondNumber + " is: " + result);
                    System.out.println("################################################");
                    break;
                case "remainder":
                case "resto":
                    System.out.println(" ");
                    System.out.println("################################################");
                    System.out.println("       The result of " + firstNumber + " % " + secondNumber + " is: " + result);
                    System.out.println("################################################");
                    break;
                default:
                    System.out.println("Oops! Something went wrong :(");
                    break;
            }

            System.out.println(" ");

            /*Una vez finalizada la operación se pide al usuario si quiere volver a realizar otra operación*/
            System.out.println("------------------------------------------------");
            System.out.println("    Do you want to calculate something else?    ");
            System.out.println("------------------------------------------------");
            System.out.println("Chose one operation or shutdown:");
            operation = Util.askOperation();
        }

        System.out.println(" ");

        /*Mensaje que se mostrará al apagar la calculadora*/
        System.out.println("************************************************");
        System.out.println("*      To much maths for today? See you!       *");
        System.out.println("************************************************");
    }
}
