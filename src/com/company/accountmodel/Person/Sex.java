package com.company.accountmodel.Person;

public enum Sex {

    MAN("Мужской"),
    WOMEN("Женский");

    private String sex;

    Sex(String sex) {
        this.sex = sex;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return sex;
    }
}
