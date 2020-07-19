package com.company.airlinemodel;

import com.company.trainmodel.Time;

import java.util.Arrays;

public final class Airline {

    /* Класс реализует воздушный рейс */

    private static int flightNumberUnique = 0;

    private String destinationName;
    private final int flightNumber;
    private String typeOfAircraft;
    private Time departureTime;
    private DayOfWeek[] schedule;

    public Airline()
    {
        destinationName = "Moscow";
        flightNumber = flightNumberUnique++;
        typeOfAircraft = "Ty-154";
        departureTime = new Time();
        schedule = new DayOfWeek[] {DayOfWeek.SUNDAY};
    }

    public Airline(String destinationName, String typeOfAircraft, Time departureTime, DayOfWeek...daysOfWeeks)
    {
        this.destinationName = destinationName;
        this.flightNumber = flightNumberUnique++;
        this.typeOfAircraft = typeOfAircraft;
        this.departureTime = departureTime;
        this.schedule = daysOfWeeks;
    }

    public String getDestinationName() {
        return destinationName;
    }

    public int getFlightNumber() {
        return flightNumber;
    }

    public String getTypeOfAircraft() {
        return typeOfAircraft;
    }

    public Time getDepartureTime() {
        return departureTime;
    }

    public DayOfWeek[] getSchedule() {
        return schedule;
    }

    public void setDestinationName(String destinationName) {
        this.destinationName = destinationName;
    }

    public void setTypeOfAircraft(String typeOfAircraft) {
        this.typeOfAircraft = typeOfAircraft;
    }

    public void setDepartureTime(Time departureTime) {
        this.departureTime = departureTime;
    }

    public void setSchedule(DayOfWeek[] schedule) {
        this.schedule = schedule;
    }

    public void printInfo()
    {
        System.out.println(toString());
    }

    @Override
    public String toString() {
        return "Airline {" +
                "destinationName: " + destinationName +
                ", flightNumber: " + flightNumber +
                ", typeOfAircraft: " + typeOfAircraft +
                ", departureTime: " + departureTime +
                ", schedule: " + Arrays.toString(schedule) +
                "}";
    }

    public boolean isAirLineWithAGivenDestinationName(String destinationName)
    {
        // Является ли авиалиния авиалинией с заданным пунктом назначения.
        return this.destinationName.equalsIgnoreCase(destinationName);
    }

    public boolean isAirLineWithAGivenDayOfWeek(DayOfWeek givenDayOfWeek)
    {
        // Является ли авиалиния аваалинией с заданным днем отправления.
        for (DayOfWeek dayOfWeek : schedule)
        {
            if (dayOfWeek.getNumberOfDay() == givenDayOfWeek.getNumberOfDay())
            {
                return true;
            }
        }
        return false;
    }

    public boolean isAirLineDepartureTimeAfterAGiveTime(Time time)
    {
        return departureTime.compareTo(time) > 0;
    }
}