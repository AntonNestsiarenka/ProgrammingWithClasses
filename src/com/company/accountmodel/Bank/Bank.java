package com.company.accountmodel.Bank;

import com.company.accountmodel.Account.Account;
import com.company.accountmodel.Person.children.ClientOfBank;
import com.company.accountmodel.Account.comparators.BalanceComparator;
import Utils.MyException;

import java.util.ArrayList;

public class Bank {

    /* Класс описывает банк со счетами клиентов. */

    private String name;
    private ArrayList<Account> accounts;

    public Bank()
    {
        name = "";
        accounts = new ArrayList<Account>();
    }

    public Bank(String name) {
        this.name = name;
        accounts = new ArrayList<Account>();
    }

    public Bank(String name, ArrayList<Account> accounts) {
        this.name = name;
        this.accounts = accounts;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(ArrayList<Account> accounts) {
        this.accounts = accounts;
    }

    public void createAccount(String currency, ClientOfBank clientOfBank, double startBalance)
    {
        addAccount(new Account(currency, clientOfBank, startBalance));
    }

    public void createAccount(String currency, ClientOfBank clientOfBank)
    {
        addAccount(new Account(currency, clientOfBank));
    }

    public void removeAccount(Account account)
    {
        accounts.remove(account);
    }

    public void removeAllAccountsOfClient(ClientOfBank clientOfBank)
    {
        for (Account account : getAllAccountsOfClient(clientOfBank))
        {
            removeAccount(account);
        }
    }

    public void addAccount(Account account)
    {
        accounts.add(account);
    }

    public ArrayList<Account> getAllAccountsOfClient(ClientOfBank clientOfBank)
    {
        ArrayList<Account> accounts = new ArrayList<Account>();
        for (Account account : this.accounts)
        {
            if (account.getClientOfBank().getId() == clientOfBank.getId())
                accounts.add(account);
        }
        return accounts;
    }

    public Account getAccountById(long idNumber) throws MyException {
        for (Account account : accounts)
        {
            if (account.getId() == idNumber)
                return account;
        }
        throw new MyException("Счет с заданным номером не найден в списке счетов банка.");
    }

    public ArrayList<Account> getAllAccountsByCurrency(String currency)
    {
        ArrayList<Account> newAccounts = new ArrayList<Account>();
        for (Account account : accounts)
        {
            if (account.getCurrency().equalsIgnoreCase(currency))
                newAccounts.add(account);
        }
        return newAccounts;
    }

    public ArrayList<Account> getAllBlockedAccounts()
    {
        ArrayList<Account> newAccounts = new ArrayList<Account>();
        for (Account account : accounts)
        {
            if (account.isLocked())
                newAccounts.add(account);
        }
        return newAccounts;
    }

    public ArrayList<Account> getAllUnBlockedAccounts()
    {
        ArrayList<Account> newAccounts = new ArrayList<Account>();
        for (Account account : accounts)
        {
            if (!account.isLocked())
                newAccounts.add(account);
        }
        return newAccounts;
    }

    public ArrayList<Account> getAllBlockedAccountsOfClient(ClientOfBank clientOfBank)
    {
        ArrayList<Account> accountsOfClient = getAllAccountsOfClient(clientOfBank);
        ArrayList<Account> blockedAccounts = new ArrayList<Account>();
        for (Account account : accountsOfClient)
        {
            if (account.isLocked())
                blockedAccounts.add(account);
        }
        return blockedAccounts;
    }

    public ArrayList<Account> getAllUnBlockedAccountsOfClient(ClientOfBank clientOfBank)
    {
        ArrayList<Account> accountsOfClient = getAllAccountsOfClient(clientOfBank);
        ArrayList<Account> unBlockedAccounts = new ArrayList<Account>();
        for (Account account : accountsOfClient)
        {
            if (!account.isLocked())
                unBlockedAccounts.add(account);
        }
        return unBlockedAccounts;
    }

    public void addBalanceToAccount(long idNumber, double value) throws MyException {
        Account account = getAccountById(idNumber);
        account.replenishBalance(value);
    }

    public void withdrawBalanceFromAccount(long idNumber, double value) throws MyException {
        Account account = getAccountById(idNumber);
        account.reduceBalance(value);
    }

    public void blockAccount(long idNumber) throws MyException {
        Account account = getAccountById(idNumber);
        account.blockAccount();
    }

    public void unblockAccount(long idNumber) throws MyException {
        Account account = getAccountById(idNumber);
        account.unblockAccount();
    }

    public void printCommonSumAllAccountsOfClient(ClientOfBank clientOfBank)
    {
        // Вывод в консоль общих сумм счетов клиента по всем типам валют.
        ArrayList<Account> clientAccounts = getAllAccountsOfClient(clientOfBank);
        int i = 0;
        while (i < clientAccounts.size()) {
            double commonSum = clientAccounts.get(i).getBalance();
            for (int j = clientAccounts.size() - 1; j > i; j--)
            {
                if (clientAccounts.get(i).getCurrency().compareToIgnoreCase(clientAccounts.get(j).getCurrency()) == 0)
                {
                    commonSum += clientAccounts.get(j).getBalance();
                    clientAccounts.remove(j);
                }
            }
            System.out.printf("Сумма счетов клиента в валюте %s: %f\n", clientAccounts.get(i).getCurrency(), commonSum);
            i++;
        }
    }

    public void printCommonSumAllAccountsOfClientWithPositiveBalance(ClientOfBank clientOfBank)
    {
        //  Вывод в консоль общих сумм счетов клиента по всем типам валют с положительным балансом.
        ArrayList<Account> clientAccounts = getAllAccountsOfClient(clientOfBank);
        int i = 0;
        while (i < clientAccounts.size()) {
            double commonSum = 0;
            if (clientAccounts.get(i).getBalance() >= 0)
                commonSum = clientAccounts.get(i).getBalance();
            for (int j = clientAccounts.size() - 1; j > i; j--)
            {
                if (clientAccounts.get(i).getCurrency().compareToIgnoreCase(clientAccounts.get(j).getCurrency()) == 0)
                {
                    if (clientAccounts.get(j).getBalance() >= 0)
                        commonSum += clientAccounts.get(j).getBalance();
                    clientAccounts.remove(j);
                }
            }
            System.out.printf("Сумма счетов клиента c положительным балансом в валюте %s: %f\n", clientAccounts.get(i).getCurrency(), commonSum);
            i++;
        }
    }

    public void printCommonSumAllAccountsOfClientWithNegativeBalance(ClientOfBank clientOfBank)
    {
        //  Вывод в консоль общих сумм счетов клиента по всем типам валют с отрицательным балансом.
        ArrayList<Account> clientAccounts = getAllAccountsOfClient(clientOfBank);
        int i = 0;
        while (i < clientAccounts.size()) {
            double commonSum = 0;
            if (clientAccounts.get(i).getBalance() < 0)
                commonSum = clientAccounts.get(i).getBalance();
            for (int j = clientAccounts.size() - 1; j > i; j--)
            {
                if (clientAccounts.get(i).getCurrency().compareToIgnoreCase(clientAccounts.get(j).getCurrency()) == 0)
                {
                    if (clientAccounts.get(j).getBalance() < 0)
                        commonSum += clientAccounts.get(j).getBalance();
                    clientAccounts.remove(j);
                }
            }
            System.out.printf("Сумма счетов клиента с отрицательным балансом в валюте %s: %f\n", clientAccounts.get(i).getCurrency(), Math.abs(commonSum));
            i++;
        }
    }

    public void sortAllAccountsByBalanceAscending()
    {
        accounts.sort(new BalanceComparator());
    }

    public ArrayList<Account> sortAccountsOfClientByBalanceAscending(ClientOfBank clientOfBank)
    {
        ArrayList<Account> clientAccounts = getAllAccountsOfClient(clientOfBank);
        clientAccounts.sort(new BalanceComparator());
        return clientAccounts;
    }

    public void printInfoAllAccounts()
    {
        for (Account account : accounts)
        {
            account.printInfo();
            System.out.println();
        }
    }

    public static void printInfoAccounts(ArrayList<Account> accounts)
    {
        for (Account account : accounts)
        {
            account.printInfo();
            System.out.println();
        }
    }
}