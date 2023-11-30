package dev.ikeepcalm.interactify;

import java.util.Arrays;
import java.util.Scanner;

import static dev.ikeepcalm.interactify.IntegerHandler.askForInteger;

public class ArrayHandler {

    public static int[] askForIntArray(String prompt, int size) {
        int[] array = new int[size];
        System.out.println(prompt);

        for (int i = 0; i < size; i++) {
            array[i] = askForInteger("Enter element at index " + i + ": ");
        }

        return array;
    }

    public static boolean isSortedAscending(int[] array) {
        int[] sortedArray = Arrays.copyOf(array, array.length);
        Arrays.sort(sortedArray);
        return Arrays.equals(array, sortedArray);
    }

    public static int[] reverseArray(int[] array) {
        int[] reversedArray = new int[array.length];
        for (int i = 0, j = array.length - 1; i < array.length; i++, j--) {
            reversedArray[i] = array[j];
        }
        return reversedArray;
    }

}
