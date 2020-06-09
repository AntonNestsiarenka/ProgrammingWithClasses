package com.company.travelmodel;

import com.company.accountmodel.Person;
import com.company.accountmodel.Sex;
import com.company.travelmodel.comparators.NumberOfDaysComparator;
import com.company.travelmodel.comparators.PriceComparator;

import java.util.ArrayList;

public class ClientOfTravelAgency extends Person implements FormFilling, InteractionWithATravelAgency{

    private static long idUnique = 0;

    private long id;
    private TravelFormForSearch travelFormForSearch;
    private ArrayList<TravelVoucher> offers;

    public ClientOfTravelAgency()
    {
        id = idUnique++;
        travelFormForSearch = new TravelFormForSearch();
        offers = new ArrayList<TravelVoucher>();
    }

    public ClientOfTravelAgency(String surname, String name, String patronymic, int age, Sex sex) {
        super(surname, name, patronymic, age, sex);
        id = idUnique++;
        travelFormForSearch = new TravelFormForSearch();
        offers = new ArrayList<TravelVoucher>();
    }

    public static long getIdUnique() {
        return idUnique;
    }

    public long getId() {
        return id;
    }

    public TravelFormForSearch getTravelFormForSearch() {
        return travelFormForSearch;
    }

    public void setTravelFormForSearch(TravelFormForSearch travelFormForSearch) {
        this.travelFormForSearch = travelFormForSearch;
    }

    public ArrayList<TravelVoucher> getOffers() {
        return offers;
    }

    @Override
    public void setTravelCountryToForm(String travelCountry)
    {
        travelFormForSearch.setTravelCountry(travelCountry);
    }

    @Override
    public void setTravelCityToForm(String travelCity)
    {
        travelFormForSearch.setTravelCity(travelCity);
    }

    @Override
    public void setNumberOfDaysToForm(Integer numberOfDays)
    {
        travelFormForSearch.setNumberOfDays(numberOfDays);
    }

    @Override
    public void setTypeOfTravelVoucherToForm(TypeOfTravelVoucher typeOfTravelVoucher)
    {
        travelFormForSearch.setTypeOfTravelVoucher(typeOfTravelVoucher);
    }

    @Override
    public void setTypeOfTransportToForm(TypeOfTransport typeOfTransport)
    {
        travelFormForSearch.setTypeOfTransport(typeOfTransport);
    }

    @Override
    public void setTypeOfFoodToForm(TypeOfFood typeOfFood)
    {
        travelFormForSearch.setTypeOfFood(typeOfFood);
    }

    @Override
    public void setPriceToForm(Double price)
    {
        travelFormForSearch.setPrice(price);
    }

    @Override
    public void clearForm() {
        travelFormForSearch.clearForm();
    }

    @Override
    public void getOffersFromTravelAgency(TravelAgency travelAgency) {
        offers = travelAgency.generateOffersAccordingToClientRequest(travelFormForSearch);
    }

    public void sortOffersByPrice()
    {
        offers.sort(new PriceComparator());
    }

    public void sortOffersByNumberOfDays()
    {
        offers.sort(new NumberOfDaysComparator());
    }

    public void printOffers()
    {
        for (TravelVoucher travelVoucher : offers)
        {
            System.out.println(travelVoucher.toString());
        }
    }

    @Override
    public String toString() {
        return "Клиент: " + id
                + ". Фамилия: " + getSurname()
                + ". Имя: " + getName()
                + ". Отчество: " + getPatronymic()
                + ". Возраст: " + getAge()
                + ". Пол: " + getSex().toString();
    }

    @Override
    public void printInfo() {
        System.out.println(toString());
    }
}