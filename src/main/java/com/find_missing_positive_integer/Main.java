package com.find_missing_positive_integer;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

/**
 * for taking input from user.
 */
final class Main {
    /**
     * for taking input from user.
     * @param args to take input from command line.
     */
    public static void main(final String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            List<Integer> arrayOfIntegers = new ArrayList<>();
            char choice = 'y';
            while (choice == 'y') {
                System.out.print("\nEnter element "
                        + (arrayOfIntegers.size() + 1)
                        + ": ");
                arrayOfIntegers.add(scanner.nextInt());
                System.out.print("\nDo you want to continue? y/n: ");
                choice = scanner.next().charAt(0);
                while (choice != 'y' && choice != 'n') {
                    System.out.print("\nWrong input " + choice
                            + "\nDo you want to continue? y/n: ");
                    choice = scanner.next().charAt(0);
                }
            }
            System.out.println("\n Array: " + arrayOfIntegers);
            FindMissingPositiveInteger findMissingPositiveInteger
                    = new FindMissingPositiveInteger();
            System.out.println("Minimum Number: " + findMissingPositiveInteger
                    .findMissingPositiveInteger(arrayOfIntegers));
        } catch (InputMismatchException exception) {
            System.out.println("Input does not match."
                    + "\nEnter integer only. \n"
                    + exception);
        } catch (Exception exception) {
            System.out.println("Error occur " + exception);
        }
    }
    private Main() {
        // to remove
        //Utility classes should not have a public or default constructor.
    }
}
