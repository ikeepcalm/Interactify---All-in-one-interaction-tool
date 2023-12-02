package dev.ikeepcalm.interactify.handlers;

import dev.ikeepcalm.interactify.interfaces.EquationsInterface;
import dev.ikeepcalm.interactify.interfaces.IntegerInterface;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EquationsHandler  implements EquationsInterface {

    private final Scanner scanner;

    public EquationsHandler(Scanner scanner){
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
        System.out.println("Caution! Input x should have unique number after (e.g. x1 + x2 + x3 + ...)\nOtherwise it will be considered as next variable and might impact calculations!\n");
        for (int i = 0; i < numberOfEquations; i++) {
            String equation;
            do {
                equation = askForNonEmptyString("Enter the " + (i + 1) + "-th equation in the form of ax1 + bx2 + ... + nxk = b: \n");
            } while (!isValidEquationFormat(equation));

            double[] coefficients = parseEquation(equation);
            matrix[i] = coefficients;
        }
        return matrix;
    }

    private boolean isValidEquationFormat(String equation) {
        String regex = "^\\s*(([+-]?\\s*\\d*\\.?\\d*\\s*\\*?\\s*x\\d+\\s*)[+-]\\s*)*([+-]?\\s*\\d*\\.?\\d*\\s*\\*?\\s*x\\d+)\\s*=\\s*([+-]?\\s*\\d*\\.?\\d+)\\s*$";
        return equation.matches(regex);
    }


    public double[] parseEquation(String equation) {
        equation = equation.replaceAll("\\s+", "");
        String[] parts = equation.split("=");
        String left = parts[0];
        String right = parts[1];
        int numVariables = countVariables(left);
        double[] coefficients = new double[numVariables + 1];

        for (int i = 1; i <= numVariables; i++) {
            coefficients[i - 1] = getCoefficient(left, "x" + i);
        }

        coefficients[numVariables] = Double.parseDouble(right);

        return coefficients;
    }



    public double getCoefficient(String left, String var) {
        double coefficient = 0;
        Pattern pattern = Pattern.compile("([-+]?\\d*\\.?\\d*)\\*?" + var);
        Matcher matcher = pattern.matcher(left);
        if (matcher.find()) {
            String coef = matcher.group(1);
            if (coef.isEmpty() || coef.equals("+")) {
                coefficient = 1;
            }
            else if (coef.equals("-")) {
                coefficient = -1;
            }
            else {
                coefficient = Double.parseDouble(coef);
            }
        }
        return coefficient;
    }

    private int countVariables(String equation) {
        Pattern pattern = Pattern.compile("([-+]?\\d*\\.?\\d*)\\*?x\\d+");
        Matcher matcher = pattern.matcher(equation);
        int count = 0;
        while (matcher.find()) {
            count++;
        }
        return count;
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
