package com.sojern.utils;

public class VersionConstants {

    public static final int SIX = 6;

    public static final String VERSION_PATTERN = "^\\d+(\\.\\d+)*$";
    public static final String ZERO_FOLLOWED_BY_A_NUMBER_AFTER_DOT_PATTERN = "\\..*0\\d.*|.*\\.0\\d.*";
    public static final String VERSION_STARTS_WITH_MORE_THAN_ONE_ZER0 = "^0{2,}.*$";

    public static final String INVALID_VERSION_SYNTAX = "Invalid version syntax," +
            " please only use numbers and dots," +
            " can only start and end a version with a number";
    public static final String VERSION_SIZE_VALIDATION = "Version size has to be at least 1 and" +
            " most 20 characters";
    public static final String VERSION_CANT_START_WITH_MORE_THAN_ONE_ZERO = "Major versions cant start with more than one 0";
    public static final String INAVLID_SEMANTIC_VERSIONING = "Only traditional semantic versioning is accepted for now: Major.Minor.Patch";
    public static final String INVALID_MINOR_OR_PATCH_VERSION = "Minor or patch version cant start with 0 followed by a number";


}
