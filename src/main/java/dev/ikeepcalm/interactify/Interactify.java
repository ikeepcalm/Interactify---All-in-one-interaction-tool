package dev.ikeepcalm.interactify;

import dev.ikeepcalm.interactify.handlers.*;
import dev.ikeepcalm.interactify.interfaces.*;

import java.util.Scanner;

public class Interactify {

    protected Scanner scanner;
    public final ArrayInterface arrayHandler;
    public final DoubleInterface doubleHandler;
    public final IntegerInterface integerHandler;
    public final StringInterface stringHandler;
    public final EquationsInterface equationsHandler;

    public Interactify(Scanner scanner){
        this.scanner = new Scanner(System.in);
        this.arrayHandler = new ArrayHandler(scanner);
        this.doubleHandler = new DoubleHandler(scanner);
        this.integerHandler = new IntegerHandler(scanner);
        this.stringHandler = new StringHandler(scanner);
        this.equationsHandler = new EquationsHandler(scanner);
    }

}
