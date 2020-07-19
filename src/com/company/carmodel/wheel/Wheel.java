package com.company.carmodel.wheel;

import Utils.MyException;

public final class Wheel {

    /* Класс описывает колесо для автомобиля. */

    private Disc disc;
    private Tire tire;

    public Wheel()
    {
        this.disc = new Disc();
        this.tire = new Tire();
    }

    public Wheel(Disc disc, Tire tire) throws MyException {
        if (disc.getExternalDiameter() == tire.getDiscDiameter())
        {
            this.disc = disc;
            this.tire = tire;
        }
        else
        {
            throw new MyException("Попытка создать недопустимое колесо");
        }
    }

    public Disc getDisc() {
        return disc;
    }

    public Tire getTire() {
        return tire;
    }

    public void setTire(Tire tire) throws MyException {
        if (disc.getExternalDiameter() == tire.getDiscDiameter()) {
            this.tire = tire;
        }
        else
        {
            throw new MyException("Попытка поменять шину на шину неподходящую к диску");
        }
    }

    public void setDisc(Disc disc) throws MyException {
        if (disc.getExternalDiameter() == tire.getDiscDiameter()) {
            this.disc = disc;
        }
        else
        {
            throw new MyException("Попытка поменять диск на диск неподходящий к шине");
        }
    }

    @Override
    public String toString() {
        return "Wheel {" +
                "disc=" + disc +
                ", tire=" + tire +
                '}';
    }
}