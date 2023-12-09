package dev.ikeepcalm.interactify;

import dev.ikeepcalm.interactify.handlers.*;
import dev.ikeepcalm.interactify.interfaces.*;

import java.util.Arrays;
import java.util.Scanner;

public class Interactify {

    private final ArrayInterface arrayHandler;
    private final DoubleInterface doubleHandler;
    private final IntegerInterface integerHandler;
    private final StringInterface stringHandler;
    private final EquationsInterface equationsHandler;

    public Interactify(Scanner scanner){
        this.arrayHandler = new ArrayHandler(scanner);
        this.doubleHandler = new DoubleHandler(scanner);
        this.integerHandler = new IntegerHandler(scanner);
        this.stringHandler = new StringHandler(scanner);
        this.equationsHandler = new EquationsHandler(scanner);
    }

    public ArrayInterface useArrayHandler() {
        return arrayHandler;
    }

    public DoubleInterface useDoubleHandler() {
        return doubleHandler;
    }

    public IntegerInterface useIntegerHandler() {
        return integerHandler;
    }

    public StringInterface useStringHandler() {
        return stringHandler;
    }

    public EquationsInterface useEquationsHandler() {
        return equationsHandler;
    }

}
