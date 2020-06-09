package com.company.carmodel;

public class Tire {

    private String manufacturer;
    private String model;
    private int profileWidth; // в мм.
    private int profileHeight; // в %.
    private double discDiameter; // в дюймах.
    private boolean isBroken = false;

    public Tire()
    {
        manufacturer = "Michelin";
        model = "Primacy 4";
        profileWidth = 225;
        profileHeight = 50;
        discDiameter = 17;
    }

    public Tire(String manufacturer, String model, int profileWidth, int profileHeight, double discDiameter)
    {
        this.manufacturer = manufacturer;
        this.model = model;
        this.profileWidth = profileWidth;
        this.profileHeight = profileHeight;
        this.discDiameter = discDiameter;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public String getModel() {
        return model;
    }

    public int getProfileWidth() {
        return profileWidth;
    }

    public int getProfileHeight() {
        return profileHeight;
    }

    public double getDiscDiameter() {
        return discDiameter;
    }

    public boolean isBroken() {
        return isBroken;
    }

    public void setBroken(boolean broken) {
        isBroken = broken;
    }

    @Override
    public String toString() {
        return "Tire {" +
                "manufacturer='" + manufacturer + '\'' +
                ", model='" + model + '\'' +
                ", profileWidth=" + profileWidth +
                ", profileHeight=" + profileHeight +
                ", discDiameter=" + discDiameter +
                ", isBroken=" + isBroken +
                '}';
    }
}