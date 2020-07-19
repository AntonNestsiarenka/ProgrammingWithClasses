package com.company.trainmodel;

import java.util.Objects;

public class Train {

    /* Класс описывает поезд. */

    private String destinationName;
    private int numberOfTrain;
    private Time departureTime;

    public Train()
    {
        destinationName = "";
        numberOfTrain = 0;
        departureTime = new Time();
    }

    public Train(String destinationName, int numberOfTrain, Time departureTime)
    {
        this.destinationName = destinationName;
        this.numberOfTrain = numberOfTrain;
        this.departureTime = departureTime;
    }

    public String getDestinationName() {
        return destinationName;
    }

    public void setDestinationName(String destinationName) {
        this.destinationName = destinationName;
    }

    public int getNumberOfTrain() {
        return numberOfTrain;
    }

    public void setNumberOfTrain(int numberOfTrain) {
        this.numberOfTrain = numberOfTrain;
    }

    public Time getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(Time departureTime) {
        this.departureTime = departureTime;
    }

    @Override
    public String toString() {
        return String.format("Номер поезда %d.\nПункт назначения %s.\nВремя отправления %s.",
                numberOfTrain, destinationName, departureTime.toString());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Train train = (Train) o;
        return numberOfTrain == train.numberOfTrain &&
                Objects.equals(destinationName, train.destinationName) &&
                Objects.equals(departureTime, train.departureTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(destinationName, numberOfTrain, departureTime);
    }

    public static void printInfoByNumberOfTrain(Train[] trains, int number)
    {
        // Выводит информацию о запрашиваемом поезде по номеру number.
        System.out.println("Информация о запрашиваемом поезде:");
        Train train = searchNumberOfTrainInArray(trains, number);
        if (train != null)
        {
            System.out.println(train);
        }
        else
        {
            System.out.println("Поезд с таким номером не найден.");
        }
    }

    public static void printInfo(Train[] trains)
    {
        // Выводит всю информацию об объектах массива поездов.
        for (Train train : trains)
        {
            System.out.println(train);
        }
    }

    public static void sortByNumberOfTrainAscending(Train[] trains)
    {
        // Сортировка массива поездов по возрастанию номера поезда.
        for (int i = 0; i < trains.length; i++)
        {
            for (int j = 0; j < trains.length - 1 - i; j++)
            {
                if (trains[j].numberOfTrain > trains[j + 1].numberOfTrain)
                {
                    swap(trains, j);
                }
            }
        }
    }

    public static void sortByDestinationName(Train[] trains)
    {
        /* Сортирует массив поездов по пункту назначения, а если пункты назначения совпадают сортирует по времени
           отправления. */
        for (int i = 0; i < trains.length; i++)
        {
            for (int j = 0; j < trains.length - 1 - i; j++)
            {
                if (trains[j].destinationName.compareTo(trains[j + 1].destinationName) > 0)
                {
                    swap(trains, j);
                }
                else if (trains[j].destinationName.compareTo(trains[j + 1].destinationName) == 0)
                {
                    if (trains[j].departureTime.compareTo(trains[j + 1].departureTime) > 0)
                    {
                        swap(trains, j);
                    }
                }
            }
        }
    }

    private static Train searchNumberOfTrainInArray(Train[] trains, int number)
    {
        /* Ищет заданный номер поезда в массиве поездов. Если такой номер существует, то возвращает объект поезд.
           Если поезда с таким номером не нашлось, то возвращает null. */
        for (Train train : trains)
        {
            if (number == train.numberOfTrain)
                return train;
        }
        return null;
    }

    private static void swap(Train[] trains, int index)
    {
        // Меняет местами элемент массива со следующим за ним элементом.
        Train temp = trains[index];
        trains[index] = trains[index + 1];
        trains[index + 1] = temp;
    }
}