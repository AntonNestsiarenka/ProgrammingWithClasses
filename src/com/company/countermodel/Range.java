package com.company.countermodel;

import java.util.ArrayList;

public class Range {

    /* Класс описывает диапазон целочисленных значений от lowLimit до highLimit (не включая highLimit). */

    private int lowLimit;
    private int highLimit;

    public Range()
    {
        lowLimit = 0;
        highLimit = 0;
    }

    public Range(int highLimit)
    {
        lowLimit = 0;
        this.highLimit = highLimit;
    }

    public Range(int lowLimit, int highLimit)
    {
        this.lowLimit = lowLimit;
        this.highLimit = highLimit;
    }

    public int getLowLimit() {
        return lowLimit;
    }

    public int getHighLimit() {
        return highLimit;
    }

    public boolean inRange(int value)
    {
        // Принадлежит ли value диапазону [lowLimit, highLimit).
        return value >= Math.min(lowLimit, highLimit) && value < Math.max(lowLimit, highLimit);
    }

    public int[] getSequenceArrayOfRange()
    {
        // Возвращает последовательность диапазона в виде массива.
        int[] array = new int[Math.abs(highLimit - lowLimit)];
        int offset = (lowLimit <= highLimit) ? 1 : -1;
        for (int i = 0, j = lowLimit; i < array.length; i++, j += offset)
        {
            array[i] = j;
        }
        return array;
    }

    public ArrayList<Integer> getSequenceListOfRange()
    {
        // Возвращает последовательность диапазона в виде листа.
        ArrayList<Integer> array = new ArrayList<Integer>();
        int offset = (lowLimit <= highLimit) ? 1 : -1;
        for (int i = 0, j = lowLimit; i < Math.abs(highLimit - lowLimit); i++, j += offset)
        {
            array.add(j);
        }
        return array;
    }
}