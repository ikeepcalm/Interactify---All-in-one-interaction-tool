package dev.ikeepcalm.interactify.handlers;

import dev.ikeepcalm.interactify.interfaces.IntegerInterface;

import java.util.Scanner;

public class IntegerHandler implements IntegerInterface {

    private final Scanner scanner;

    public IntegerHandler(Scanner scanner){
        this.scanner = scanner;
    }

    @Override
    public int askForInteger(String prompt) {
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

    @Override
    public int askForIntegerInRange(String prompt, int min, int max) {
        int input;
        do {
            input = askForInteger(prompt);
        } while (input < min || input > max);
        return input;
    }

    @Override
    public long calculateFactorial(int number) {
        if (number < 0) {
            throw new IllegalArgumentException("Factorial is undefined for negative numbers.");
        }
        long factorial = 1;
        for (int i = 2; i <= number; i++) {
            factorial *= i;
        }
        return factorial;
    }

    @Override
    public boolean isPrime(int number) {
        if (number <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean isOdd(int number) {
        return number % 2 != 0;
    }

    @Override
    public boolean isEven(int number) {
        return number % 2 == 0;
    }

    @Override
    public int calculateSumOfDigits(int number) {
        int sum = 0;
        while (number != 0) {
            sum += number % 10;
            number /= 10;
        }
        return sum;
    }

    @Override
    public int reverseDigits(int number) {
        int reversedNumber = 0;
        while (number != 0) {
            int digit = number % 10;
            reversedNumber = reversedNumber * 10 + digit;
            number /= 10;
        }
        return reversedNumber;
    }

}
