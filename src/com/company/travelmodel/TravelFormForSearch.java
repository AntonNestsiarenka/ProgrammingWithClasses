package com.company.travelmodel;

public class TravelFormForSearch {

    private String travelCountry;
    private String travelCity;
    private Integer numberOfDays;
    private TypeOfTravelVoucher typeOfTravelVoucher;
    private TypeOfTransport typeOfTransport;
    private TypeOfFood typeOfFood;
    private Double price; // USD

    public TravelFormForSearch()
    {
        travelCountry = null;
        travelCity = null;
        numberOfDays = null;
        typeOfTravelVoucher = null;
        typeOfTransport = null;
        typeOfFood = null;
        price = null;
    }

    public void setTravelCountry(String travelCountry) {
        this.travelCountry = travelCountry;
    }

    public void setTravelCity(String travelCity) {
        this.travelCity = travelCity;
    }

    public void setNumberOfDays(Integer numberOfDays) {
        this.numberOfDays = numberOfDays;
    }

    public void setTypeOfTravelVoucher(TypeOfTravelVoucher typeOfTravelVoucher) {
        this.typeOfTravelVoucher = typeOfTravelVoucher;
    }

    public void setTypeOfTransport(TypeOfTransport typeOfTransport) {
        this.typeOfTransport = typeOfTransport;
    }

    public void setTypeOfFood(TypeOfFood typeOfFood) {
        this.typeOfFood = typeOfFood;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getTravelCountry() {
        return travelCountry;
    }

    public String getTravelCity() {
        return travelCity;
    }

    public Integer getNumberOfDays() {
        return numberOfDays;
    }

    public TypeOfTravelVoucher getTypeOfTravelVoucher() {
        return typeOfTravelVoucher;
    }

    public TypeOfTransport getTypeOfTransport() {
        return typeOfTransport;
    }

    public TypeOfFood getTypeOfFood() {
        return typeOfFood;
    }

    public Double getPrice() {
        return price;
    }

    public void clearForm()
    {
        travelCountry = null;
        travelCity = null;
        numberOfDays = null;
        typeOfTravelVoucher = null;
        typeOfTransport = null;
        typeOfFood = null;
        price = null;
    }
}