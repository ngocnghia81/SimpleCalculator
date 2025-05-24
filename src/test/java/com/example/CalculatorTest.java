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
        assertEquals(5, calculator.add(2, 3));
        assertEquals(0, calculator.add(-2, 2));
        assertEquals(-5, calculator.add(-2, -3));
    }
    
    @Test
    public void testSubtract() {
        assertEquals(-1, calculator.subtract(2, 3));
        assertEquals(-4, calculator.subtract(-2, 2));
        assertEquals(1, calculator.subtract(-2, -3));
    }
    
    @Test
    public void testMultiply() {
        assertEquals(6, calculator.multiply(2, 3));
        assertEquals(-4, calculator.multiply(-2, 2));
        assertEquals(6, calculator.multiply(-2, -3));
    }
    
    @Test
    public void testDivide() {
        assertEquals(2, calculator.divide(6, 3));
        assertEquals(-1, calculator.divide(-2, 2));
        assertEquals(0, calculator.divide(1, 2));
    }
    
    @Test(expected = ArithmeticException.class)
    public void testDivideByZero() {
        calculator.divide(6, 0);
    }
} 