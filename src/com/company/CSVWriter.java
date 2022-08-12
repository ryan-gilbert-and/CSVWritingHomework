package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

import static java.util.Comparator.comparing;

public class CSVWriter {

    public static void writeFileFunction(String input, String output) {
        List<Person> people = new ArrayList<>();
        try {
            Scanner scanner = new Scanner(new File(input));
            scanner.useDelimiter("\\n");
            while (scanner.hasNext()) {
                String scannerLine[] = scanner.next().split(",");
                Person person = new Person(scannerLine[0], Integer.parseInt(scannerLine[1].trim()));
                people.add(person);
            }
            scanner.close();

            System.out.println("Original Unsorted Data: " + people);
            Collections.sort(people, comparing(Person::getName).thenComparing(Person::getAge));
            System.out.println("Post-sort Data: " + people);

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

        } catch (FileNotFoundException error) {
            System.out.println("Couldn't find the file '" + input + "' check spelling and try again?");
        }
    }
}
