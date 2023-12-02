package dev.ikeepcalm.interactify.handlers;

import dev.ikeepcalm.interactify.interfaces.StringInterface;

import java.util.Arrays;
import java.util.Scanner;

public class StringHandler implements StringInterface {

    private final Scanner scanner;

    public StringHandler(Scanner scanner){
        this.scanner = scanner;
    }

    @Override
    public String askForNonEmptyString(String prompt) {
        String input;
        do {
            System.out.print(prompt);
            input = scanner.nextLine().trim();
        } while (input.isEmpty());
        return input;
    }

    @Override
    public String askForStringWithLengthRange(String prompt, int minLength, int maxLength) {
        String input;
        do {
            System.out.print(prompt);
            input = scanner.nextLine().trim();
        } while (input.length() < minLength || input.length() > maxLength);
        return input;
    }

    @Override
    public String askForStringFromOptions(String prompt, String[] options) {
        String input;
        do {
            System.out.print(prompt);
            input = scanner.nextLine().trim();
        } while (!Arrays.asList(options).contains(input));
        return input;
    }

    @Override
    public String askForAlphabeticString(String prompt) {
        String input;
        do {
            System.out.print(prompt);
            input = scanner.nextLine().trim();
        } while (!input.matches("[a-zA-Z]+"));
        return input;
    }

    @Override
    public String askForStringWithMaxLength(String prompt, int maxLength) {
        String input;
        do {
            System.out.print(prompt);
            input = scanner.nextLine().trim();
        } while (input.length() > maxLength);
        return input;
    }

    @Override
    public String askForDate(String prompt) {
        String date;
        do {
            System.out.print(prompt + " (YYYY-MM-DD): ");
            date = scanner.nextLine().trim();
        } while (!date.matches("\\d{4}-\\d{2}-\\d{2}"));
        return date;
    }

    @Override
    public boolean askForYesNoConfirmation(String prompt) {
        String input;
        do {
            System.out.print(prompt + " (yes/no): ");
            input = scanner.nextLine().trim().toLowerCase();
        } while (!input.equals("yes") && !input.equals("no"));
        return input.equals("yes");
    }

}
