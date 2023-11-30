package dev.ikeepcalm.interactify.interfaces;

public interface DoubleInterface {
    double askForDouble(String prompt);
    double askForDoubleInRange(String prompt, double min, double max);
    double roundToDecimalPlaces(double value, int decimalPlaces);
    double askForDoubleWithDecimalLimit(String prompt, int decimalPlaces);

    String convertToScientificNotation(double value, int decimalPlaces);
}
