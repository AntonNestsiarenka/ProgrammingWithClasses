package com.company.travelmodel;

public enum TypeOfTravelVoucher {

    RECREATION("Отдых"),
    EXCURSIONS("Экскурсии"),
    TREATMENT("Лечение"),
    SHOPPING("Шопинг"),
    CRUISE("Круиз");

    private String nameOfType;

    TypeOfTravelVoucher(String nameOfType) {
        this.nameOfType = nameOfType;
    }

    public String getNameOfType() {
        return nameOfType;
    }

    @Override
    public String toString() {
        return "Тип туристической путевки: " + nameOfType;
    }

    public void printInfo()
    {
        System.out.println(toString());
    }
}