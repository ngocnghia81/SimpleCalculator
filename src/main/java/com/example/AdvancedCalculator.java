package com.example;

/**
 * An advanced calculator with additional operations
 */
public class AdvancedCalculator extends Calculator {
    
    /**
     * Calculate the power of a number
     * @param base the base number
     * @param exponent the exponent
     * @return base raised to the power of exponent
     */
    public double power(double base, double exponent) {
        return Math.pow(base, exponent);
    }
    
    /**
     * Calculate the square root of a number
     * @param number the input number
     * @return square root of the number
     * @throws IllegalArgumentException if number is negative
     */
    public double sqrt(double number) {
        if (number < 0) {
            throw new IllegalArgumentException("Cannot calculate square root of a negative number");
        }
        return Math.sqrt(number);
    }
    
    /**
     * Calculate the absolute value of a number
     * @param number the input number
     * @return absolute value of the number
     */
    public double abs(double number) {
        return Math.abs(number);
    }
    
    /**
     * Calculate the factorial of a number
     * @param n the input number
     * @return factorial of n (n!)
     * @throws IllegalArgumentException if n is negative
     */
    public long factorial(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Factorial is not defined for negative numbers");
        }
        if (n == 0 || n == 1) {
            return 1;
        }
        long result = 1;
        for (int i = 2; i <= n; i++) {
            result *= i;
        }
        return result;
    }
    
    /**
     * Check if a number is prime
     * @param n the number to check
     * @return true if the number is prime, false otherwise
     */
    public boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        }
        if (n <= 3) {
            return true;
        }
        if (n % 2 == 0 || n % 3 == 0) {
            return false;
        }
        for (int i = 5; i * i <= n; i += 6) {
            if (n % i == 0 || n % (i + 2) == 0) {
                return false;
            }
        }
        return true;
    }
} 