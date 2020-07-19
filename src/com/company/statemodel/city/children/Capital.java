package com.company.statemodel.city.children;

import com.company.statemodel.city.City;

public class Capital extends City {

    /* Класс описывает столицу. */

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