package com.sojern.service;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class VersionComparatorTest {

    private static VersionComparator subjectUnderTest;

    @BeforeAll
    static void setUp() {
        subjectUnderTest = new VersionComparator();
    }

    @Test()
    public void testVersionOneGreaterThanVersionTwoAndReturnOneFirst() {
        String[] versionOne = {"1", "21", "3"};
        String[] versionTwo = {"1", "21", "2"};
        int expectedResult = 1;
        int result = subjectUnderTest.getComparisonValue(versionOne, versionTwo);
        assertEquals(expectedResult, result);
    }

    @Test()
    public void testVersionOneGreaterThanVersionTwoAndReturnOneSecond() {
        String[] versionOne = {"1", "21", "3"};
        String[] versionTwo = {"1", "21"};
        int expectedResult = 1;
        int result = subjectUnderTest.getComparisonValue(versionOne, versionTwo);
        assertEquals(expectedResult, result);
    }

    @Test()
    public void testVersionOneGreaterThanVersionTwoAndReturnOneThird() {
        String[] versionOne = {"1", "21", "3"};
        String[] versionTwo = {"1"};
        int expectedResult = 1;
        int result = subjectUnderTest.getComparisonValue(versionOne, versionTwo);
        assertEquals(expectedResult, result);
    }

    @Test()
    public void testVersionTwoGreaterThanVersionOneAndReturnMinusOneFirst() {
        String[] versionOne = {"1", "21", "2"};
        String[] versionTwo = {"1", "21", "3"};
        int expectedResult = -1;
        int result = subjectUnderTest.getComparisonValue(versionOne, versionTwo);
        assertEquals(expectedResult, result);
    }

    @Test()
    public void testVersionTwoGreaterThanVersionOneAndReturnMinusOneSecond() {
        String[] versionOne = {"1", "21"};
        String[] versionTwo = {"1", "21", "3"};
        int expectedResult = -1;
        int result = subjectUnderTest.getComparisonValue(versionOne, versionTwo);
        assertEquals(expectedResult, result);
    }

    @Test()
    public void testVersionTwoGreaterThanVersionOneAndReturnMinusOneThird() {
        String[] versionOne = {"1"};
        String[] versionTwo = {"1", "21", "3"};
        int expectedResult = -1;
        int result = subjectUnderTest.getComparisonValue(versionOne, versionTwo);
        assertEquals(expectedResult, result);
    }

    @Test()
    public void testVersionTwoGreaterThanVersionOneAndReturnMinusOneFourth() {
        String[] versionOne = {"1"};
        String[] versionTwo = {"2", "21", "3"};
        int expectedResult = -1;
        int result = subjectUnderTest.getComparisonValue(versionOne, versionTwo);
        assertEquals(expectedResult, result);
    }


    @Test()
    public void testVersionOneIsEqualToVersionTwoAndReturnZeroFirst() {
        String[] versionOne = {"1", "21", "3"};
        String[] versionTwo = {"1", "21", "3"};
        int expectedResult = 0;
        int result = subjectUnderTest.getComparisonValue(versionOne, versionTwo);
        assertEquals(expectedResult, result);
    }

    @Test()
    public void testVersionOneIsEqualToVersionTwoAndReturnZeroSecond() {
        String[] versionOne = {"1", "21"};
        String[] versionTwo = {"1", "21"};
        int expectedResult = 0;
        int result = subjectUnderTest.getComparisonValue(versionOne, versionTwo);
        assertEquals(expectedResult, result);
    }

    @Test()
    public void testVersionOneIsEqualToVersionTwoAndReturnZeroThird() {
        String[] versionOne = {"1"};
        String[] versionTwo = {"1"};
        int expectedResult = 0;
        int result = subjectUnderTest.getComparisonValue(versionOne, versionTwo);
        assertEquals(expectedResult, result);
    }


}