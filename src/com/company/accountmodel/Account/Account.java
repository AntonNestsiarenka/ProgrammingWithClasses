package com.company.accountmodel.Account;

import com.company.accountmodel.Person.children.ClientOfBank;

public class Account {

    /* Класс описывает счет клиента банка. */

    private static long idUnique = 0;

    private long id;
    private String currency;
    private ClientOfBank clientOfBank;
    private double balance;
    private boolean isLocked;

    public Account(String currency, ClientOfBank clientOfBank) {
        id = idUnique++;
        this.currency = currency;
        this.clientOfBank = clientOfBank;
        balance = 0;
        isLocked = false;
    }

    public Account(String currency, ClientOfBank clientOfBank, double balance) {
        id = idUnique++;
        this.currency = currency;
        this.clientOfBank = clientOfBank;
        this.balance = balance;
        isLocked = false;
    }

    public static long getIdUnique() {
        return idUnique;
    }

    public long getId() {
        return id;
    }

    public String getCurrency() {
        return currency;
    }

    public ClientOfBank getClientOfBank() {
        return clientOfBank;
    }

    public double getBalance() {
        return balance;
    }

    public boolean isLocked() {
        return isLocked;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public void setClientOfBank(ClientOfBank clientOfBank) {
        this.clientOfBank = clientOfBank;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void blockAccount()
    {
        isLocked = true;
    }

    public void unblockAccount()
    {
        isLocked = false;
    }

    public void replenishBalance(double money)
    {
        balance += money;
    }

    public void reduceBalance(double money)
    {
        balance -= money;
    }

    @Override
    public String toString()
    {
        return "Номер счета: " + id
                + ". Тип валюта: " + currency
                + ". Текущий баланс: " + balance
                + ". Блокировка: " + isLocked
                + ". Данные клиента: " + clientOfBank.toString();
    }

    public void printInfo()
    {
        System.out.println(toString());
    }
}