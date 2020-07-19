package com.company.travelmodel.client.interfaces;

import com.company.travelmodel.travel_voucher.TypeOfFood;
import com.company.travelmodel.travel_voucher.TypeOfTransport;
import com.company.travelmodel.travel_voucher.TypeOfTravelVoucher;

public interface FormFilling {

    /* Интерфейс для заполнения туристической формы. */

    void setTravelCountryToForm(String travelCountry);

    void setTravelCityToForm(String travelCity);

    void setNumberOfDaysToForm(Integer numberOfDays);

    void setTypeOfTravelVoucherToForm(TypeOfTravelVoucher typeOfTravelVoucher);

    void setTypeOfTransportToForm(TypeOfTransport typeOfTransport);

    void setTypeOfFoodToForm(TypeOfFood typeOfFood);

    void setPriceToForm(Double price);

    void clearForm();
}