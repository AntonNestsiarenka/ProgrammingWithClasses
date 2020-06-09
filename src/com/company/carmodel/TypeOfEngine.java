package com.company.carmodel;

public enum TypeOfEngine {

    PETROL("Petrol"),
    DIESEL("Diesel");

    private String typeOfEngine;

    TypeOfEngine()
    {
        typeOfEngine = "Petrol";
    }

    TypeOfEngine(String typeOfEngine)
    {
        this.typeOfEngine = typeOfEngine;
    }

    public String getTypeOfEngine() {
        return typeOfEngine;
    }

    @Override
    public String toString() {
        return "TypeOfEngine {" +
                "typeOfEngine='" + typeOfEngine + '\'' +
                '}';
    }
}
