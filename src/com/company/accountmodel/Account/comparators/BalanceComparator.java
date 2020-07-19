package com.company.accountmodel.Account.comparators;

import com.company.accountmodel.Account.Account;

import java.util.Comparator;

public class BalanceComparator implements Comparator<Account> {

    /* Компаратор для сравнения счетов по балансу. */

    @Override
    public int compare(Account o1, Account o2) {
        return Double.compare(o1.getBalance(), o2.getBalance());
    }
}
