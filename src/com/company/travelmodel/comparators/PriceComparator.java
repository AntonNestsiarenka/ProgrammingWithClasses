package com.company.travelmodel.comparators;

import com.company.travelmodel.TravelVoucher;

import java.util.Comparator;

public class PriceComparator implements Comparator<TravelVoucher> {

    @Override
    public int compare(TravelVoucher o1, TravelVoucher o2) {
        return Double.compare(o1.getPrice(), o2.getPrice());
    }
}