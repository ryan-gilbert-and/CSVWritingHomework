package com.company;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        if (args.length == 2) {
            // read csv contents in a list of Person Objects
            List<Person> people = CSVWriter.readCsv(args[0]);

            // write people objects to output file
            CSVWriter.writeFileToCsv(people, args[1]);

        } else {
            System.out.println("Unrecognised input!");
        }
    }

}