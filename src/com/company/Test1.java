package com.company;

public class Test1 {

    private int x = 0;
    private int y = 0;

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void printInfo()
    {
        System.out.printf("Переменная x = %d\nПеременная y = %d\n", x, y);
    }

    public int sum()
    {
        return x + y;
    }

    public int max()
    {
        return Math.max(x, y);
    }
}