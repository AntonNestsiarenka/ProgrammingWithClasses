package com.company.statemodel.territorial_fragment;

public abstract class TerritorialFragment {

    /* Класс описывает абстрактный территориальный фрагмент. */

    private String name;

    public TerritorialFragment()
    {
        name = "";
    }

    public TerritorialFragment(String name)
    {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public abstract String toString();

    public abstract void printInfo();
}