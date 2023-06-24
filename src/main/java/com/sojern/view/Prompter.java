package com.sojern.view;

import com.sojern.service.VersionComparator;
import com.sojern.service.VersionValidation;

import java.util.Scanner;

public class Prompter {

    final Scanner scr = new Scanner(System.in);
    final VersionComparator versionComparator;
    final VersionValidation versionValidation;

    public Prompter(final VersionComparator versionComparator, final VersionValidation versionValidation) {
        this.versionComparator = versionComparator;
        this.versionValidation = versionValidation;
    }

    public int promptForVersion() {
        String quit;
        String firstVersion;
        String secondVersion;
        String[] firstVersionArray = new String[0];
        String[] secondVersionArray = new String[0];
        boolean userInput = false;


        do {
            while (!userInput) {
                try {
                    System.out.println("Enter first version: ");
                    firstVersion = scr.nextLine();
                    versionValidation.validateVersion(firstVersion);
                    firstVersionArray = firstVersion.split("\\.");
                    versionValidation.validateSemanticVersion(firstVersionArray);
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
                    versionValidation.validateVersion(secondVersion);
                    secondVersionArray = secondVersion.split("\\.");
                    versionValidation.validateSemanticVersion(secondVersionArray);
                    userInput = true;

                } catch (IllegalArgumentException exception) {
                    System.out.println("That wasn't a valid version: " + exception.getMessage());
                }
            }
            userInput = false;
            int result = 0;
            int maxIterations = Math.max(firstVersionArray.length, secondVersionArray.length);
            try {
                result = versionComparator.checkVersion(firstVersionArray, secondVersionArray, maxIterations);
            } catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
            System.out.println("result: " + result);
            System.out.println("To quit press N, to continue press any key");
            quit = scr.nextLine();
        } while (!quit.equals("N"));
        scr.close();
        return 0;
    }
}
