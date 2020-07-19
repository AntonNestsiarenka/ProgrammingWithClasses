package com.company.Test2;

public class Test2 {

    /* Тестовый класс. */

    private double a;
    private double b;

    public Test2(double a, double b)
    {
        this.a = a;
        this.b = b;
    }

    public Test2()
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