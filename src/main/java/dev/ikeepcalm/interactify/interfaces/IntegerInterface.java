package dev.ikeepcalm.interactify.interfaces;

public interface IntegerInterface {

    int askForInteger(String prompt);

    int askForIntegerInRange(String prompt, int min, int max);

    long calculateFactorial(int number);

    boolean isPrime(int number);

    boolean isOdd(int number);

    boolean isEven(int number);

    int calculateSumOfDigits(int number);

    int reverseDigits(int number);
}
