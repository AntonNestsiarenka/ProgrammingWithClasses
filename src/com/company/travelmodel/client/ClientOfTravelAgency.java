package com.company.travelmodel.client;

import com.company.accountmodel.Person.Person;
import com.company.accountmodel.Person.Sex;
import com.company.travelmodel.client.travel_form.TravelFormForSearch;
import com.company.travelmodel.client.interfaces.FormFilling;
import com.company.travelmodel.client.interfaces.InteractionWithATravelAgency;
import com.company.travelmodel.travel_voucher.comparators.NumberOfDaysComparator;
import com.company.travelmodel.travel_voucher.comparators.PriceComparator;
import com.company.travelmodel.travel_agency.TravelAgency;
import com.company.travelmodel.travel_voucher.TravelVoucher;
import com.company.travelmodel.travel_voucher.TypeOfFood;
import com.company.travelmodel.travel_voucher.TypeOfTransport;
import com.company.travelmodel.travel_voucher.TypeOfTravelVoucher;

import java.util.ArrayList;

public final class ClientOfTravelAgency extends Person implements FormFilling, InteractionWithATravelAgency {

    /* Класс описывает клиента туристического агенства. */

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