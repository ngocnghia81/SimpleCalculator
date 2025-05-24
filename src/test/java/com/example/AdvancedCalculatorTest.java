package com.example;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class AdvancedCalculatorTest {
    
    private AdvancedCalculator calculator;
    
    @Before
    public void setUp() {
        calculator = new AdvancedCalculator();
    }
    
    @Test
    public void testPower() {
        assertEquals("2^3 should equal 8", 8.0, calculator.power(2, 3), 0.0001);
        assertEquals("2^0 should equal 1", 1.0, calculator.power(2, 0), 0.0001);
        assertEquals("0^5 should equal 0", 0.0, calculator.power(0, 5), 0.0001);
        assertEquals("Any number^1 should equal itself", 7.0, calculator.power(7, 1), 0.0001);
        assertEquals("-2^2 should equal 4", 4.0, calculator.power(-2, 2), 0.0001);
        assertEquals("-2^3 should equal -8", -8.0, calculator.power(-2, 3), 0.0001);
        assertEquals("Fractional exponents should work", 3.0, calculator.power(9, 0.5), 0.0001);
    }
    
    @Test
    public void testSqrt() {
        assertEquals("sqrt(9) should equal 3", 3.0, calculator.sqrt(9), 0.0001);
        assertEquals("sqrt(2) should approximately equal 1.414", 1.414, calculator.sqrt(2), 0.001);
        assertEquals("sqrt(0) should equal 0", 0.0, calculator.sqrt(0), 0.0001);
        assertEquals("sqrt of very large number", 1000.0, calculator.sqrt(1000000), 0.0001);
        assertEquals("sqrt of very small number", 0.1, calculator.sqrt(0.01), 0.0001);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testSqrtOfNegativeNumber() {
        calculator.sqrt(-1);
    }
    
    @Test
    public void testSqrtExceptionMessage() {
        try {
            calculator.sqrt(-4);
            fail("Expected IllegalArgumentException was not thrown");
        } catch (IllegalArgumentException e) {
            assertEquals("Exception message for sqrt should be correct", 
                        "Cannot calculate square root of a negative number", e.getMessage());
        }
    }
    
    @Test
    public void testAbs() {
        assertEquals("abs(5) should equal 5", 5.0, calculator.abs(5), 0.0001);
        assertEquals("abs(-5) should equal 5", 5.0, calculator.abs(-5), 0.0001);
        assertEquals("abs(0) should equal 0", 0.0, calculator.abs(0), 0.0001);
        assertEquals("abs of very large number", 1000000.0, calculator.abs(-1000000), 0.0001);
        assertEquals("abs of very small number", 0.0001, calculator.abs(-0.0001), 0.00001);
    }
    
    @Test
    public void testFactorial() {
        assertEquals("0! should equal 1", 1, calculator.factorial(0));
        assertEquals("1! should equal 1", 1, calculator.factorial(1));
        assertEquals("5! should equal 120", 120, calculator.factorial(5));
        assertEquals("10! should equal 3628800", 3628800, calculator.factorial(10));
        // Test larger factorial that fits in long
        assertEquals("20! should be calculated correctly", 2432902008176640000L, calculator.factorial(20));
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testFactorialOfNegativeNumber() {
        calculator.factorial(-1);
    }
    
    @Test
    public void testIsPrime() {
        // Test non-prime numbers
        assertFalse("0 is not prime", calculator.isPrime(0));
        assertFalse("1 is not prime", calculator.isPrime(1));
        assertFalse("4 is not prime", calculator.isPrime(4));
        assertFalse("6 is not prime", calculator.isPrime(6));
        assertFalse("100 is not prime", calculator.isPrime(100));
        assertFalse("999 is not prime", calculator.isPrime(999));
        
        // Test prime numbers
        assertTrue("2 is prime", calculator.isPrime(2));
        assertTrue("3 is prime", calculator.isPrime(3));
        assertTrue("5 is prime", calculator.isPrime(5));
        assertTrue("7 is prime", calculator.isPrime(7));
        assertTrue("11 is prime", calculator.isPrime(11));
        assertTrue("13 is prime", calculator.isPrime(13));
        assertTrue("17 is prime", calculator.isPrime(17));
        assertTrue("19 is prime", calculator.isPrime(19));
        assertTrue("23 is prime", calculator.isPrime(23));
        assertTrue("97 is prime", calculator.isPrime(97));
        assertTrue("101 is prime", calculator.isPrime(101));
        assertTrue("997 is prime", calculator.isPrime(997));
    }
    
    @Test
    public void testInheritedMethods() {
        // Test that inherited methods from Calculator still work
        assertEquals("Basic add should work", 8, calculator.add(3, 5));
        assertEquals("Basic subtract should work", 7, calculator.subtract(10, 3));
        assertEquals("Basic multiply should work", 24, calculator.multiply(6, 4));
        assertEquals("Basic divide should work", 3, calculator.divide(15, 5));
    }
} 