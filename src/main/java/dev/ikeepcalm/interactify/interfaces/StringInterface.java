package dev.ikeepcalm.interactify.interfaces;

public interface StringInterface {

    String askForNonEmptyString(String prompt);

    String askForStringWithLengthRange(String prompt, int minLength, int maxLength);

    String askForStringFromOptions(String prompt, String[] options);

    String askForAlphabeticString(String prompt);

    String askForStringWithMaxLength(String prompt, int maxLength);

    String askForDate(String prompt);

    boolean askForYesNoConfirmation(String prompt);
}
