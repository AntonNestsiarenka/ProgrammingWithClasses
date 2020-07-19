package com.company.statemodel.city.children;

import com.company.statemodel.city.City;

public class VillageCity extends City {

    /* Класс описывает населенный пункт сельского типа. */

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