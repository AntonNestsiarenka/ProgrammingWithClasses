package com.company.carmodel.wheel;

public final class Tire {

    /* Класс описывает шину для колеса. */

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

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setProfileWidth(int profileWidth) {
        this.profileWidth = profileWidth;
    }

    public void setProfileHeight(int profileHeight) {
        this.profileHeight = profileHeight;
    }

    public void setDiscDiameter(double discDiameter) {
        this.discDiameter = discDiameter;
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