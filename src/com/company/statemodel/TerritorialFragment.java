package com.company.statemodel;

public abstract class TerritorialFragment {

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