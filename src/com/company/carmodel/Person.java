package com.company.carmodel;

import Utils.MyException;

public class Person {

    private String name;
    private String numberOfPassport;
    private double weight; // в кг.

    public Person()
    {
        name = "Alex";
        numberOfPassport = "HB2371833";
        weight = 75;
    }

    public Person(String name, String numberOfPassport, double weight)
    {
        this.name = name;
        this.numberOfPassport = numberOfPassport;
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public String getNumberOfPassport() {
        return numberOfPassport;
    }

    public double getWeight() {
        return weight;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNumberOfPassport(String numberOfPassport) {
        this.numberOfPassport = numberOfPassport;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public void startTheCarEngine(Car car)
    {
        if (car.getDriver() == this)
        {
            car.start();
        }
    }

    public void ToGoOnCar(Car car, double acceleration) throws MyException {
        if (car.getDriver() == this && car.isRun())
        {
            car.setAccelerator(acceleration);
        }
    }

    public void stopTheCarEngine(Car car)
    {
        if (car.getDriver() == this)
        {
            car.stop();
        }
    }

    public void tryToSeatToCarAsADriver(Car car)
    {
        car.setDriver(this);
    }

    public void getOutOfTheCarAsADriver(Car car)
    {
        car.removeDriver(this);
    }

    public void getOutOfTheCarAsAPassenger(Car car)
    {
        car.removePassenger(this);
    }

    public void tryToSeatToCarAsAPassenger(Car car)
    {
        car.addPassenger(this);
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", numberOfPassport='" + numberOfPassport + '\'' +
                ", weight=" + weight +
                '}';
    }
}