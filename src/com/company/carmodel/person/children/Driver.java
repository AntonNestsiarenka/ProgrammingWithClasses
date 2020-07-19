package com.company.carmodel.person.children;

import Utils.MyException;
import com.company.carmodel.car.interfaces.Auto;
import com.company.carmodel.car.Car;
import com.company.carmodel.person.children.interfaces.IDriver;
import com.company.carmodel.person.Person;

public class Driver extends Person implements IDriver {

    /* Класс описывает водителя автомобиля. Реализует интерфейс водителя. */

    private Auto car;

    public Driver() {
    }

    public Driver(String name, double weight) {
        super(name, weight);
    }

    public Auto getCar() {
        return car;
    }

    public void setCar(Auto car) {
        this.car = car;
    }

    @Override
    public void startEngine()
    {
        // Метод для запуска двигателя.
        if (car != null)
        {
            if (car instanceof Car)
            {
                Car car1 = (Car) car;
                car1.start();
            }
        }
    }

    @Override
    public void controlMovement(double acceleration) {
        // Метод для ускорения/замедления. Принимает значения от 0.0 до 100.0
        if (car != null)
        {
            if (car instanceof Car)
            {
                Car car1 = (Car) car;
                try {
                    car1.setAccelerator(acceleration);
                } catch (MyException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public void stopEngine()
    {
        // Метод для остановки двигателя.
        if (car != null)
        {
            if (car instanceof Car)
            {
                Car car1 = (Car) car;
                car1.stop();
            }
        }
    }

    @Override
    public PersonUnit getOut() {
        // Метод для выхода из машины. Возвращает объект PersonUnit если высадка прошла успешно либо null если нет.
        if (car != null)
        {
            if (car instanceof Car)
            {
                Car car1 = (Car) car;
                if (car1.removeDriver(this))
                    return new PersonUnit(getName(), getWeight());
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return "Driver{" +
                "name=" + getName() + ", " +
                "weight=" + getWeight() + " kg, " + car.toString() + '}';
    }
}
