package com.example;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for App class methods.
 */
public class AppTest extends TestCase {

    public AppTest(String testName) {
        super(testName);
    }

    public static Test suite() {
        return new TestSuite(AppTest.class);
    }

    // -------------------------------
    // Roman Numeral Conversion Tests
    // -------------------------------
    public void testRomanToIntBasic() {
        assertEquals(1, App.romanToInt("I"));
        assertEquals(4, App.romanToInt("IV"));
        assertEquals(9, App.romanToInt("IX"));
        assertEquals(58, App.romanToInt("LVIII")); // L=50, V=5, III=3
        assertEquals(1994, App.romanToInt("MCMXCIV")); // M=1000, CM=900, XC=90, IV=4
    }



}
