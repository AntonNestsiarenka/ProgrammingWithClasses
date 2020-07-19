package com.company.carmodel.person.children;

import com.company.carmodel.car.interfaces.Auto;
import com.company.carmodel.car.Car;
import com.company.carmodel.person.children.interfaces.IPassenger;
import com.company.carmodel.person.Person;

public class Passenger extends Person implements IPassenger {

    /* Класс описывает водителя автомобиля. Реализует интерфейс пассажира. */

    private Auto car;

    public Passenger() {

    }

    public Passenger(String name, double weight)
    {
        super(name, weight);
    }

    public Auto getCar() {
        return car;
    }

    public void setCar(Auto car) {
        this.car = car;
    }

    @Override
    public String toString() {
        return "Passenger{" +
                "name=" + getName() + ", " +
                "weight=" + getWeight() + " kg, " + car.toString() + '}';
    }

    @Override
    public PersonUnit getOut() {
        // Метод для выхода из машины. Возвращает объект PersonUnit если высадка прошла успешно либо null если нет.
        if (car != null)
        {
            if (car instanceof Car)
            {
                Car car1 = (Car) car;
                if(car1.removePassenger(this))
                    return new PersonUnit(getName(), getWeight());
            }
        }
        return null;
    }
}
