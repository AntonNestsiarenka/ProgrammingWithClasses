package com.company.carmodel.person;

public abstract class Person {

    /* Класс описывает абстрактного человека. */

    private String name;
    private double weight; // в кг.

    public Person()
    {
        name = "Alex";
        weight = 75;
    }

    public Person(String name, double weight)
    {
        this.name = name;
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public double getWeight() {
        return weight;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    @Override
    public abstract String toString();
}