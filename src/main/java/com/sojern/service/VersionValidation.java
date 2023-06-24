package com.sojern.service;

import static com.sojern.utils.VersionConstants.*;

/**
 * This class provides validation for version Strings and version String arrays.
 * @author  Stephen Kinsella
 */
public class VersionValidation {

    /**
     * validates a version.
     *
     * @param version the version to validate
     * @throws IllegalArgumentException if the version doesn't meet certain requirements.
     *
     */

    public void validateVersion(final String version) {
        if (version.length() < 1 || version.length() > 20) {
            throw new IllegalArgumentException(VERSION_SIZE_VALIDATION);
        }
        if (version.startsWith(ZERO)) {
            throw new IllegalArgumentException(VERSION_CANT_START_WITH_ZERO);
        }
        if (!version.matches(VERSION_REGEX)) {
            throw new IllegalArgumentException(INVALID_VERSION_SYNTAX);
        }
        if (version.matches(ZERO_FOLLOWED_BY_A_NUMBER_AFTER_DOT_PATTERN)) {
            throw new IllegalArgumentException(INVALID_MINOR_OR_PATCH_VERSION);
        }
    }

    /**
     * validates an array of version numbers, the array is split into
     * major, minor and patch. It makes sure it isn't bigger than that.
     *
     * @param versionArray the version to validate
     * @throws IllegalArgumentException if the array is greater than 3.
     *
     */
    public void validateSemanticVersion(final String[] versionArray) {
        if (versionArray.length > THREE) {
            throw new IllegalArgumentException(INAVLID_SEMANTIC_VERSIONING);
        }
    }
}
