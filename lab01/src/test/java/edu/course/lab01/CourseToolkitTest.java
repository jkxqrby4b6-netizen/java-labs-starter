package edu.course.lab01;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

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
    @Test 
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
    }
}
