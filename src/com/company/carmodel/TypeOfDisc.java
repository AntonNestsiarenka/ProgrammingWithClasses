package com.company.carmodel;

public enum  TypeOfDisc {

    STAMPED("Stamped disc"),
    ALLOY("Alloy disc"),
    FORGED("Forged disc"),
    COMBINED("Combined disc");

    private String typeOfDisc;

    TypeOfDisc(String typeOfDisc)
    {
        this.typeOfDisc = typeOfDisc;
    }

    public String getTypeOfDisc() {
        return typeOfDisc;
    }

    @Override
    public String toString() {
        return typeOfDisc;
    }
}
