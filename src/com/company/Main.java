package com.company;

public class Main {

    public static void main(String[] args) {
        if (args.length == 2) {
            CSVWriter.writeFileFunction(args[0], args[1]);

        } else {
            System.out.println("Unrecognised input!");
        }
    }

}