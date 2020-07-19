package com.company.carmodel.engine;

public final class Engine {

    /* Класс описывает ДВС для автомобиля. */

    private String manufacturer;
    private String model;
    private int year;
    private long number;
    private TypeOfEngine typeOfEngine; //дизель или бензин
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

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setNumber(long number) {
        this.number = number;
    }

    public void setTypeOfEngine(TypeOfEngine typeOfEngine) {
        this.typeOfEngine = typeOfEngine;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public void setPower(double power) {
        this.power = power;
    }

    public void setTorque(double torque) {
        this.torque = torque;
    }

    public void setFuelConsumption(double fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }

    public void setTurbo(boolean turbo) {
        isTurbo = turbo;
    }

    public void setRun(boolean run) {
        if (!isBroken) {
            isRun = run;
        }
    }

    public void setBroken(boolean broken) {
        isBroken = broken;
    }

    public void setStopAutomatic()
    {
        isRun = false;
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