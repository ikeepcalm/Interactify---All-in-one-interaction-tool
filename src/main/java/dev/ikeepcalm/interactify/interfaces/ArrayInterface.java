package dev.ikeepcalm.interactify.interfaces;

public interface ArrayInterface {
    int[] askForIntArray(String prompt, int size);

    boolean isSortedAscending(int[] array);

    int[] reverseArray(int[] array);
}
