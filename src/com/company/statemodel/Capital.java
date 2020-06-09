package com.company.statemodel;

public class Capital extends City{

    public Capital() {
    }

    public Capital(String name, long population, int yearOfFoundation, double area) {
        super(name, population, yearOfFoundation, area);
    }

    @Override
    public void printInfo() {
        System.out.println(toString());
    }

    @Override
    public String toString() {
        return "Столица: " + getName()
                + ". Население: " + getPopulation()
                + "ч. Год основания: " + getYearOfFoundation()
                + " г. Площадь: " + getArea() + " км2.";
    }
}