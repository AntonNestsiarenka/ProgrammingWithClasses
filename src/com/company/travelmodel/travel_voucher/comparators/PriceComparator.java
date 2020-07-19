package com.company.travelmodel.travel_voucher.comparators;

import com.company.travelmodel.travel_voucher.TravelVoucher;

import java.util.Comparator;

public class PriceComparator implements Comparator<TravelVoucher> {

    /* Компаратор для сравнения туристических путевок по цене. */

    @Override
    public int compare(TravelVoucher o1, TravelVoucher o2) {
        return Double.compare(o1.getPrice(), o2.getPrice());
    }
}