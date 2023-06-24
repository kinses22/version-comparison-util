package com.sojern.service;

import static com.sojern.utils.VersionConstants.*;

/**
 * This class provides validation for version Strings and version String arrays.
 * @author  Stephen Kinsella
 */
public class VersionValidator {

    /**
     * Validates a version based on various criteria to do with versioning.
     *
     * @param version the version to validate
     * @throws IllegalArgumentException if the version doesn't meet certain requirements.
     *
     */

    public String[] validateVersion(final String version) {
        if (version.length() < 1 || version.length() > 20) {
            throw new IllegalArgumentException(VERSION_SIZE_VALIDATION);
        }
        if (version.matches(VERSION_STARTS_WITH_MORE_THAN_ONE_ZER0)) {
            throw new IllegalArgumentException(VERSION_CANT_START_WITH_MORE_THAN_ONE_ZERO);
        }
        if (!version.matches(VERSION_PATTERN)) {
            throw new IllegalArgumentException(INVALID_VERSION_SYNTAX);
        }
        if (version.matches(ZERO_FOLLOWED_BY_A_NUMBER_AFTER_DOT_PATTERN)) {
            throw new IllegalArgumentException(INVALID_MINOR_OR_PATCH_VERSION);
        }
        return validateSemanticVersion(version.split("\\."));
    }

    /**
     * Validates an array of version numbers, the array is split into
     * major, minor, patch and less important changes. It makes sure it isn't bigger than six number sequences.
     *
     * @param versionArray the version to validate
     * @throws IllegalArgumentException if the array is greater than 3.
     *
     * @return
     */
    private String[] validateSemanticVersion(final String[] versionArray) {
        if (versionArray.length > SIX) {
            throw new IllegalArgumentException(INAVLID_SEMANTIC_VERSIONING);
        }
        return versionArray;
    }
}
