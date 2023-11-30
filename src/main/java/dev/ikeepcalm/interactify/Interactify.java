package dev.ikeepcalm.interactify;

import dev.ikeepcalm.interactify.handlers.ArrayHandler;
import dev.ikeepcalm.interactify.handlers.DoubleHandler;
import dev.ikeepcalm.interactify.handlers.IntegerHandler;
import dev.ikeepcalm.interactify.handlers.StringHandler;
import dev.ikeepcalm.interactify.interfaces.ArrayInterface;
import dev.ikeepcalm.interactify.interfaces.DoubleInterface;
import dev.ikeepcalm.interactify.interfaces.IntegerInterface;
import dev.ikeepcalm.interactify.interfaces.StringInterface;

import java.util.Scanner;

public class Interactify implements StringInterface, DoubleInterface, IntegerInterface, ArrayInterface {

    protected Scanner scanner;
    private final ArrayInterface arrayHandler;
    private final DoubleInterface doubleHandler;
    private final IntegerInterface integerHandler;
    private final StringInterface stringHandler;

    public Interactify(Scanner scanner){
        this.scanner = new Scanner(System.in);
        this.arrayHandler = new ArrayHandler(scanner);
        this.doubleHandler = new DoubleHandler(scanner);
        this.integerHandler = new IntegerHandler(scanner);
        this.stringHandler = new StringHandler(scanner);
    }


    @Override
    public int[] askForIntArray(String prompt, int size) {
        return arrayHandler.askForIntArray(prompt, size);
    }

    @Override
    public int[] askForIntArray(String prompt, int size, int min, int max) {
        return arrayHandler.askForIntArray(prompt, size, min, max);
    }

    @Override
    public String[] askForStringArray(String prompt, int size, int minLength, int maxLength) {
        return arrayHandler.askForStringArray(prompt, size, minLength, maxLength);
    }

    @Override
    public boolean isSortedAscending(int[] array) {
        return arrayHandler.isSortedAscending(array);
    }

    @Override
    public int[] reverseArray(int[] array) {
        return arrayHandler.reverseArray(array);
    }

    @Override
    public double askForDouble(String prompt) {
        return doubleHandler.askForDouble(prompt);
    }

    @Override
    public double askForDoubleInRange(String prompt, double min, double max) {
        return doubleHandler.askForDoubleInRange(prompt, min, max);
    }

    @Override
    public double roundToDecimalPlaces(double value, int decimalPlaces) {
        return doubleHandler.roundToDecimalPlaces(value, decimalPlaces);
    }

    @Override
    public double askForDoubleWithDecimalLimit(String prompt, int decimalPlaces) {
        return doubleHandler.askForDoubleWithDecimalLimit(prompt, decimalPlaces);
    }

    @Override
    public String convertToScientificNotation(double value, int decimalPlaces) {
        return doubleHandler.convertToScientificNotation(value, decimalPlaces);
    }

    @Override
    public int askForInteger(String prompt) {
        return integerHandler.askForInteger(prompt);
    }

    @Override
    public int askForIntegerInRange(String prompt, int min, int max) {
        return integerHandler.askForIntegerInRange(prompt, min, max);
    }

    @Override
    public long calculateFactorial(int number) {
        return integerHandler.calculateFactorial(number);
    }

    @Override
    public boolean isPrime(int number) {
        return integerHandler.isPrime(number);
    }

    @Override
    public boolean isOdd(int number) {
        return integerHandler.isOdd(number);
    }

    @Override
    public boolean isEven(int number) {
        return integerHandler.isEven(number);
    }

    @Override
    public int calculateSumOfDigits(int number) {
        return integerHandler.calculateSumOfDigits(number);
    }

    @Override
    public int reverseDigits(int number) {
        return integerHandler.reverseDigits(number);
    }

    @Override
    public String askForNonEmptyString(String prompt) {
        return stringHandler.askForNonEmptyString(prompt);
    }

    @Override
    public String askForStringWithLengthRange(String prompt, int minLength, int maxLength) {
        return stringHandler.askForStringWithLengthRange(prompt, minLength, maxLength);
    }

    @Override
    public String askForStringFromOptions(String prompt, String[] options) {
        return stringHandler.askForStringFromOptions(prompt, options);
    }

    @Override
    public String askForAlphabeticString(String prompt) {
        return stringHandler.askForAlphabeticString(prompt);
    }

    @Override
    public String askForStringWithMaxLength(String prompt, int maxLength) {
        return stringHandler.askForStringWithMaxLength(prompt, maxLength);
    }

    @Override
    public String askForDate(String prompt) {
        return stringHandler.askForDate(prompt);
    }

    @Override
    public boolean askForYesNoConfirmation(String prompt) {
        return stringHandler.askForYesNoConfirmation(prompt);
    }
}
