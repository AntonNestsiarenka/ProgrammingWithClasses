package com.company.carmodel.person.children.interfaces;

public interface CarControl {

    /* Интерфейс управления автомобилем. */

    void startEngine();
    void stopEngine();
    void controlMovement(double acceleration);

}