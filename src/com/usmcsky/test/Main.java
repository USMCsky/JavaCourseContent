package com.usmcsky.test;

public class Main {

    static void main(String[] args) {
        String question = "What is your name?";
        String response = IO.readln(question);
        IO.println(response);

        System.out.println("Hello World!");

        //Variables - primitive datatypes
        int number = 5;
        double decNumber = number;
        boolean  bool = true;
        char letter = 'A';

        IO.println(number);
        IO.println(decNumber);
        IO.println(bool);
        IO.println(letter);

        //Variables non-primitive types (wrappers)
        Integer number2 = 1;
        Double double2 = 2.0;
        Boolean bool2 = false;
        Character char22 = 'D';

        int result = printMessage("TEST");
        System.out.println(result);
    }

    private static int printMessage(String message) {
        System.out.println(message);
        return 10000000;




        
    }
}
