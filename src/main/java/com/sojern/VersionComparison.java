package com.sojern;

import com.sojern.service.VersionComparator;
import com.sojern.service.VersionValidator;

import java.util.Scanner;

public class VersionComparison {

    public static void main(String[] args) {
        final Scanner scr = new Scanner(System.in);
        VersionValidator versionValidator = new VersionValidator();
        VersionComparator versionComparator = new VersionComparator();
        String quit;
        String firstVersion;
        String secondVersion;
        String[] firstVersionArray = new String[0];
        String[] secondVersionArray = new String[0];
        int result = 0;
        boolean userInput = false;

        do {
            while (!userInput) {
                try {
                    System.out.println("Enter first version: ");
                    firstVersion = scr.nextLine();
                    firstVersionArray = versionValidator.validateVersion(firstVersion);
                    userInput = true;
                } catch (IllegalArgumentException exception) {
                    System.out.println("That wasn't a valid version: " + exception.getMessage());
                }
            }
            userInput = false;
            while (!userInput) {
                try {
                    System.out.println("Enter second Version: ");
                    secondVersion = scr.nextLine();
                    secondVersionArray = versionValidator.validateVersion(secondVersion);
                    userInput = true;
                } catch (IllegalArgumentException exception) {
                    System.out.println("That wasn't a valid version: " + exception.getMessage());
                }
            }
            userInput = false;
            try {
                result = versionComparator.getComparisonValue(firstVersionArray, secondVersionArray);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
            System.out.println("result: " + result);
            System.out.println("To quit press N, to continue press any key");
            quit = scr.nextLine();
        } while (!quit.equals("N"));
        scr.close();

    }
}
