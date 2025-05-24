package com.example.fixtures;

public class SimpleFixture {
    private int a;
    private int b;
    private int result;
    
    public void setA(int a) {
        this.a = a;
    }
    
    public void setB(int b) {
        this.b = b;
    }
    
    public int getA() {
        return this.a;
    }
    
    public int getB() {
        return this.b;
    }
    
    public void execute() {
        this.result = a + b;
    }
    
    public int result() {
        return this.result;
    }
} 