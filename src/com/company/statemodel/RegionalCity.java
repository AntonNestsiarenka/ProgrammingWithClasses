package com.company.statemodel;

public class RegionalCity extends City {

    public RegionalCity() {
    }

    public RegionalCity(String name, long population, int yearOfFoundation, double area) {
        super(name, population, yearOfFoundation, area);
    }

    @Override
    public void printInfo() {
        System.out.println(toString());
    }

    @Override
    public String toString() {
        return "Город областного типа: "
                + getName() + ". Население: "
                + getPopulation() + " ч. Год основания: "
                + getYearOfFoundation() + " г. Площадь: "
                + getArea() + " км2.";
    }
}