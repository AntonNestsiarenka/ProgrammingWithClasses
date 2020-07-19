package com.company.carmodel.person.children;

import com.company.carmodel.car.interfaces.Auto;
import com.company.carmodel.car.Car;
import com.company.carmodel.person.children.interfaces.Interaction;
import com.company.carmodel.person.Person;

public class PersonUnit extends Person implements Interaction {

    /* Класс описывает человека. Реализует интерфейс взаимодействия с транспортом. */

    public PersonUnit() {

    }

    public PersonUnit(String name, double weight)
    {
        super(name, weight);
    }

    @Override
    public Driver tryToSeatToCarAsADriver(Auto car) {
        /* Пытается сесть в машину на место водителя. Если посадка прошла успешно, то возвращает объект класса Driver,
           если нет то возвращает null. */
        if (car instanceof Car)
        {
            Car car1 = (Car) car;
            Driver driver = new Driver(getName(), getWeight());
            if (car1.setDriver(driver))
                return driver;
        }
        return null;
    }

    @Override
    public Passenger tryToSeatToCarAsAPassenger(Auto car) {
        /* Пытается сесть в машину на место пассажира. Если посадка прошла успешно, то возвращает объект класса Passenger,
           если нет то возвращает null. */
        if (car instanceof Car)
        {
            Car car1 = (Car) car;
            Passenger passenger = new Passenger(getName(), getWeight());
            if (car1.addPassenger(passenger))
                return passenger;
        }
        return null;
    }

    @Override
    public String toString() {
        return "PersonUnit{name=" + getName() + ", " +
                "weight=" + getWeight() + " kg.}";
    }
}
