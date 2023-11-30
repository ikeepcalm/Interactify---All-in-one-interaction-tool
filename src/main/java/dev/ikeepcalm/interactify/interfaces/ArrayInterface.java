package dev.ikeepcalm.interactify.interfaces;

public interface ArrayInterface {
    int[] askForIntArray(String prompt, int size);

    int[] askForIntArray(String prompt, int size, int min, int max);

    String[] askForStringArray(String prompt, int size, int minLength, int maxLength);

    boolean isSortedAscending(int[] array);

    int[] reverseArray(int[] array);
}
