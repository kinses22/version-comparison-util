package com.sojern.service;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class VersionValidatorTest {

    private static VersionValidator subjectUnderTest;

    @BeforeAll
    static void setUp() {
        subjectUnderTest = new VersionValidator();
    }

    @Test()
    public void testValidStringVersionOne() {
        String version = "1.3.123";
        assertDoesNotThrow(
                () -> subjectUnderTest.validateVersion(version));
    }

    @Test()
    public void testValidStringVersionTwo() {
        String version = "1.0";
        assertDoesNotThrow(
                () -> subjectUnderTest.validateVersion(version));
    }

    @Test()
    public void testValidStringVersionThree() {
        String version = "1.0.0";
        assertDoesNotThrow(
                () -> subjectUnderTest.validateVersion(version));
    }

    @Test()
    public void testValidStringVersionFour() {
        String version = "1";
        assertDoesNotThrow(
                () -> subjectUnderTest.validateVersion(version));
    }

    @Test()
    public void testInvalidVersionSizeZero() {
        String version = "";
        assertThrows(IllegalArgumentException.class, () -> subjectUnderTest.validateVersion(version));
    }

    @Test()
    public void testInvalidVersionSizeMoreThanTwenty() {
        String version = "222222222222.11111111111111.3333333333333";
        assertThrows(IllegalArgumentException.class, () -> subjectUnderTest.validateVersion(version));
    }

    @Test()
    public void testInvalidVersionStartsWithZero() {
        String version = "00.1.2";
        assertThrows(IllegalArgumentException.class, () -> subjectUnderTest.validateVersion(version));
    }

    @Test()
    public void testInvalidVersionRegexOne() {
        String version = "0..1.2";
        assertThrows(IllegalArgumentException.class, () -> subjectUnderTest.validateVersion(version));
    }

    @Test()
    public void testInvalidVersionRegexTwo() {
        String version = "stephen";
        assertThrows(IllegalArgumentException.class, () -> subjectUnderTest.validateVersion(version));
    }

    @Test()
    public void testInvalidVersionRegexThree() {
        String version = ".";
        assertThrows(IllegalArgumentException.class, () -> subjectUnderTest.validateVersion(version));
    }

    @Test()
    public void testInvalidVersionMinorVersionOne() {
        String version = "1.00.1";
        assertThrows(IllegalArgumentException.class, () -> subjectUnderTest.validateVersion(version));
    }

    @Test()
    public void testInvalidVersionMinorVersionTwo() {
        String version = "1.02.1";
        assertThrows(IllegalArgumentException.class, () -> subjectUnderTest.validateVersion(version));
    }

    @Test()
    public void testInvalidVersionPatchVersionOne() {
        String version = "1.0.00";
        assertThrows(IllegalArgumentException.class, () -> subjectUnderTest.validateVersion(version));
    }

    @Test()
    public void testInvalidVersionPatchVersionTwo() {
        String version = "1.0.02";
        assertThrows(IllegalArgumentException.class, () -> subjectUnderTest.validateVersion(version));
    }

    @Test()
    public void testValidSemanticVersion() {
        String[] versionArray = {"1", "21", "3"};
        String versionString = "1.21.3";
        String[] resultArray = subjectUnderTest.validateVersion(versionString);
        assertArrayEquals(versionArray, resultArray);
    }

    @Test()
    public void testInvalidSemanticVersionSizeGreaterThanSix() {
        String versionString = "1.2.21.3.1.2.7";
        assertThrows(IllegalArgumentException.class, () -> subjectUnderTest.validateVersion(versionString));
    }

}