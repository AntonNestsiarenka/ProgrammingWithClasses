package com.company.carmodel.person.children.interfaces;

import com.company.carmodel.car.interfaces.Auto;
import com.company.carmodel.person.children.Driver;
import com.company.carmodel.person.children.Passenger;

public interface Interaction {

    /* Интерфейс взаимодействия с транспортом. */

    Driver tryToSeatToCarAsADriver(Auto car);
    Passenger tryToSeatToCarAsAPassenger(Auto car);

}
