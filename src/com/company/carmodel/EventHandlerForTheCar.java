package com.company.carmodel;

public class EventHandlerForTheCar {

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
        car.recalculateCurrentWeight();
        car.recalculateCurrentFuelConsumption();
        car.recalculateCurrentFuelTankLevel();
    }

    public void printInfo()
    {
        System.out.printf("Машина %s %s, текущий вес машины %f кг, положение педали газа %f процента, расход холостого хода %f л/ч, текущий расход топлива %f л/100км, текущий уровень топлива в баке %f процента.\nДвигатель работает %b, двигатель неисправен %b\n", car.getManufacturer(), car.getModel(), car.getCurrentWeight(), car.getAccelerator(), car.getFuelConsumptionIdle(), car.getCurrentFuelConsumption(), car.getCurrentFuelTankLevel(), car.getEngine().isRun(), car.getEngine().isBroken());
    }
}
