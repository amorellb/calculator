package com.calculator;

import com.calculator.service.Util;

public class CalculatorApp {
    public static void main(String[] args) throws Exception {
        System.out.println("************************************************");
        System.out.println("*     Welcome to the best calculator app!      *");
        System.out.println("************************************************");

        System.out.println(" ");

        System.out.println("------------------------------------------------");
        System.out.println("        You can do this five operations         ");
        System.out.println("------------------------------------------------");
        System.out.println("Addition (+)");
        System.out.println("Subtraction (-)");
        System.out.println("Multiplication (*)");
        System.out.println("Division (/)");
        System.out.println("Remainder (%)");

        System.out.println(" ");

        System.out.println("------------------------------------------------");
        System.out.println("   Do you want to do some calculations? (y/n)   ");
        System.out.println("------------------------------------------------");
        String isCalculating = Util.askOperation();

        while (isCalculating.equals("y")) {
            System.out.println(" ");

            String operation;
            do {
                System.out.println("------------------------------------------------");
                System.out.println("     Which operation would you like to do?      ");
                System.out.println("------------------------------------------------");
                operation = Util.askOperation();

                if (!Util.isAValidOperationInput(operation)) {
                    System.out.println("Error: Not a valid operation");
                    System.out.println(" ");
                }
            } while (!Util.isAValidOperationInput(operation));

            double firstNumber;
            double secondNumber = 0.0;
            do {
                System.out.println(" ");

                System.out.println("------------------------------------------------");
                System.out.println("                 Write a number                 ");
                System.out.println("------------------------------------------------");
                firstNumber = Util.askNumber();

                switch (operation) {
                    case "addition":
                        System.out.println(" ");
                        System.out.println("------------------------------------------------");
                        System.out.println(" Which number would you like to add to " + firstNumber + "?");
                        System.out.println("------------------------------------------------");
                        secondNumber = Util.askNumber();
                        break;
                    case "subtraction":
                        System.out.println(" ");
                        System.out.println("------------------------------------------------");
                        System.out.println(" Which number would you like to subtract to " + firstNumber + "? ");
                        System.out.println("------------------------------------------------");
                        secondNumber = Util.askNumber();
                        break;
                    case "multiplication":
                        System.out.println(" ");
                        System.out.println("------------------------------------------------");
                        System.out.println("Which number would you like to multiply by " + firstNumber + "?");
                        System.out.println("------------------------------------------------");
                        secondNumber = Util.askNumber();
                        break;
                    case "division":
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

            Double result = Util.doOperation(operation, firstNumber, secondNumber);

            switch (operation) {
                case "addition":
                    System.out.println(" ");
                    System.out.println("################################################");
                    System.out.println("       The result of " + firstNumber + " + " + secondNumber + " is: " + result);
                    System.out.println("################################################");
                    break;
                case "subtraction":
                    System.out.println(" ");
                    System.out.println("################################################");
                    System.out.println("       The result of " + firstNumber + " - " + secondNumber + " is: " + result);
                    System.out.println("################################################");
                    break;
                case "multiplication":
                    System.out.println(" ");
                    System.out.println("################################################");
                    System.out.println("       The result of " + firstNumber + " * " + secondNumber + " is: " + result);
                    System.out.println("################################################");
                    break;
                case "division":
                    System.out.println(" ");
                    System.out.println("################################################");
                    System.out.println("       The result of " + firstNumber + " / " + secondNumber + " is: " + result);
                    System.out.println("################################################");
                    break;
                case "remainder":
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

            System.out.println("------------------------------------------------");
            System.out.println(" Do you want to calculate something else? (y/n) ");
            System.out.println("------------------------------------------------");
            isCalculating = Util.askOperation();
        }

        System.out.println(" ");

        System.out.println("************************************************");
        System.out.println("*      To much maths for today? See you!       *");
        System.out.println("************************************************");
    }
}
