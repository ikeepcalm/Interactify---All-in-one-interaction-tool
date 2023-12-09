package dev.ikeepcalm.interactify.handlers;

import dev.ikeepcalm.interactify.interfaces.EquationsInterface;
import dev.ikeepcalm.interactify.interfaces.IntegerInterface;

import java.util.Scanner;

public class EquationsHandler implements EquationsInterface {

    private final Scanner scanner;

    public EquationsHandler(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public double[][] askForSlae(String prompt, int min, int max) {
        IntegerInterface integerInterface = new IntegerHandler(scanner);
        int numberOfEquations;
        do {
            numberOfEquations = integerInterface.askForIntegerInRange(prompt, min, max);
        } while (numberOfEquations <= 0);

        double[][] matrix = new double[numberOfEquations][];
        System.out.println("Enter the equations in the form of \"2x + 4x - 5x + 1x = 0\": \n");
        for (int i = 0; i < numberOfEquations; i++) {
            String equation;
            do {
                equation = askForNonEmptyString("Enter the " + (i + 1) + "-th equation: ");
            } while (!isValidEquationFormat(equation));

            double[] coefficients = parseEquation(equation);
            matrix[i] = coefficients;
        }
        return matrix;
    }

    private boolean isValidEquationFormat(String equation) {
        if (equation.matches("([+-]?\\d*\\.?\\d*)x([+-]\\d*\\.?\\d*x)*=\\d+")) {
            return true;
        } else {
            System.out.println("The equation does not follow the correct format. Please try again!");
            return false;
        }
    }

    public double[] parseEquation(String equation) {
        equation = equation.replaceAll("\\s+", "");
        String[] terms = equation.split("[=]")[0].split("([+-]?\\d*\\.?\\d*)x");

        double[] coefficients = new double[terms.length];

        for (int i = 0; i < terms.length; i++) {
            coefficients[i] = terms[i].isEmpty() ? 1 : Double.parseDouble(terms[i]);
        }

        return coefficients;
    }

    private String askForNonEmptyString(String prompt) {
        String input;
        do {
            System.out.print(prompt);
            input = scanner.nextLine().trim();
        } while (input.isEmpty());
        return input;
    }
}
