package com.company.trainmodel;

import java.util.*;

public final class Time implements Comparable<Time> {

    /* Класс реализует представление времени в 24 часовом формате. */

    public static final int SECONDS_IN_TWENTY_FOUR_HOURS = 86400;
    public static final int MINUTES_IN_TWENTY_FOUR_HOURS = 1440;
    public static final int HOURS_IN_TWENTY_FOUR_HOURS = 24;
    public static final int SECONDS_IN_ONE_HOUR = 3600;
    public static final int MINUTES_IN_ONE_HOUR = 60;
    public static final int SECONDS_IN_ONE_MINUTE = 60;

    private int hours;
    private int minutes;
    private int seconds;

    public Time()
    {
        // Устанавливает текущее время.
        long currentTimeMillis = System.currentTimeMillis();
        currentTimeMillis += TimeZone.getDefault().getOffset(currentTimeMillis);
        castTimeTo24HFormat(currentTimeMillis / 1000);
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

    public int getHours() {
        return hours;
    }

    public int getMinutes() {
        return minutes;
    }

    public int getSeconds() {
        return seconds;
    }

    public void addSeconds(int value)
    {
        /* Добавление к текущему времени value секунд. value может быть любым числом. Перед добавлением происходит
           пересчет текущего времени с учетом добавляемого значения. */
        if (value < 0)
        {
            subtractSeconds(Math.abs(value));
            return;
        }
        int currentTime = toSeconds() + value % SECONDS_IN_TWENTY_FOUR_HOURS;
        castTimeTo24HFormat(currentTime);
    }

    public void addMinutes(int value)
    {
        /* Добавление к текущему времени value минут. value может быть любым числом. Перед добавлением происходит
           пересчет текущего времени с учетом добавляемого значения. */
        if (value < 0)
        {
            subtractMinutes(Math.abs(value));
            return;
        }
        int currentTime = toSeconds() + (value % MINUTES_IN_TWENTY_FOUR_HOURS) * SECONDS_IN_ONE_MINUTE;
        castTimeTo24HFormat(currentTime);
    }

    public void addHours(int value)
    {
        /* Добавление к текущему времени value часов. value может быть любым числом. Перед добавлением происходит
           пересчет текущего времени с учетом добавляемого значения. */
        if (value < 0)
        {
            subtractHours(Math.abs(value));
            return;
        }
        int currentTime = toSeconds() + (value % HOURS_IN_TWENTY_FOUR_HOURS) * SECONDS_IN_ONE_HOUR;
        castTimeTo24HFormat(currentTime);
    }

    public void subtractSeconds(int value)
    {
        /* Вычитание от текущего времени value секунд. value может быть любым числом. Перед вычитанием происходит
           пересчет текущего времени с учетом вычитаемого значения. */
        if (value < 0)
        {
            addSeconds(Math.abs(value));
            return;
        }
        int currentTime = toSeconds() - value % SECONDS_IN_TWENTY_FOUR_HOURS;
        if (currentTime < 0)
            currentTime = SECONDS_IN_TWENTY_FOUR_HOURS + currentTime;
        castTimeTo24HFormat(currentTime);
    }

    public void subtractMinutes(int value)
    {
        /* Вычитание от текущего времени value минут. value может быть любым числом. Перед вычитанием происходит
           пересчет текущего времени с учетом вычитаемого значения. */
        if (value < 0)
        {
            addMinutes(Math.abs(value));
            return;
        }
        int currentTime = toSeconds() - (value % MINUTES_IN_TWENTY_FOUR_HOURS) * SECONDS_IN_ONE_MINUTE;
        if (currentTime < 0)
            currentTime = SECONDS_IN_TWENTY_FOUR_HOURS + currentTime;
        castTimeTo24HFormat(currentTime);
    }

    public void subtractHours(int value)
    {
        /* Вычитание от текущего времени value часов. value может быть любым числом. Перед вычитанием происходит
           пересчет текущего времени с учетом вычитаемого значения. */
        if (value < 0)
        {
            addHours(Math.abs(value));
            return;
        }
        int currentTime = toSeconds() - (value % HOURS_IN_TWENTY_FOUR_HOURS) * SECONDS_IN_ONE_HOUR;
        if (currentTime < 0)
            currentTime = SECONDS_IN_TWENTY_FOUR_HOURS + currentTime;
        castTimeTo24HFormat(currentTime);
    }

    public void printTime()
    {
        // Вывод текущего времени в консоль.
        System.out.printf("Текущее время %s.\n", toString());
    }

    public int toSeconds()
    {
        // Преобразование времени в секунды.
        return hours * SECONDS_IN_ONE_HOUR + minutes * SECONDS_IN_ONE_MINUTE + seconds;
    }

    private void castTimeTo24HFormat(int seconds)
    {
        // Преобразует время в секундах к 24 часовому формату.
        hours = (seconds / SECONDS_IN_ONE_HOUR) % HOURS_IN_TWENTY_FOUR_HOURS;
        minutes = (seconds / SECONDS_IN_ONE_MINUTE) % MINUTES_IN_ONE_HOUR;
        this.seconds = seconds % SECONDS_IN_ONE_MINUTE;
    }

    private void castTimeTo24HFormat(long seconds)
    {
        // Преобразует время в секундах к 24 часовому формату.
        hours = (int)(seconds / SECONDS_IN_ONE_HOUR) % HOURS_IN_TWENTY_FOUR_HOURS;
        minutes = (int)(seconds / SECONDS_IN_ONE_MINUTE) % MINUTES_IN_ONE_HOUR;
        this.seconds = (int)(seconds % SECONDS_IN_ONE_MINUTE);
    }

    @Override
    public String toString()
    {
        // Преобразование времени в строку.
        String hour = (hours < 10) ? "0" + hours : String.valueOf(hours);
        String minute = (minutes < 10) ? "0" + minutes : String.valueOf(minutes);
        String second = (seconds < 10) ? "0" + seconds : String.valueOf(seconds);
        return hour + ":" + minute + ":" + second;
    }

    @Override
    public int compareTo(Time other)
    {
        /* Возвращает результат сравнения двух объектов. Результат может быть меньше нуля, равен нулю или больше нуля в
           зависимости от времени в секундах двух сравниваемых объектов. */
        return toSeconds() - other.toSeconds();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Time time = (Time) o;
        return hours == time.hours &&
                minutes == time.minutes &&
                seconds == time.seconds;
    }

    @Override
    public int hashCode() {
        return Objects.hash(hours, minutes, seconds);
    }
}