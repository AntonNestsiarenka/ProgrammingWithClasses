package com.company.carmodel;

public class Disc {

    private TypeOfDisc typeOfDisc;
    private String manufacturer;
    private double width; // в дюймах.
    private double externalDiameter; // в дюймах.
    private String pcd; // крепление к ступице.
    private int et; // вылет в мм.
    private double centerHoleDiameter; // диаметр центрального отверстия в мм.
    private boolean isBroken = false;

    public Disc()
    {
        typeOfDisc = TypeOfDisc.ALLOY;
        manufacturer = "LS Wheels";
        width = 6.5;
        externalDiameter = 17;
        pcd = "5x112";
        et = 42;
        centerHoleDiameter = 57.1;
    }

    public Disc(TypeOfDisc typeOfDisc, String manufacturer, double width, double externalDiameter, String pcd, int et, double centerHoleDiameter)
    {
        this.typeOfDisc = typeOfDisc;
        this.manufacturer = manufacturer;
        this.width = width;
        this.externalDiameter = externalDiameter;
        this.pcd = pcd;
        this.et = et;
        this.centerHoleDiameter = centerHoleDiameter;
    }

    public TypeOfDisc getTypeOfDisc() {
        return typeOfDisc;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public double getWidth() {
        return width;
    }

    public double getExternalDiameter() {
        return externalDiameter;
    }

    public String getPcd() {
        return pcd;
    }

    public int getEt() {
        return et;
    }

    public double getCenterHoleDiameter() {
        return centerHoleDiameter;
    }

    public boolean isBroken() {
        return isBroken;
    }

    public void setBroken(boolean broken) {
        isBroken = broken;
    }

    @Override
    public String toString() {
        return "Disc {" +
                "typeOfDisc=" + typeOfDisc +
                ", manufacturer='" + manufacturer + '\'' +
                ", width=" + width +
                ", externalDiameter=" + externalDiameter +
                ", pcd='" + pcd + '\'' +
                ", et=" + et +
                ", centerHoleDiameter=" + centerHoleDiameter +
                ", isBroken=" + isBroken +
                '}';
    }
}