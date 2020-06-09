package com.company.trainmodel;

public class Time {

    public static final int secondsInTwentyFourHours = 86400;
    public static final int minutesInTwentyFourHours = 1440;
    public static final int hoursInTwentyFourHours = 24;
    public static final int secondsInOneHour = 3600;
    public static final int minutesInOneHour = 60;
    public static final int secondsInOneMinute = 60;

    private int hours;
    private int minutes;
    private int seconds;

    public Time()
    {
        hours = 0;
        minutes = 0;
        seconds = 0;
    }

    public Time(int hours, int minutes)
    {
        setHours(hours);
        setMinutes(minutes);
        this.seconds = 0;
    }

    public Time(int hours, int minutes, int seconds)
    {
        setHours(hours);
        setMinutes(minutes);
        setSeconds(seconds);
    }

    public void setTime(int hours, int minutes, int seconds)
    {
        setHours(hours);
        setMinutes(minutes);
        setSeconds(seconds);
    }

    public void setHours(int hours) {
        this.hours = (hours >= 0 && hours < 24) ? hours : 0;
    }

    public void setMinutes(int minutes) {
        this.minutes = (minutes >= 0 && minutes < 60) ? minutes : 0;
    }

    public void setSeconds(int seconds) {
        this.seconds = (seconds >= 0 && seconds < 60) ? seconds : 0;
    }

    public void addSeconds(int value)
    {
        /* Добавление к текущему времени value секунд. value может быть любым числом. Перед добавлением происходит
           пересчет текущего времени с учетом добавляемого значения. */
        int currentTime = toSeconds() + value % secondsInTwentyFourHours;
        castTimeTo24HFormat(currentTime);
    }

    public void addMinutes(int value)
    {
        /* Добавление к текущему времени value минут. value может быть любым числом. Перед добавлением происходит
           пересчет текущего времени с учетом добавляемого значения. */
        int currentTime = toSeconds() + (value % minutesInTwentyFourHours) * secondsInOneMinute;
        castTimeTo24HFormat(currentTime);
    }

    public void addHours(int value)
    {
        /* Добавление к текущему времени value часов. value может быть любым числом. Перед добавлением происходит
           пересчет текущего времени с учетом добавляемого значения. */
        int currentTime = toSeconds() + (value % hoursInTwentyFourHours) * secondsInOneHour;
        castTimeTo24HFormat(currentTime);
    }

    public int getHours() {
        return hours;
    }

    public int getMinutes() {
        return minutes;
    }

    public int getSeconds() {
        return seconds;
    }

    public void printTime()
    {
        // Вывод текущего времени в консоль.
        System.out.printf("Текущее время %s.\n", toString());
    }

    public int toSeconds()
    {
        // Преобразование времени в секунды.
        return hours * secondsInOneHour + minutes * secondsInOneMinute + seconds;
    }

    public String toString()
    {
        // Преобразование времени в строку.
        String hour = (hours < 10) ? "0" + String.valueOf(hours) : String.valueOf(hours);
        String minute = (minutes < 10) ? "0" + String.valueOf(minutes) : String.valueOf(minutes);
        String second = (seconds < 10) ? "0" + String.valueOf(seconds) : String.valueOf(seconds);
        return hour + ":" + minute + ":" + second;
    }

    public int compareTo(Time other)
    {
        /* Возвращает результат сравнения двух объектов. Результат может быть меньше нуля, равен нулю или больше нуля в
           зависимости от времени в секундах двух сравниваемых объектов. */
        return this.toSeconds() - other.toSeconds();
    }

    private void castTimeTo24HFormat(int seconds)
    {
        // Преобразует время в секундах к 24 часовому формату.
        hours = (seconds / secondsInOneHour) % hoursInTwentyFourHours;
        minutes = (seconds / secondsInOneMinute) % minutesInOneHour;
        this.seconds = seconds % secondsInOneMinute;
    }
}