package com.company.accountmodel.Person.children;

import com.company.accountmodel.IdentityDocument.children.Passport;
import com.company.accountmodel.Person.Person;
import com.company.accountmodel.Person.Sex;

public class ClientOfBank extends Person {

    /* Класс описывает клиента банка. */

    private static long idUnique = 0;

    private long id;
    private Passport passport;

    public ClientOfBank(Passport passport) {
        super();
        id = idUnique++;
        this.passport = passport;
    }

    public ClientOfBank(String surname, String name, String patronymic, int age, Sex sex, Passport passport) {
        super(surname, name, patronymic, age, sex);
        id = idUnique++;
        this.passport = passport;
    }

    public static long getIdUnique() {
        return idUnique;
    }

    public long getId() {
        return id;
    }

    public Passport getPassport() {
        return passport;
    }

    @Override
    public String toString() {
        return "Клиент номер " + id
                + ". Фамилия: " + getSurname()
                + ". Имя: " +getName()
                + ". Отчество: " + getPatronymic()
                + ". Возраст: " + getAge()
                + ". Пол: " + getSex().toString()
                + ".\n" + passport.toString();
    }

    @Override
    public void printInfo() {
        System.out.println(toString());
    }
}
