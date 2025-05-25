package com.example.fixtures;

import com.example.Calculator;

/**
 * FitNesse fixture for testing the Calculator class
 */
public class CalculatorFixture {
    private Calculator calculator;
    private int firstNumber;
    private int secondNumber;
    private int result;
    private double decimalResult;
    
    public CalculatorFixture() {
        calculator = new Calculator();
    }
    
    public void setFirstNumber(int firstNumber) {
        this.firstNumber = firstNumber;
    }
    
    // Overload for string input to handle "result" as input
    public void setFirstNumber(String value) {
        if ("result".equalsIgnoreCase(value) || "r".equalsIgnoreCase(value)) {
            this.firstNumber = this.result;
        } else {
            try {
                this.firstNumber = Integer.parseInt(value);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("Cannot convert '" + value + "' to integer");
            }
        }
    }
    
    public void setSecondNumber(int secondNumber) {
        this.secondNumber = secondNumber;
    }
    
    // Overload for string input to handle "result" as input
    public void setSecondNumber(String value) {
        if ("result".equalsIgnoreCase(value) || "r".equalsIgnoreCase(value)) {
            this.secondNumber = this.result;
        } else {
            try {
                this.secondNumber = Integer.parseInt(value);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("Cannot convert '" + value + "' to integer");
            }
        }
    }
    
    public int firstNumber() {
        return this.firstNumber;
    }
    
    public int secondNumber() {
        return this.secondNumber;
    }
    
    public int result() {
        return this.result;
    }
    
    public double decimalResult() {
        return this.decimalResult;
    }
    
    public void add() {
        this.result = calculator.add(firstNumber, secondNumber);
        this.decimalResult = this.result;
    }
    
    public void subtract() {
        this.result = calculator.subtract(firstNumber, secondNumber);
        this.decimalResult = this.result;
    }
    
    public void multiply() {
        this.result = calculator.multiply(firstNumber, secondNumber);
        this.decimalResult = this.result;
    }
    
    public void divide() {
        this.decimalResult = calculator.divide(firstNumber, secondNumber);
        this.result = (int)this.decimalResult;
    }
    
    public boolean resultEquals(int expected) {
        return this.result == expected;
    }
    
    public int calc(String operation) {
        if ("add".equalsIgnoreCase(operation)) {
            this.result = calculator.add(firstNumber, secondNumber);
        } else if ("subtract".equalsIgnoreCase(operation)) {
            this.result = calculator.subtract(firstNumber, secondNumber);
        } else if ("multiply".equalsIgnoreCase(operation)) {
            this.result = calculator.multiply(firstNumber, secondNumber);
        } else if ("divide".equalsIgnoreCase(operation)) {
            this.decimalResult = calculator.divide(firstNumber, secondNumber);
            this.result = (int)this.decimalResult;
        }
        return this.result;
    }
    
    public CalculatorFixture givenCalculator() {
        return this;
    }
    
    public void whenISetFirstNumberTo(int number) {
        this.firstNumber = number;
    }
    
    public void andISetSecondNumberTo(int number) {
        this.secondNumber = number;
    }
    
    public void andIAdd() {
        add();
    }
    
    public void andISubtract() {
        subtract();
    }
    
    public void andIMultiply() {
        multiply();
    }
    
    public void andIDivide() {
        divide();
    }
    
    public boolean thenResultShouldBe(int expected) {
        return this.result == expected;
    }
} 