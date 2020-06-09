package com.company.airlinemodel.comparators;

import com.company.airlinemodel.Airline;

import java.util.Comparator;

public class DestinationNameComparator implements Comparator<Airline> {

    @Override
    public int compare(Airline o1, Airline o2) {

        return o1.getDestinationName().compareTo(o2.getDestinationName());
    }
}
