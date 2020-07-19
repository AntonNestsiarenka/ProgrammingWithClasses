package com.company.statemodel.city;

public abstract class City {

    /* Класс описывает абстрактный населенный пункт. */

    private String name;
    private long population;
    private int yearOfFoundation;
    private double area;

    public City()
    {
        name = "";
        population = 0;
        yearOfFoundation = 0;
        area = 0;
    }

    public City(String name, long population, int yearOfFoundation, double area) {
        this.name = name;
        this.population = population;
        this.yearOfFoundation = yearOfFoundation;
        this.area = area;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getPopulation() {
        return population;
    }

    public void setPopulation(long population) {
        this.population = population;
    }

    public int getYearOfFoundation() {
        return yearOfFoundation;
    }

    public void setYearOfFoundation(int yearOfFoundation) {
        this.yearOfFoundation = yearOfFoundation;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public abstract void printInfo();

    public abstract String toString();
}
