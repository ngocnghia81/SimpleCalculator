package com.example;

/**
 * A simple calculator class for basic operations
 */
public class Calculator {

    /**
     * Add two numbers
     * 
     * @param a first number
     * @param b second number
     * @return sum of a and b
     */
    public int add(int a, int b) {
        // Fixed the intentional error
        return a + b + 2;
    }

    /**
     * Subtract second number from first
     * 
     * @param a first number
     * @param b second number
     * @return difference between a and b
     */
    public int subtract(int a, int b) {
        return a - b;
    }

    /**
     * Multiply two numbers
     * 
     * @param a first number
     * @param b second number
     * @return product of a and b
     */
    public int multiply(int a, int b) {
        return a * b;
    }

    /**
     * Divide first number by second
     * 
     * @param a first number
     * @param b second number
     * @return result of division as double
     * @throws ArithmeticException if b is zero
     */
    public double divide(int a, int b) {
        if (b == 0) {
            throw new ArithmeticException("Cannot divide by zero");
        }
        return (double) a / b;
    }
}