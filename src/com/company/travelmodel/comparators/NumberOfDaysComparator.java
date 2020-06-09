package com.company.travelmodel.comparators;

import com.company.travelmodel.TravelVoucher;

import java.util.Comparator;

public class NumberOfDaysComparator implements Comparator<TravelVoucher> {

    @Override
    public int compare(TravelVoucher o1, TravelVoucher o2) {
        return o1.getNumberOfDays() - o2.getNumberOfDays();
    }
}