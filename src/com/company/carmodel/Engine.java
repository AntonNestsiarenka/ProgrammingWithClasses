package com.company.carmodel;

public class Engine {

    private String manufacturer;
    private String model;
    private int year;
    private long number;
    private TypeOfEngine typeOfEngine;
    private int volume; // см3
    private double power; // кВт
    private double torque; // Н*м
    private double fuelConsumption; // л на 100 км.
    private boolean isTurbo;
    private boolean isBroken = false;
    private boolean isRun = false;

    public Engine()
    {
        this.manufacturer = "Toyota";
        this.model = "2GRFE";
        this.year = 2007;
        this.number = 15498602;
        this.typeOfEngine = TypeOfEngine.PETROL;
        this.volume = 3456;
        this.power = 183;
        this.torque = 332;
        this.fuelConsumption = 14.7;
        this.isTurbo = false;
    }

    public Engine(String manufacturer, String model, int year, long number, TypeOfEngine typeOfEngine, int volume, double power, double torque, double fuelConsumption, boolean isTurbo) {
        this.manufacturer = manufacturer;
        this.model = model;
        this.year = year;
        this.number = number;
        this.typeOfEngine = typeOfEngine;
        this.volume = volume;
        this.power = power;
        this.torque = torque;
        this.fuelConsumption = fuelConsumption;
        this.isTurbo = isTurbo;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public String getModel() {
        return model;
    }

    public int getYear() {
        return year;
    }

    public long getNumber() {
        return number;
    }

    public TypeOfEngine getTypeOfEngine() {
        return typeOfEngine;
    }

    public int getVolume() {
        return volume;
    }

    public double getPower() {
        return power;
    }

    public double getTorque() {
        return torque;
    }

    public double getFuelConsumption() {
        return fuelConsumption;
    }

    public double getPowerInHP()
    {
        return toHorsePower();
    }

    public boolean isTurbo() {
        return isTurbo;
    }

    public boolean isBroken() {
        return isBroken;
    }

    public boolean isRun() {
        return isRun;
    }

    public void setRun(boolean run) {
        if (!isBroken) {
            isRun = run;
        }
    }

    public void setStopAutomatic()
    {
        isRun = false;
    }

    public void setBroken(boolean broken) {
        isBroken = broken;
    }

    public double toHorsePower()
    {
        return power * 1.3596;
    }

    @Override
    public String toString() {
        return "Engine {" +
                "manufacturer='" + manufacturer + '\'' +
                ", model='" + model + '\'' +
                ", year=" + year +
                ", number=" + number +
                ", typeOfEngine=" + typeOfEngine +
                ", volume=" + volume +
                ", power=" + power +
                ", torque=" + torque +
                ", isTurbo=" + isTurbo +
                '}';
    }
}