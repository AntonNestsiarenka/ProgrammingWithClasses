package com.company.airlinemodel;

import com.company.trainmodel.Time;

import java.util.ArrayList;

public class AirlineCollection {

    private ArrayList<Airline> airlines = new ArrayList<Airline>();

    public AirlineCollection(Airline airline)
    {
        addAirLineToAirLineCollection(airline);
    }

    public AirlineCollection(Airline...airlines)
    {
        for (Airline airline : airlines)
        {
            addAirLineToAirLineCollection(airline);
        }
    }

    public AirlineCollection(ArrayList<Airline> airlines)
    {
        this.airlines = airlines;
    }

    public ArrayList<Airline> getAirlines() {
        return airlines;
    }

    public void addAirLineToAirLineCollection(Airline airline)
    {
        // Добавление авиалинии в коллекцию.
        airlines.add(airline);
    }

    public void addAirLinesToAirLineCollection(ArrayList<Airline> airlines)
    {
        // Добавление нескольких авиалиний в коллекцию.
        if (this.airlines != airlines)
            this.airlines.addAll(airlines);
    }

    public void addBookCollectionToBookCollection(AirlineCollection airlineCollection)
    {
        // Добавление коллекции авиалиний в коллекцию (объединение).
        if (this.airlines != airlineCollection.getAirlines())
            this.airlines.addAll(airlineCollection.getAirlines());
    }

    public ArrayList<Airline> getAirLinesWithAGivenDestinationName(String destinationName)
    {
        // Возвращает авиалинии по заданному пункту назаначения.
        ArrayList<Airline> newAirLines = new ArrayList<Airline>();
        for (Airline airline : airlines)
        {
            if (airline.isAirLineWithAGivenDestinationName(destinationName))
            {
                newAirLines.add(airline);
            }
        }
        return newAirLines;
    }

    public ArrayList<Airline> getAirLinesWithAGivenDayOfWeek(DayOfWeek dayOfWeek)
    {
        // Возвращает авиалинии по заданному дню отправления.
        ArrayList<Airline> newAirLines = new ArrayList<Airline>();
        for (Airline airline : airlines)
        {
            if (airline.isAirLineWithAGivenDayOfWeek(dayOfWeek))
            {
                newAirLines.add(airline);
            }
        }
        return newAirLines;
    }

    public ArrayList<Airline> getAirLinesWithAGivenDayOfWeekAndAfterGivenTime(DayOfWeek dayOfWeek, Time time)
    {
        // Возвращает авиалинии для заданного дня отправления, время отправления для которых больше заданного времени.
        ArrayList<Airline> newAirLines = new ArrayList<Airline>();
        for (Airline airline : airlines)
        {
            if (airline.isAirLineWithAGivenDayOfWeek(dayOfWeek))
            {
                if (airline.isAirLineDepartureTimeAfterAGiveTime(time))
                {
                    newAirLines.add(airline);
                }
            }
        }
        return newAirLines;
    }

    public void printInfo()
    {
        // Вывод в консоль информации обо всех авиалиниях коллекции.
        for (Airline airline : airlines)
        {
            airline.printInfo();
        }
        System.out.println();
    }

    public static void printInfo(ArrayList<Airline> airlines)
    {
        // Вывод в консоль информации об заданных авиалиниях.
        for (Airline airline : airlines)
        {
            airline.printInfo();
        }
        System.out.println();
    }
}