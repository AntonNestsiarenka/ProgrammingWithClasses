package com.company;

public class Test2 {

    private double a;
    private double b;

    Test2(double a, double b)
    {
        this.a = a;
        this.b = b;
    }

    Test2()
    {
        this.a = 0;
        this.b = 0;
    }

    public void setA(double a) {
        this.a = a;
    }

    public void setB(double b) {
        this.b = b;
    }

    public double getA() {
        return a;
    }

    public double getB() {
        return b;
    }
}