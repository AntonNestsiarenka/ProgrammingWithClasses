package com.company.travelmodel.travel_voucher;

public final class TravelVoucher {

    /* Класс описывает туристическую путевку. */

    private static long idUnique = 0;

    private final long id;
    private String name;
    private String description;
    private String travelCountry;
    private String travelCity;
    private int numberOfDays;
    private TypeOfTravelVoucher typeOfTravelVoucher;
    private TypeOfTransport typeOfTransport;
    private TypeOfFood typeOfFood;
    private double price; // USD

    public TravelVoucher()
    {
        id = idUnique++;
        name = "";
        description = "";
        travelCountry = "";
        travelCity = "";
        numberOfDays = 0;
        typeOfTravelVoucher = TypeOfTravelVoucher.RECREATION;
        typeOfTransport = TypeOfTransport.AVIA;
        typeOfFood = TypeOfFood.ALLINCLUSIVE;
        price = 0;
    }

    public TravelVoucher(String name, String description, String travelCountry, String travelCity, int numberOfDays, TypeOfTravelVoucher typeOfTravelVoucher, TypeOfTransport typeOfTransport, TypeOfFood typeOfFood, double price) {
        this.id = idUnique++;
        this.name = name;
        this.description = description;
        this.travelCountry = travelCountry;
        this.travelCity = travelCity;
        this.numberOfDays = numberOfDays;
        this.typeOfTravelVoucher = typeOfTravelVoucher;
        this.typeOfTransport = typeOfTransport;
        this.typeOfFood = typeOfFood;
        this.price = price;
    }

    public long getId() {
        return id;
    }

    public static long getIdUnique() {
        return idUnique;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTravelCountry() {
        return travelCountry;
    }

    public void setTravelCountry(String travelCountry) {
        this.travelCountry = travelCountry;
    }

    public String getTravelCity() {
        return travelCity;
    }

    public void setTravelCity(String travelCity) {
        this.travelCity = travelCity;
    }

    public int getNumberOfDays() {
        return numberOfDays;
    }

    public void setNumberOfDays(int numberOfDays) {
        this.numberOfDays = numberOfDays;
    }

    public TypeOfTravelVoucher getTypeOfTravelVoucher() {
        return typeOfTravelVoucher;
    }

    public void setTypeOfTravelVoucher(TypeOfTravelVoucher typeOfTravelVoucher) {
        this.typeOfTravelVoucher = typeOfTravelVoucher;
    }

    public TypeOfTransport getTypeOfTransport() {
        return typeOfTransport;
    }

    public void setTypeOfTransport(TypeOfTransport typeOfTransport) {
        this.typeOfTransport = typeOfTransport;
    }

    public TypeOfFood getTypeOfFood() {
        return typeOfFood;
    }

    public void setTypeOfFood(TypeOfFood typeOfFood) {
        this.typeOfFood = typeOfFood;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Туристическая путевка: " + id +
                ". Название тура: " + name +
                ". Описание: " + description +
                ". Страна: " + travelCountry +
                ". Город: " + travelCity +
                ". Количество дней: " + numberOfDays +
                ". " + typeOfTravelVoucher.toString() +
                ". " + typeOfTransport.toString() +
                ". " + typeOfFood.toString() +
                ". Цена: " + price + " USD";
    }

    public void printInfo()
    {
        System.out.println(toString());
    }
}