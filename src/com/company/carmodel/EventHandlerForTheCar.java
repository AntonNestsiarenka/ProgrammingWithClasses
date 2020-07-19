package com.company.carmodel;

import com.company.carmodel.car.Car;

public final class EventHandlerForTheCar {

    /* Класс имитирует обработчик событий для обновления данных об объектах класса Car. */

    private Car car;

    public EventHandlerForTheCar(Car car)
    {
        this.car = car;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public void update()
    {
        // Метод для обновления данных объекта класса Car.
        car.recalculateCurrentWeight();
        car.recalculateCurrentFuelConsumption();
        car.recalculateCurrentFuelTankLevel();
    }

    public void printInfo1()
    {
        System.out.printf("Машина %s %s, текущий вес машины %f кг.\n", car.getManufacturer(), car.getModel(), car.getCurrentWeight());
    }

    public void printInfo2()
    {
        System.out.printf("Машина %s %s, текущий вес машины %f кг, положение педали газа %f процента, расход холостого хода %f л/ч, текущий расход топлива %f л/100км, текущий уровень топлива в баке %f процента.\nДвигатель работает %b, двигатель неисправен %b\n", car.getManufacturer(), car.getModel(), car.getCurrentWeight(), car.getAccelerator(), car.getFuelConsumptionIdle(), car.getCurrentFuelConsumption(), car.getCurrentFuelTankLevel(), car.getEngine().isRun(), car.getEngine().isBroken());
    }
}
