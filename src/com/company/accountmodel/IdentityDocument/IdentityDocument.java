package com.company.accountmodel.IdentityDocument;

public abstract class IdentityDocument {

    /* Класс описывает абстрактный документ (удостоверение личности). */

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

    public String getSurname() {
        return surname;
    }

    public String getName() {
        return name;
    }

    public String getPatronymic() {
        return patronymic;
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

    @Override
    public abstract String toString();

    public abstract void printInfo();
}
