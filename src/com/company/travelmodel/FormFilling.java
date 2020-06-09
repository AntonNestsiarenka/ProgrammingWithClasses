package com.company.travelmodel;

interface FormFilling {

void setTravelCountryToForm(String travelCountry);

void setTravelCityToForm(String travelCity);

void setNumberOfDaysToForm(Integer numberOfDays);

void setTypeOfTravelVoucherToForm(TypeOfTravelVoucher typeOfTravelVoucher);

void setTypeOfTransportToForm(TypeOfTransport typeOfTransport);

void setTypeOfFoodToForm(TypeOfFood typeOfFood);

void setPriceToForm(Double price);

void clearForm();
}