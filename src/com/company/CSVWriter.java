package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

import static java.util.Comparator.comparing;

public class CSVWriter {

    public static List<Person> readCsv(String input) {
        List<Person> people = new ArrayList<>();
        try {
            Scanner scanner = new Scanner(new File(input));
            scanner.useDelimiter("\\n");
            while (scanner.hasNext()) {
                String[] scannerLine = scanner.next().split(",");

                // first value of scanner line is always name, second is always age
                Person person = new Person(scannerLine[0], Integer.parseInt(scannerLine[1].trim()));
                people.add(person);
            }
            scanner.close();

            sortPeople(people);

            return people;

        } catch (FileNotFoundException error) {
            System.out.println("Couldn't find the file '" + input + "' check spelling and try again?");
        }

        return new ArrayList<>();
    }

    public static void writeFileToCsv(List<Person> people, String output) {

        if (people.size() > 0) {

            try {
                FileWriter outputWriter = new FileWriter(output);
                for (Person person : people) {
                    outputWriter.write(person.getName());
                    outputWriter.write(",");
                    outputWriter.write(String.valueOf(person.getAge()));
                    outputWriter.write("\n");
                }
                outputWriter.close();
                System.out.println("File successfully sorted!");

            } catch (IOException error) {
                System.out.println("There was an error while writing to file! " + error);
            }
        } else {
            System.out.println("There is no content to write!");
        }

    }

    private static void sortPeople(List<Person> people) {
        System.out.println("Original Unsorted Data: " + people);
        people.sort(comparing(Person::getName).thenComparing(Person::getAge));
        System.out.println("Post-sort Data: " + people);
    }
}






