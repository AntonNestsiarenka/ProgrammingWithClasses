package com.company.travelmodel.travel_agency;

import com.company.travelmodel.client.travel_form.TravelFormForSearch;
import com.company.travelmodel.travel_voucher.comparators.NumberOfDaysComparator;
import com.company.travelmodel.travel_voucher.comparators.PriceComparator;
import com.company.travelmodel.travel_voucher.TravelVoucher;

import java.util.ArrayList;

public final class TravelAgency {

    /* Класс описывает туристическое агенство. */

    private String name;
    private ArrayList<TravelVoucher> travelVouchers;

    public TravelAgency()
    {
        name = "";
        travelVouchers = new ArrayList<TravelVoucher>();
    }

    public TravelAgency(String name, ArrayList<TravelVoucher> travelVouchers) {
        this.name = name;
        this.travelVouchers = travelVouchers;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<TravelVoucher> getTravelVouchers() {
        return travelVouchers;
    }

    public void setTravelVouchers(ArrayList<TravelVoucher> travelVouchers) {
        this.travelVouchers = travelVouchers;
    }

    public void addTravelVoucher(TravelVoucher travelVoucher)
    {
        travelVouchers.add(travelVoucher);
    }

    public void addTravelVouchers(TravelVoucher...travelVouchers)
    {
        for (TravelVoucher travelVoucher : travelVouchers)
        {
            addTravelVoucher(travelVoucher);
        }
    }

    public void clearTravelVouchers()
    {
        travelVouchers.clear();
    }

    public void removeTravelVoucher(TravelVoucher travelVoucher)
    {
        travelVouchers.remove(travelVoucher);
    }

    public ArrayList<TravelVoucher> generateOffersAccordingToClientRequest(TravelFormForSearch travelFormForSearch)
    {
        ArrayList<TravelVoucher> offers = new ArrayList<TravelVoucher>();
        for (TravelVoucher travelVoucher : travelVouchers)
        {
            if (isTravelVoucherSatisfiesRequirements(travelVoucher, travelFormForSearch))
            {
                offers.add(travelVoucher);
            }
        }
        return offers;
    }

    public void sortTravelVouchersByPriceAscending()
    {
        travelVouchers.sort(new PriceComparator());
    }

    public void sortTravelVouchersByNumberOfDaysAscending()
    {
        travelVouchers.sort(new NumberOfDaysComparator());
    }

    public void printInfoAllTravelVouchers()
    {
        for (TravelVoucher travelVoucher : travelVouchers)
        {
            System.out.println(travelVoucher.toString());
        }
    }

    private static boolean isTravelVoucherSatisfiesRequirements(TravelVoucher travelVoucher, TravelFormForSearch requirements)
    {
        if (requirements.getTravelCountry() != null)
        {
            if (travelVoucher.getTravelCountry().compareToIgnoreCase(requirements.getTravelCountry()) != 0)
                return false;
        }
        if (requirements.getTravelCity() != null)
        {
            if (travelVoucher.getTravelCity().compareToIgnoreCase(requirements.getTravelCity()) != 0)
                return false;
        }
        if (requirements.getNumberOfDays() != null)
        {
            if (travelVoucher.getNumberOfDays() > requirements.getNumberOfDays())
                return false;
        }
        if (requirements.getTypeOfTravelVoucher() != null)
        {
            if (travelVoucher.getTypeOfTravelVoucher().getNameOfType().compareToIgnoreCase(requirements.getTypeOfTravelVoucher().getNameOfType()) != 0)
                return false;
        }
        if (requirements.getTypeOfTransport() != null)
        {
            if (travelVoucher.getTypeOfTransport().getTypeOfTransport().compareToIgnoreCase(requirements.getTypeOfTransport().getTypeOfTransport()) != 0)
                return false;
        }
        if (requirements.getTypeOfFood() != null)
        {
            if (travelVoucher.getTypeOfFood().getNumberOFTypeOfFood() != requirements.getTypeOfFood().getNumberOFTypeOfFood())
                return false;
        }
        if (requirements.getPrice() != null)
        {
            if (travelVoucher.getPrice() > requirements.getPrice())
                return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "TravelAgency{" +
                "name='" + name + '\'' +
                ", travelVouchers=" + travelVouchers +
                '}';
    }
}