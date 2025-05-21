package com.pluralsight.streams;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Program {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayList<Person> listOfNames = new ArrayList<>();

        listOfNames.add(new Person("Lucas", " Henry ", 16));
        listOfNames.add(new Person("Lindsay", "Burton", 16));
        listOfNames.add(new Person("Isaiah", "Jackson", 18));
        listOfNames.add(new Person("Reinhard", "Astrea", 20));
        listOfNames.add(new Person("Gojo", "Satoru", 25));
        listOfNames.add(new Person("Jody", "Olsen", 47));
        listOfNames.add(new Person("Subaru", "Natsuki", 19));
        listOfNames.add(new Person("Sasuke", "Uchiha", 29));
        listOfNames.add(new Person("Rick", "Grimes", 40));
        listOfNames.add(new Person("Luffy", "Monkey.D", 21));
        listOfNames.add(new Person("Daryl", "Nixon", 39));

        System.out.print("Look up a name (First Or Last): ");

        String inputName = scanner.nextLine().trim();

        ArrayList<Person> matches = listOfNames.stream()
                .filter(p -> p.getFirstName().equalsIgnoreCase(inputName) || p.getLastName().equalsIgnoreCase(inputName))
                .collect(Collectors.toCollection(ArrayList<Person>::new));

        matches.forEach(System.out::println);

    }

    public static double getAvgAge(ArrayList<Person> listOfNames) {
        return listOfNames.stream()
                .mapToInt(Person::getAge)
                .average()
                .orElse(0);
    }


}
