package com.company.carmodel.engine;

public enum TypeOfEngine {

    PETROL("Petrol", 1.2),
    DIESEL("Diesel", 1);

    private String typeOfEngine;
    private double multiplierOfFuelConsumptionIdle;

    TypeOfEngine(String typeOfEngine, double multiplierOfFuelConsumptionIdle)
    {
        this.typeOfEngine = typeOfEngine;
        this.multiplierOfFuelConsumptionIdle = multiplierOfFuelConsumptionIdle;
    }

    public String getTypeOfEngine() {
        return typeOfEngine;
    }

    public double getMultiplierOfFuelConsumptionIdle() {
        return multiplierOfFuelConsumptionIdle;
    }

    @Override
    public String toString() {
        return typeOfEngine;
    }
}
