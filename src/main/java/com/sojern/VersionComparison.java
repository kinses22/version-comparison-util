package com.sojern;

import com.sojern.service.VersionComparator;
import com.sojern.service.VersionValidation;
import com.sojern.view.Prompter;

public class VersionComparison {

     public static void main(String[] args) {

         VersionValidation versionValidation = new VersionValidation();
         VersionComparator versionComparator = new VersionComparator(versionValidation);
         Prompter prompter = new Prompter(versionComparator, versionValidation);
         prompter.promptForVersion();

     }
}
