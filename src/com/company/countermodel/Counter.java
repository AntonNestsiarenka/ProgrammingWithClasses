package com.company.countermodel;

import Utils.MyException;

public class Counter {

    private Range range;
    private int counter;

    public Counter()
    {
        range = new Range();
        counter = 0;
    }

    public Counter(int initValue, int lowLimit, int highLimit) throws MyException {
        if (initValue >= Math.min(lowLimit, highLimit) && initValue < Math.max(lowLimit, highLimit))
        {
            range = new Range(lowLimit, highLimit);
            counter = initValue;
        }
        else
        {
            throw new MyException("Некорректное инициализирующее значение счетчика.");
        }
    }

    public Counter(int lowLimit, int highLimit)
    {
        range = new Range(lowLimit, highLimit);
        counter = range.getLowLimit();
    }

    public Counter(int highLimit)
    {
        range = new Range(highLimit);
        counter = 0;
    }

    public int getCounter() {
        return counter;
    }

    public Range getRange() {
        return range;
    }

    public void increase() throws MyException
    {
        /* Увеличивает значение счетчика на единицу если текущее значение счетчика будет в пределах заданного диапазона
           range. При попытки выйти за пределы диапазона range бросает исключение MyException. */
        int count = counter + 1;
        if (range.inRange(count)) {
            counter = count;
        }
        else
        {
            throw new MyException("Попытка выйти за границы диапазона Range");
        }
    }

    public void decrease() throws MyException {
        /* Уменьшает значение счетчика на единицу если текущее значение счетчика будет в пределах заданного диапазона
           range. При попытки выйти за пределы диапазона range бросает исключение MyException. */
        int count = counter - 1;
        if (range.inRange(count)) {
            counter = count;
        }
        else
        {
            throw new MyException("Попытка выйти за границы диапазона Range");
        }
    }
}