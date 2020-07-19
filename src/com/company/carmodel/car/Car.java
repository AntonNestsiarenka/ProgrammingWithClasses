package com.company.carmodel.car;

import Utils.MyException;
import com.company.carmodel.car.interfaces.Auto;
import com.company.carmodel.engine.Engine;
import com.company.carmodel.engine.TypeOfEngine;
import com.company.carmodel.person.children.Passenger;
import com.company.carmodel.person.Person;
import com.company.carmodel.person.children.Driver;
import com.company.carmodel.wheel.Disc;
import com.company.carmodel.wheel.Tire;
import com.company.carmodel.wheel.Wheel;
import java.util.Arrays;

public final class Car implements Auto {

    /* Класс описывает автомобиль. Реализует интерфейс транспорт. */

    private String manufacturer;
    private String model;
    private String winNumber;
    private double curbWeight; // в кг.
    private double maxWeight; // в кг.
    private double currentWeight; // в кг.
    private double accelerator; // в %.
    private double fuelTankVolume; // в л.
    private double fuelConsumptionIdle; // в л/ч.
    private double currentFuelConsumption;  // расход топлива в л на 100 км.
    private double currentFuelTankLevel; // текущий уровень в баке в %.
    private Driver driver = null;
    private final Passenger[] passengers;
    private Engine engine;
    private Wheel[] wheels;
    private Wheel spareWheel;
    private boolean isRun = false;

    public Car()
    {
        manufacturer = "Mazda";
        model = "6";
        winNumber = "JMZGD16E201150001";
        curbWeight = 1225.0;
        currentWeight = curbWeight - 75;
        maxWeight = 1675.0;
        accelerator = 0;
        fuelTankVolume = 55.7;
        currentFuelConsumption = 0;
        currentFuelTankLevel = 50.0;
        passengers = new Passenger[4];
        engine = new Engine("Mazda", "PYY1", 2015, 2300214L, TypeOfEngine.PETROL, 2488, 141, 256, 7.8, false);
        fuelConsumptionIdle = engine.getFuelConsumption() * 0.1 * engine.getTypeOfEngine().getMultiplierOfFuelConsumptionIdle();
        wheels = new Wheel[] {new Wheel(), new Wheel(), new Wheel(), new Wheel()};
        spareWheel = new Wheel();
    }

    public Car(String manufacturer, String model, String winNumber, double curbWeight, double maxWeight, double fuelTankVolume, double currentFuelTankLevel, Driver driver, Passenger[] passengers, Engine engine, Wheel[] wheels, Wheel spareWheel) {
        this.manufacturer = manufacturer;
        this.model = model;
        this.winNumber = winNumber;
        this.curbWeight = curbWeight;
        this.maxWeight = maxWeight;
        accelerator = 0;
        this.fuelTankVolume = fuelTankVolume;
        this.currentFuelConsumption = 0;
        this.currentFuelTankLevel = currentFuelTankLevel;
        this.driver = driver;
        driver.setCar(this);
        this.passengers = passengers;
        this.currentWeight = this.curbWeight + driver.getWeight() - 75;
        for (Passenger person : this.passengers)
        {
            person.setCar(this);
            this.currentWeight += person.getWeight();
        }
        this.engine = engine;
        fuelConsumptionIdle = engine.getFuelConsumption() * 0.1 * engine.getTypeOfEngine().getMultiplierOfFuelConsumptionIdle();
        this.wheels = wheels;
        this.spareWheel = spareWheel;
    }

    public Car(String manufacturer, String model, String winNumber, double curbWeight, double maxWeight, double fuelTankVolume, double currentFuelTankLevel, int numberOfPassengers, Engine engine, Wheel[] wheels, Wheel spareWheel) {
        this.manufacturer = manufacturer;
        this.model = model;
        this.winNumber = winNumber;
        this.curbWeight = curbWeight;
        currentWeight = this.curbWeight - 75;
        this.maxWeight = maxWeight;
        accelerator = 0;
        this.fuelTankVolume = fuelTankVolume;
        this.currentFuelConsumption = 0;
        this.currentFuelTankLevel = currentFuelTankLevel;
        this.passengers = new Passenger[numberOfPassengers];
        this.engine = engine;
        fuelConsumptionIdle = engine.getFuelConsumption() * 0.1 * engine.getTypeOfEngine().getMultiplierOfFuelConsumptionIdle();
        this.wheels = wheels;
        this.spareWheel = spareWheel;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public String getModel() {
        return model;
    }

    public String getWinNumber() {
        return winNumber;
    }

    public double getCurbWeight() {
        return curbWeight;
    }

    public double getMaxWeight() {
        return maxWeight;
    }

    public double getCurrentWeight() {
        return currentWeight;
    }

    public double getAccelerator() {
        return accelerator;
    }

    public double getFuelTankVolume() {
        return fuelTankVolume;
    }

    public double getFuelConsumptionIdle() {
        return fuelConsumptionIdle;
    }

    public double getCurrentFuelConsumption() {
        return currentFuelConsumption;
    }

    public Person getDriver() {
        return driver;
    }

    public Person[] getPassengers() {
        return passengers;
    }

    public Engine getEngine() {
        return engine;
    }

    public Wheel[] getWheels() {
        return wheels;
    }

    public Wheel getSpareWheel() {
        return spareWheel;
    }

    public double getCurrentFuelTankLevel() {
        return currentFuelTankLevel;
    }

    public boolean isRun() {
        return isRun;
    }

    public void setSpareWheel(Wheel spareWheel) {
        this.spareWheel = spareWheel;
    }

    public void setFuelConsumptionIdle(double value)
    {
        // Установить расход холостого хода в л/ч.
        fuelConsumptionIdle = value;
    }

    public void setAccelerator(double accelerator) throws MyException {
        // Устанавливает новое значение педали акселератора.
        if (accelerator < 0 || accelerator > 100)
            try {
                throw new MyException("Ошибка, неверное задание для педали акселератора.");
            } catch (MyException e) {
                System.out.println("Ошибка P1507 - 1 педаль акселератора (неверный сигнал).");
                stopAutomatic();
                throw new MyException("Ошибка, неверное задание для педали акселератора.");
            }
        else {
            if (accelerator == 0)
                currentFuelConsumption = 0;
            this.accelerator = accelerator;
            System.out.println("Установлено новое значение акселератора.");
        }
    }

    public void start() {
        // Запускает двигатель.
        if (!engine.isBroken() && !isRun && currentFuelTankLevel > 0 && driver != null)
        {
            isRun = true;
            engine.setRun(true);
            System.out.printf("Двигатель завел водитель %s, машина работает на холостом ходу.\n", driver.getName());
        }
    }

    public void stop()
    {
        // Останавливает двигатель.
        if (driver != null) {
            engine.setRun(false);
            System.out.printf("Двигатель был остановлен водителем %s.\n", driver.getName());
            currentFuelConsumption = 0;
            isRun = false;
        }
    }

    public boolean setDriver(Driver driver) {
        // Устанавливает водителя.
        if (this.driver == null)
        {
            this.driver = driver;
            driver.setCar(this);
            System.out.printf("В машину сел водитель %s.\n", this.driver.getName());
            recalculateCurrentWeight();
            return true;
        }
        System.out.println("В машине уже есть водитель.");
        return false;
    }

    public boolean removeDriver(Driver person)
    {
        // Удаляет водителя.
        if (driver == person)
        {
            driver = null;
            person.setCar(null);
            System.out.printf("Из машины вышел водитель %s.\n", person.getName());
            recalculateCurrentWeight();
            return true;
        }
        return false;
    }

    public boolean addPassenger(Passenger person)
    {
        // Добавляет пассажира если есть свободные места.
        for (int i = 0; i < passengers.length; i++)
        {
            if (passengers[i] == null)
            {
                passengers[i] = person;
                person.setCar(this);
                System.out.printf("В машину сел пассажир %s.\n", passengers[i].getName());
                recalculateCurrentWeight();
                return true;
            }
        }
        System.out.println("Все свободные места для пассажиров заняты.");
        return false;
    }

    public void removePassenger(int index)
    {
        // Удаляет пассажира по индексу в массиве.
        if (index >= 0 && index < passengers.length) {

            passengers[index].setCar(null);
            passengers[index] = null;
            recalculateCurrentWeight();
        }
    }

    public void removeAllPassengers()
    {
        // Удаляет всех пассажиров.
        for (int i = 0; i < passengers.length; i++)
        {
            passengers[i].setCar(null);
            passengers[i] = null;
        }
        recalculateCurrentWeight();
    }

    public boolean removePassenger(Passenger person)
    {
        // Удаляет конкретного пассажира.
        for (int i = 0; i < passengers.length; i++)
        {
            if (passengers[i] == person)
            {
                passengers[i] = null;
                person.setCar(null);
                System.out.printf("Из машины вышел пассажир %s.\n", person.getName());
                return true;
            }
        }
        recalculateCurrentWeight();
        return false;
    }

    public void refill(double numberOfLitres)
    {
        // Заправить машину на заданное количество литров.
        if (numberOfLitres > 0)
        {
            double temp = (currentFuelTankLevel * fuelTankVolume) / 100 + numberOfLitres;
            if (temp >= fuelTankVolume)
            {
                currentFuelTankLevel = 100.0;
                System.out.println("Машина была заправлена до полного бака.");
            }
            else
            {
                currentFuelTankLevel = (temp * 100) / fuelTankVolume;
                System.out.printf("Машина была заправлена на %f л топлива.\n", numberOfLitres);
            }
        }
    }

    public void refillMax()
    {
        // Заправить машину до максимального уровня бака.
        currentFuelTankLevel = 100;
        System.out.println("Машина была заправлена до полного бака.");
    }

    public void replaceWheel(Wheel wheel)
    {
        // Замена заданного колеса на запасное если такое имеется.
        if (!isRun && accelerator == 0 && spareWheel != null)
        {
            for (int i = 0; i < wheels.length; i++)
            {
                if (wheels[i] == wheel)
                {
                    Wheel temp = wheels[i];
                    wheels[i] = spareWheel;
                    spareWheel = temp;
                    System.out.println("Заданное колесо было успешно поменяно с запасным колесом");
                }
            }
        }
        else
        {
            System.out.println("Запасного колеса нет в наличии.");
        }
    }

    public void changeTire(Wheel wheel, Tire tire) throws MyException {
        // Замена резины колеса.
        for (int i = 0; i < wheels.length; i++)
        {
            if (wheels[i] == wheel)
            {
                wheels[i].setTire(tire);
            }
        }
    }

    public void changeDisk(Wheel wheel, Disc disc) throws MyException {
        // Замена диска колеса.
        for (int i = 0; i < wheels.length; i++)
        {
            if (wheels[i] == wheel)
            {
                wheels[i].setDisc(disc);
            }
        }
    }

    public void recalculateCurrentWeight()
    {
        // Пересчет текущего веса машины (отработка событием при посадке и/или высадки пассажиров, водителя).
        double recalc = 0;
        if (driver == null)
        {
            recalc = this.curbWeight - 75;
        }
        else
        {
            recalc = this.curbWeight + driver.getWeight() - 75;
        }
        for (int i = 0; i < passengers.length; i++)
        {
            if (passengers[i] != null)
            {
                recalc += passengers[i].getWeight();
            }
        }
        currentWeight = recalc;
    }

    public void recalculateCurrentFuelConsumption()
    {
        /* Пересчет текущего значения расхода топлива (отработка событием раз в секунду при условии что двигатель
           запущен и нажата педаль газа). */
        if (engine.isRun() && accelerator != 0)
        {
            double multiplierOfWeight = currentWeight / curbWeight;
            double multiplierOfAccelerator = getMultiplierOfAccelerator();
            currentFuelConsumption = multiplierOfWeight * multiplierOfAccelerator * engine.getFuelConsumption();
        }
    }

    public void recalculateCurrentFuelTankLevel()
    {
        /* Пересчет текущего значения уровня топлива в баке (отработка событием раз в секунду при условии что двигатель
           работает). */
        if (engine.isRun()) {
            double sub = (accelerator == 0) ? fuelConsumptionIdle / 3600 : ((accelerator / 3600) * currentFuelConsumption / 100) * 100 / fuelTankVolume;
            if (currentFuelTankLevel - sub > 0)
                currentFuelTankLevel -= sub;
            else {
                currentFuelTankLevel = 0;
                stopAutomatic();
            }
        }
    }

    private double getMultiplierOfAccelerator()
    {
        // Множитель расхода топлива в зависимости от положения педали газа.
        double x = (accelerator % 100) / 100;
        return 1.25 - Math.sqrt(x) / 2 + 0.8 * Math.pow(x, 3);
    }

    public void printInfo()
    {
        System.out.println(toString());
    }

    @Override
    public String toString() {
        return "Car{" +
                "manufacturer='" + manufacturer + '\'' +
                ", model='" + model + '\'' +
                ", winNumber='" + winNumber + '\'' +
                ", curbWeight=" + curbWeight +
                ", maxWeight=" + maxWeight +
                ", currentWeight=" + currentWeight +
                ", accelerator=" + accelerator +
                ", fuelTankVolume=" + fuelTankVolume +
                ", currentFuelConsumption=" + currentFuelConsumption +
                ", currentFuelTankLevel=" + currentFuelTankLevel +
                ", driver=" + driver +
                ", passengers=" + Arrays.toString(passengers) +
                ", engine=" + engine +
                ", wheels=" + Arrays.toString(wheels) +
                ", spareWheel=" + spareWheel +
                ", isRun=" + isRun +
                '}';
    }

    private void stopAutomatic()
    {
        engine.setStopAutomatic();
        currentFuelConsumption = 0;
        isRun = false;
        System.out.println("Двигатель заглох.");
    }
}