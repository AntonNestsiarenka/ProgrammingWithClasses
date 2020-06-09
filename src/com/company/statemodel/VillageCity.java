package com.company.statemodel;

public class VillageCity extends City {

    public VillageCity() {
    }

    public VillageCity(String name, long population, int yearOfFoundation, double area) {
        super(name, population, yearOfFoundation, area);
    }

    @Override
    public void printInfo() {
        System.out.println(toString());
    }

    @Override
    public String toString() {
        return "Населенный пункт сельского типа: "
                + getName() + ". Население: "
                + getPopulation() + " ч. Год основания: "
                + getYearOfFoundation() + " г. Площадь: "
                + getArea() + " км2";
    }
}