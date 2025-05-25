package com.example.fixtures;

import com.example.Calculator;

/**
 * Fixture để kiểm tra phép chia cho 0
 */
public class DivideByZeroTest {
    private Calculator calculator = new Calculator();
    private int a;
    private int b;
    private String message;
    
    public void setA(int a) {
        this.a = a;
    }
    
    public void setB(int b) {
        this.b = b;
    }
    
    public String message() {
        try {
            double result = calculator.divide(a, b);
            return "Phép chia " + a + "/" + b + " = " + result;
        } catch (ArithmeticException e) {
            return "Lỗi: " + e.getMessage();
        }
    }
    
    public boolean exception() {
        try {
            calculator.divide(a, b);
            return false;
        } catch (ArithmeticException e) {
            return true;
        }
    }
} 