package com.calculator;

import com.calculator.data.PossibleOperations;
import com.calculator.service.Util;

public class CalculatorApp {
    public static void main(String[] args) throws Exception {
        System.out.println("\u001B[36m************************************************\u001B[0m");
        System.out.println("\u001B[36m*     Welcome to the best calculator app!      *\u001B[0m");
        System.out.println("\u001B[36m************************************************\u001B[0m");

        System.out.println(" ");

        /*Do-while mediante el que se le pedirá al usuario qué operación quiere realizar de las disponibles*/
        String operation;
        do {
            System.out.println("------------------------------------------------");
            System.out.println("        \u001B[36mYou can do this five operations\u001B[0m");
            System.out.println("------------------------------------------------");
            System.out.println("+----------------------------------------------+");
            System.out.println("|                \u001B[31mAddition (+)\u001B[0m                  |");
            System.out.println("|                \u001B[32mSubtraction (-)\u001B[0m               |");
            System.out.println("|                \u001B[33mMultiplication (*)\u001B[0m            |");
            System.out.println("|                \u001B[34mDivision (/)\u001B[0m                  |");
            System.out.println("|                \u001B[35mRemainder (%)\u001B[0m                 |");
            System.out.println("|                Shutdown :(                   |");
            System.out.println("+----------------------------------------------+");
            System.out.println("Choose one:");

            operation = Util.askOperation();

            if (!Util.isAValidOperationInput(operation)) {
                System.out.println("\u001B[41mError: Not a valid operation\u001B[0m");
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
                System.out.println("                 \u001B[36mWrite a number\u001B[0m");
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
                        System.out.println(" Which number would you like to \u001B[31madd\u001B[0m to " + firstNumber + "?");
                        System.out.println("------------------------------------------------");
                        secondNumber = Util.askNumber();
                        break;
                    case "subtraction":
                    case "restar":
                    case "resta":
                        System.out.println(" ");
                        System.out.println("------------------------------------------------");
                        System.out.println(" Which number would you like to \u001B[32msubtract\u001B[0m to " + firstNumber + "?");
                        System.out.println("------------------------------------------------");
                        secondNumber = Util.askNumber();
                        break;
                    case "multiplication":
                    case "multiplicar":
                    case "multiplicacion":
                        System.out.println(" ");
                        System.out.println("------------------------------------------------");
                        System.out.println("Which number would you like to \u001B[33mmultiply\u001B[0m by " + firstNumber + "?");
                        System.out.println("------------------------------------------------");
                        secondNumber = Util.askNumber();
                        break;
                    case "division":
                    case "dividir":
                        do {
                            System.out.println(" ");
                            System.out.println("------------------------------------------------");
                            System.out.println(" By which number would you like to \u001B[34mdivide\u001B[0m " + firstNumber + "?");
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
                        System.out.println(" \u001B[35mreminder\u001B[0m when dividing " + firstNumber + "?");
                        System.out.println("------------------------------------------------");
                        secondNumber = Util.askNumber();
                        break;
                    default:
                        System.out.println("\u001B[47m\u001B[31mOops! Something went wrong :(\u001B[0m");
                        break;
                }

                if (!Util.isAValidNumberInput(firstNumber) || !Util.isAValidNumberInput(secondNumber)) {
                    System.out.println("\u001B[41mError: Not a valid number\u001B[0m");
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
                    System.out.println("       The result of " + firstNumber + " \u001B[31m+\u001B[0m " + secondNumber + " is: " + result);
                    System.out.println("################################################");
                    break;
                case "subtraction":
                case "restar":
                case "resta":
                    System.out.println(" ");
                    System.out.println("################################################");
                    System.out.println("       The result of " + firstNumber + " \u001B[32m-\u001B[0m " + secondNumber + " is: " + result);
                    System.out.println("################################################");
                    break;
                case "multiplication":
                case "multiplicar":
                case "multiplicacion":
                    System.out.println(" ");
                    System.out.println("################################################");
                    System.out.println("       The result of " + firstNumber + " \u001B[33m*\u001B[0m " + secondNumber + " is: " + result);
                    System.out.println("################################################");
                    break;
                case "division":
                case "dividir":
                    System.out.println(" ");
                    System.out.println("################################################");
                    System.out.println("       The result of " + firstNumber + " \u001B[34m/\u001B[0m " + secondNumber + " is: " + result);
                    System.out.println("################################################");
                    break;
                case "remainder":
                case "resto":
                    System.out.println(" ");
                    System.out.println("################################################");
                    System.out.println("       The result of " + firstNumber + " \u001B[35m%\u001B[0m " + secondNumber + " is: " + result);
                    System.out.println("################################################");
                    break;
                default:
                    System.out.println("\u001B[47m\u001B[31mOops! Something went wrong :(\u001B[0m");
                    break;
            }

            System.out.println(" ");
            do {
                /*Una vez finalizada la operación se pide al usuario si quiere volver a realizar otra operación*/
                System.out.println("------------------------------------------------");
                System.out.println("    \u001B[36mDo you want to calculate something else?\u001B[0m");
                System.out.println("------------------------------------------------");
                System.out.println("Chose one operation or shutdown:");
                operation = Util.askOperation();
                if (!Util.isAValidOperationInput(operation)) {
                    System.out.println("\u001B[41mError: Not a valid operation\u001B[0m");
                    System.out.println(" ");
                }
            } while (!Util.isAValidOperationInput(operation));
        }

        System.out.println(" ");

        /*Mensaje que se mostrará al apagar la calculadora*/
        System.out.println("\u001B[36m************************************************\u001B[0m");
        System.out.println("\u001B[36m*      To much maths for today? See you!       *\u001B[0m");
        System.out.println("\u001B[36m************************************************\u001B[0m");
    }
}
