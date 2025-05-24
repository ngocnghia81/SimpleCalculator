package com.example.fixtures;

import com.example.Calculator;

/**
 * FitNesse fixture cho Decision Table test
 */
public class CalculatorTest {
    private int firstNumber;
    private int secondNumber;
    private String operation;
    private String result;
    private Calculator calculator = new Calculator();
    
    public void setFirstNumber(int firstNumber) {
        this.firstNumber = firstNumber;
    }
    
    public void setSecondNumber(int secondNumber) {
        this.secondNumber = secondNumber;
    }
    
    public void setOperation(String operation) {
        this.operation = operation;
    }
    
    public String expectedResult() throws Exception {
        try {
            if ("add".equalsIgnoreCase(operation)) {
                return String.valueOf(calculator.add(firstNumber, secondNumber));
            } else if ("subtract".equalsIgnoreCase(operation)) {
                return String.valueOf(calculator.subtract(firstNumber, secondNumber));
            } else if ("multiply".equalsIgnoreCase(operation)) {
                return String.valueOf(calculator.multiply(firstNumber, secondNumber));
            } else if ("divide".equalsIgnoreCase(operation)) {
                return String.valueOf(calculator.divide(firstNumber, secondNumber));
            } else {
                throw new IllegalArgumentException("Không hỗ trợ phép tính: " + operation);
            }
        } catch (ArithmeticException e) {
            return "error";
        }
    }
} 