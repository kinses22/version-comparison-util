package com.sojern.service;

/**
 * This class provides an int comparison result for two versions of type String.
 * @author Stephen Kinsella
 */
public class VersionComparator {

    /**
     * Compares two version string arrays which can be made up of major, minor, patch etc version
     * numbers. The two arrays can contain different varieties of the aforementioned version semantics.
     * The method loops over the max length of the largest String[]. It will always compare the major versions
     * directly and return the relative order of the two numbers. It will continue on comparing each numeric
     * sequence if the major versions are the same and returns immediately if there's a difference.
     *
     * It also checks to see if each version contains a minor, patch etc by measuring the length of the array.
     * If one array has a patch version, but the other array does not, it will get the value of the patch version
     * and see if it is bigger than zero and set the return value to be the appropriate value.
     *
     * @param firstVersion  the version seperated to a string array to be compared
     * @param secondVersion the version seperated to a string array to be compared
     * @return an int value of 0,1 or -1 is returned based on if the versions are the same,
     * first version is higher than the second version and vice versa.
     */
    public int getComparisonValue(final String[] firstVersion, final String[] secondVersion) {
        int comparisonValue = 0;
        int maxIterations = Math.max(firstVersion.length, secondVersion.length);
        for (int i = 0; i < maxIterations; i++) {
            if (firstVersion.length - 1 < i) {
                if (Integer.parseInt(secondVersion[i]) > 0) {
                    comparisonValue = -1;
                }
            } else if (secondVersion.length - 1 < i) {
                if (Integer.parseInt(firstVersion[i]) > 0) {
                    comparisonValue = 1;
                }
            } else {
                comparisonValue = convertToIntAndCompareNumbers(firstVersion[i], secondVersion[i]);
                if (comparisonValue == 1 || comparisonValue == -1) {
                    return comparisonValue;
                }
            }
        }
        return comparisonValue;
    }

    /**
     * converts String to int and then compares relative order.
     *
     * @param firstNumberSequence  the sequence from an array to be compared
     * @param secondNumberSequence the sequence from an array to be compared
     * @return an int value of 0,1 or -1 based on if the versions are the same,
     * first version is higher than the second version and vice versa
     */
    private int convertToIntAndCompareNumbers(final String firstNumberSequence,
                                              final String secondNumberSequence) {
        return Integer.compare(Integer.parseInt(firstNumberSequence),
                Integer.parseInt(secondNumberSequence));
    }

}
