package com.company.accountmodel.comparators;

import com.company.accountmodel.Account;

import java.util.Comparator;

public class BalanceComparator implements Comparator<Account> {

    @Override
    public int compare(Account o1, Account o2) {
        return Double.compare(o1.getBalance(), o2.getBalance());
    }
}
