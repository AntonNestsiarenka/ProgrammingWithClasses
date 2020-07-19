package com.company.travelmodel.travel_voucher.comparators;

import com.company.travelmodel.travel_voucher.TravelVoucher;

import java.util.Comparator;

public class NumberOfDaysComparator implements Comparator<TravelVoucher> {

    /* Компаратор для сравнения туристических путевок по количеству дней. */

    @Override
    public int compare(TravelVoucher o1, TravelVoucher o2) {
        return o1.getNumberOfDays() - o2.getNumberOfDays();
    }
}