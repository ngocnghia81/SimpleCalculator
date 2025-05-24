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
    
    public CalculatorFixture() {
        calculator = new Calculator();
    }
    
    public void setFirstNumber(int firstNumber) {
        this.firstNumber = firstNumber;
    }
    
    public void setSecondNumber(int secondNumber) {
        this.secondNumber = secondNumber;
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
    
    public void add() {
        this.result = calculator.add(firstNumber, secondNumber);
    }
    
    public void subtract() {
        this.result = calculator.subtract(firstNumber, secondNumber);
    }
    
    public void multiply() {
        this.result = calculator.multiply(firstNumber, secondNumber);
    }
    
    public void divide() {
        this.result = calculator.divide(firstNumber, secondNumber);
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
            this.result = calculator.divide(firstNumber, secondNumber);
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