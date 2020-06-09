package com.company.accountmodel;

public abstract class Person {

    private String surname;
    private String name;
    private String patronymic;
    private int age;
    private Sex sex;

    public Person()
    {
        surname = "";
        name = "";
        patronymic = "";
        age = 0;
        sex = Sex.MAN;
    }

    public Person(String surname, String name, String patronymic, int age, Sex sex) {
        this.surname = surname;
        this.name = name;
        this.patronymic = patronymic;
        this.age = age;
        this.sex = sex;
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

    public int getAge() {
        return age;
    }

    public Sex getSex() {
        return sex;
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

    public void setAge(int age) {
        this.age = age;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    @Override
    public abstract String toString();

    public abstract void printInfo();
}
