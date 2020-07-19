package com.company.customermodel;

public final class Customer implements Comparable<Customer> {

    /* Класс реализует покупателя */

    private static int idUnique = 0;

    private final int id;
    private String surname;
    private String name;
    private String patronymic;
    private String address;
    private long creditCardNumber;
    private String bankAccountNumber;

    public Customer()
    {
        id = idUnique++;
        surname = "Potapenko";
        name = "Maxim";
        patronymic = "Sergeevich";
        address = "Minsk, Matusevicha street 68";
        creditCardNumber = 4323000035661410L;
        bankAccountNumber = "TE45423-313-0012BYN";
    }

    public Customer(String surname, String name, String patronymic, String address, long creditCardNumber, String bankAccountNumber)
    {
        id = idUnique++;
        this.surname = surname;
        this.name = name;
        this.patronymic = patronymic;
        this.address = address;
        this.creditCardNumber = creditCardNumber;
        this.bankAccountNumber = bankAccountNumber;
    }

    public int getId() {
        return id;
    }

    public String getSurname() {
        return surname;
    }

    public String getName() {
        return name;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public String getAddress() {
        return address;
    }

    public long getCreditCardNumber() {
        return creditCardNumber;
    }

    public String getBankAccountNumber() {
        return bankAccountNumber;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setCreditCardNumber(long creditCardNumber) {
        this.creditCardNumber = creditCardNumber;
    }

    public void setBankAccountNumber(String bankAccountNumber) {
        this.bankAccountNumber = bankAccountNumber;
    }

    public void printInfo()
    {
        // Выводит информацию о покупателе.
        System.out.println(toString());
    }

    @Override
    public String toString() {
        // Перевод атрибутов экземпляра в строку.
        return "Customer {" +
                "id=" + id +
                ", surname='" + surname + '\'' +
                ", name='" + name + '\'' +
                ", patronymic='" + patronymic + '\'' +
                ", address='" + address + '\'' +
                ", creditCardNumber='" + creditCardNumber + '\'' +
                ", bankAccountNumber='" + bankAccountNumber + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return id == customer.id;
    }

    @Override
    public int hashCode() {
        return id;
    }

    @Override
    public int compareTo(Customer o) {
        return surname.compareTo(o.surname);
    }
}