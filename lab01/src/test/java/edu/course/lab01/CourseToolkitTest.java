package edu.course.lab01;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Disabled;

class CourseToolkitTest {

    @Test
    void returnsTrueForEvenNumber() {
        boolean result = CourseToolkit.isEven(8);

        assertTrue(result);
    }

    @Test
    void returnsFalseForOddNumber() {
        boolean result = CourseToolkit.isEven(7);

        assertFalse(result);
    }
    @Test 
    void returnsTrueForNegativeEvenNumber() {
        boolean result = CourseToolkit.isEven(-8);

        assertTrue(result);
    }
    @ParameterizedTest 
    @CsvSource ({
        "1, false",
        "2, true",
        "44, false",
        "11, true",
        "49, false"
    
    })
    void returnsTestPrimeForNumber(int number, boolean expected) {
        assertEquals(expected, CourseToolkit.isPrime(number));
    }
   /* @Test 
    void returnsFalseNumbersLessThanTwo() {
        boolean result = CourseToolkit.isPrime(1);

        assertFalse(result);
    }
    @Test 
    void returnsTrueForTwo() {
        boolean result = CourseToolkit.isPrime(2);

        assertTrue(result);
    }
    @Test 
    void returnsFalseForEvenNumber() {
        boolean result = CourseToolkit.isPrime(44);

        assertFalse(result);
    } 
    @Test 
    void returnsTrueForPrimeNumbers() {
        boolean result = CourseToolkit.isPrime(11);

        assertTrue(result);
    } */
    @Test 
    void returnsTrueForLengthOne() {
        boolean result = CourseToolkit.isPalindrome("a");

        assertTrue(result);
    }
    @Test 
    void returnsTrueForPalindrome() {
        boolean result = CourseToolkit.isPalindrome("abba");

        assertTrue(result);
    }
    @Test 
    void returnsFalseForNotPalindrome() {
        boolean result = CourseToolkit.isPalindrome("abc");

        assertFalse(result);
    }
    @Disabled
    void returnsForNull() {
        boolean result = CourseToolkit.isPalindrome("null");

        assertFalse(result);
    }
    @Disabled 
    void returnsAverageForNone() {
        double result = CourseToolkit.Average(new int[] {});

        assertEquals(result,  2);
    }
    @Disabled 
    void returnsAverageForNull() {
        double result = CourseToolkit.Average(null);

        assertEquals(result,  0);
    }
    @Test 
    void returnsAverageForMassive() {
        double result = CourseToolkit.Average(new int[] {1, 2, 3});

        assertEquals(result,  2);
    }
    @Test 
    void returnsAverageForLengthOne() {
        double result = CourseToolkit.Average(new int[] {1});

        assertEquals(result, 1);
    }
}
