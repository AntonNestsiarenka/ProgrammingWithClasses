package com.company.customermodel.comparators;

import com.company.customermodel.Customer;

import java.util.Comparator;

public class SurnameComparator implements Comparator<Customer> {

    @Override
    public int compare(Customer o1, Customer o2) {
        return o1.getSurname().compareTo(o2.getSurname());
    }
}
