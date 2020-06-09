package com.company.accountmodel;

public abstract class IdentityDocument {

    public static String nameOfIdentity;
    private String surname;
    private String name;
    private String patronymic;

    public IdentityDocument()
    {
        surname = "";
        name = "";
        patronymic = "";
    }

    public IdentityDocument(String surname, String name, String patronymic) {
        this.surname = surname;
        this.name = name;
        this.patronymic = patronymic;
    }

    public static String getNameOfIdentity() {
        return nameOfIdentity;
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

    @Override
    public abstract String toString();

    public abstract void printInfo();
}
