package com.company.travelmodel;

public enum TypeOfFood {

    ALLINCLUSIVEPLUS("Все включено +", 1),
    ALLINCLUSIVE("Все включено", 2),
    THREETIMESADAY("Завтрак, обед и ужин", 3),
    DINNERANDSUPPER("Обед и ужин", 4),
    BREAKFASTANDSUPPER("Завтрак и ужин", 5),
    BREAKFAST("Завтрак", 6),
    SUPPER("Ужин", 7),
    NONE("Без питания", 8);

    private String nameOfTypeOfFood;
    private int numberOFTypeOfFood;

    TypeOfFood(String nameOfTypeOfFood, int numberOFTypeOfFood) {
        this.nameOfTypeOfFood = nameOfTypeOfFood;
        this.numberOFTypeOfFood = numberOFTypeOfFood;
    }

    public String getNameOfTypeOfFood() {
        return nameOfTypeOfFood;
    }

    public int getNumberOFTypeOfFood() {
        return numberOFTypeOfFood;
    }

    @Override
    public String toString() {
        return "Тип питания: "
                 + nameOfTypeOfFood;
    }

    public void printInfo()
    {
        System.out.println(toString());
    }
}
