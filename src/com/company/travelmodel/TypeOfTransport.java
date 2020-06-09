package com.company.travelmodel;

public enum TypeOfTransport {

    AVIA("Самолет"),
    BUS("Автобус"),
    TRAIN("Поезд"),
    SHIP("Корабль");

    private String typeOfTransport;

    TypeOfTransport()
    {
        typeOfTransport = "Самолет";
    }

    TypeOfTransport(String typeOfTransport)
    {
        this.typeOfTransport = typeOfTransport;
    }

    public String getTypeOfTransport() {
        return typeOfTransport;
    }

    @Override
    public String toString() {
        return "Тип транспорта: "
                + typeOfTransport;
    }

    public void printInfo()
    {
        System.out.println(toString());
    }
}