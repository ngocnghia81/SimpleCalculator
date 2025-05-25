package com.example;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class CalculatorTest {
    
    private Calculator calculator;
    
    @Before
    public void setUp() {
        calculator = new Calculator();
    }
    
    @Test
    public void testAdd() {
        assertEquals("2 + 3 should equal 5", 5, calculator.add(2, 3));
        assertEquals("0 + 0 should equal 0", 0, calculator.add(0, 0));
        assertEquals("-2 + 2 should equal 0", 0, calculator.add(-2, 2));
        assertEquals("-2 + (-3) should equal -5", -5, calculator.add(-2, -3));
        assertEquals("Maximum integer values should add correctly", Integer.MAX_VALUE - 1, calculator.add(Integer.MAX_VALUE - 2, 1));
        assertEquals("Large numbers should add correctly", 2000000000, calculator.add(1000000000, 1000000000));
    }
    
    @Test
    public void testSubtract() {
        assertEquals("2 - 3 should equal -1", -1, calculator.subtract(2, 3));
        assertEquals("0 - 0 should equal 0", 0, calculator.subtract(0, 0));
        assertEquals("-2 - 2 should equal -4", -4, calculator.subtract(-2, 2));
        assertEquals("-2 - (-3) should equal 1", 1, calculator.subtract(-2, -3));
        assertEquals("5 - 3 should equal 2", 2, calculator.subtract(5, 3));
        assertEquals("Minimum integer values should subtract correctly", Integer.MIN_VALUE + 1, calculator.subtract(Integer.MIN_VALUE, -1));
    }
    
    @Test
    public void testMultiply() {
        assertEquals("2 * 3 should equal 6", 6, calculator.multiply(2, 3));
        assertEquals("0 * 5 should equal 0", 0, calculator.multiply(0, 5));
        assertEquals("5 * 0 should equal 0", 0, calculator.multiply(5, 0));
        assertEquals("-2 * 2 should equal -4", -4, calculator.multiply(-2, 2));
        assertEquals("-2 * (-3) should equal 6", 6, calculator.multiply(-2, -3));
        assertEquals("Large numbers should multiply correctly", 100000000, calculator.multiply(10000, 10000));
    }
    
    @Test
    public void testDivide() {
        assertEquals("6 / 3 should equal 2", 2.0, calculator.divide(6, 3), 0.0001);
        assertEquals("0 / 5 should equal 0", 0.0, calculator.divide(0, 5), 0.0001);
        assertEquals("-2 / 2 should equal -1", -1.0, calculator.divide(-2, 2), 0.0001);
        assertEquals("-6 / (-3) should equal 2", 2.0, calculator.divide(-6, -3), 0.0001);
        assertEquals("1 / 2 should equal 0.5", 0.5, calculator.divide(1, 2), 0.0001);
        assertEquals("5 / 2 should equal 2.5", 2.5, calculator.divide(5, 2), 0.0001);
        assertEquals("Large division should work", 1000.0, calculator.divide(1000000, 1000), 0.0001);
    }
    
    @Test(expected = ArithmeticException.class)
    public void testDivideByZero() {
        // Should throw ArithmeticException
        calculator.divide(6, 0);
    }
    
    @Test
    public void testDivideByZeroMessage() {
        try {
            calculator.divide(6, 0);
            fail("Expected ArithmeticException was not thrown");
        } catch (ArithmeticException e) {
            assertEquals("Exception message should be 'Cannot divide by zero'", 
                        "Cannot divide by zero", e.getMessage());
        }
    }
    
    @Test
    public void testIntegerOverflow() {
        // This is expected behavior in Java - integer overflow
        int result = calculator.add(Integer.MAX_VALUE, 1);
        assertEquals("Integer overflow should occur", Integer.MIN_VALUE, result);
    }
} 