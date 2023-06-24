package com.sojern.service;

public class VersionComparator {

    final VersionValidation versionValidation;

    public VersionComparator(final VersionValidation versionValidation) {
        this.versionValidation = versionValidation;
    }

    public int checkVersion(final String[] firstVersion, final String[] secondVersion, final int iterations) {
        int version = 0;

        for (int i = 0; i < iterations; i++) {
            if (firstVersion.length - 1 < i) {
                if (Integer.parseInt(secondVersion[i]) > 0) {
                    version = -1;
                }
            } else if (secondVersion.length - 1 < i) {
                if (Integer.parseInt(firstVersion[i]) > 0) {
                    version = 1;
                }
            } else {
                version = convertToIntAndCompareNumbers(firstVersion[i], secondVersion[i]);
                if (version == 1 || version == -1) {
                    return version;
                }
            }
        }
        return version;
    }

    private int convertToIntAndCompareNumbers(String num1, String num2) {
        return Integer.compare(Integer.parseInt(num1), Integer.parseInt(num2));
    }

}
