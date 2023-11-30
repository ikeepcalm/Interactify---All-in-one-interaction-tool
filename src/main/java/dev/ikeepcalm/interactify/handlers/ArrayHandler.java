package dev.ikeepcalm.interactify.handlers;

import dev.ikeepcalm.interactify.interfaces.ArrayInterface;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayHandler implements ArrayInterface {

    private final Scanner scanner;

    public ArrayHandler(Scanner scanner){
        this.scanner = scanner;
    }

    @Override
    public int[] askForIntArray(String prompt, int size) {
        int[] array = new int[size];
        System.out.println(prompt);

        for (int i = 0; i < size; i++) {
            array[i] = askForIndexElement("Enter element at index " + i + ": ");
        }

        return array;
    }

    @Override
    public int[] askForIntArray(String prompt, int size, int min, int max) {
        int[] array = new int[size];
        System.out.println(prompt);

        for (int i = 0; i < size; i++) {
            array[i] = askForIndexElement("Enter element at index " + i + ": ", min, max);
        }

        return array;
    }

    @Override
    public String[] askForStringArray(String prompt, int size, int minLength, int maxLength) {
        String[] array = new String[size];
        System.out.println(prompt);

        for (int i = 0; i < size; i++) {
            array[i] = askForStringWithLengthRange("Enter element at index " + i + ": ", minLength, maxLength);
        }

        return array;
    }



    @Override
    public boolean isSortedAscending(int[] array) {
        int[] sortedArray = Arrays.copyOf(array, array.length);
        Arrays.sort(sortedArray);
        return Arrays.equals(array, sortedArray);
    }

    @Override
    public int[] reverseArray(int[] array) {
        int[] reversedArray = new int[array.length];
        for (int i = 0, j = array.length - 1; i < array.length; i++, j--) {
            reversedArray[i] = array[j];
        }
        return reversedArray;
    }

    private int askForIndexElement(String prompt) {
        int input;
        do {
            System.out.print(prompt);
            while (!scanner.hasNextInt()) {
                System.out.println("Invalid input. Please enter a valid integer.");
                scanner.next();
            }
            input = scanner.nextInt();
            scanner.nextLine();
        } while (input <= Integer.MIN_VALUE || input >= Integer.MAX_VALUE);
        return input;
    }

    private int askForIndexElement(String prompt, int min, int max) {
        int input;
        do {
            System.out.print(prompt);
            while (!scanner.hasNextInt()) {
                System.out.println("Invalid input. Please enter a valid integer.");
                scanner.next();
            }
            input = scanner.nextInt();
            scanner.nextLine();
        } while (input <= min || input >= max);
        return input;
    }


    private String askForStringWithLengthRange(String prompt, int minLength, int maxLength) {
        String input;
        do {
            System.out.print(prompt);
            input = scanner.nextLine().trim();
            if (input.length() < minLength || input.length() > maxLength) {
                System.out.println("Invalid input. Please enter a string within the specified length range.");
            }
        } while (input.length() < minLength || input.length() > maxLength);

        return input;
    }


}
