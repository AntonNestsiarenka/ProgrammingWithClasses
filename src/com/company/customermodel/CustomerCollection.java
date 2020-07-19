package com.company.customermodel;

import java.util.ArrayList;

public class CustomerCollection {

    /* Колекция покупателей. */

    private ArrayList<Customer> customers = new ArrayList<>();

    public CustomerCollection(Customer customer)
    {
        addCustomerToCollection(customer);
    }

    public CustomerCollection(Customer...customers)
    {
        for (Customer customer : customers)
        {
            addCustomerToCollection(customer);
        }
    }

    public CustomerCollection(ArrayList<Customer> customers)
    {
        this.customers = customers;
    }

    public ArrayList<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(ArrayList<Customer> customers) {
        this.customers = customers;
    }

    public void addCustomerToCollection(Customer customer)
    {
        //Добавление покупателя в коллекцию.
        customers.add(customer);
    }

    public void sortBySurname()
    {
        // Сортирует по фамилиям список покупателей.
        customers.sort(Customer::compareTo);
    }

    public ArrayList<Customer> getCustomersWithCreditCardNumberInRange(long lowLimit, long highLimit)
    {
        // Возвращает список покупателей, номера кредитных карт которых входят в заданный диапазон.
        if (lowLimit > highLimit)
        {
            long temp = lowLimit;
            lowLimit = highLimit;
            highLimit = temp;
        }
        ArrayList<Customer> newCustomers = new ArrayList<>();
        for (Customer customer : customers)
        {
            if (customer.getCreditCardNumber() >= lowLimit && customer.getCreditCardNumber() <= highLimit)
            {
                newCustomers.add(customer);
            }
        }
        return newCustomers;
    }

    public void printInfoAboutAllCustomers()
    {
        // Вывод в консоль информации обо всех покупателях.
        for (Customer customer : customers)
        {
            customer.printInfo();
        }
        System.out.println();
    }

    public static void printInfo(ArrayList<Customer> customers)
    {
        // Вывод в консоль информации о заданных покупателях.
        for (Customer customer : customers)
        {
            customer.printInfo();
        }
        System.out.println();
    }
}