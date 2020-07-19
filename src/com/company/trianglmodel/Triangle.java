package com.company.trianglmodel;

import Utils.MyException;
import javafx.util.Pair;

import java.util.Objects;

public final class Triangle {

    /* Класс описывает треугольник. Координаты точек задаются объектами класса Pair. */

    private final Pair<Double, Double> point1;
    private final Pair<Double, Double> point2;
    private final Pair<Double, Double> point3;
    private final double lengthA;
    private final double lengthB;
    private final double lengthC;

    public Triangle()
    {
        point1 = new Pair<Double, Double>(-2.0, 0.0);
        point2 = new Pair<Double, Double>(0.0, 3.0);
        point3 = new Pair<Double, Double>(2.0, 0.0);
        lengthA = getDistance(point1, point2);
        lengthB = getDistance(point2, point3);
        lengthC = getDistance(point3, point1);
    }

    public Triangle(Pair<Double, Double> point1, Pair<Double, Double> point2, Pair<Double, Double> point3) throws MyException {
        double distanceA = getDistance(point1, point2);
        double distanceB = getDistance(point2, point3);
        double distanceC = getDistance(point3, point1);
        if (isTriangleExist(distanceA, distanceB, distanceC))
        {
            this.point1 = point1;
            this.point2 = point2;
            this.point3 = point3;
            this.lengthA = distanceA;
            this.lengthB = distanceB;
            this.lengthC = distanceC;
        }
        else
        {
            throw new MyException("Входные данные некорректны. Такой треугольник не может существовать.");
        }
    }

    public double areaOfATriangle()
    {
        // Площадь треугольника.
        double perimeter = trianglePerimeter();
        return Math.sqrt(perimeter * 0.5 * (perimeter * 0.5 - lengthA) * (perimeter * 0.5 - lengthB)
                * (perimeter * 0.5 - lengthC));
    }

    public double trianglePerimeter()
    {
        // Периметр треугольника.
        return lengthA + lengthB + lengthC;
    }

    public Pair<Double, Double> meridianIntersectionPoint()
    {
        // Возвращает точку пересечения меридиан.
        return new Pair<Double, Double>((point1.getKey() + point2.getKey() + point3.getKey()) / 3,
                (point1.getValue() + point2.getValue() + point3.getValue()) / 3);
    }

    public double getLengthA() {
        return lengthA;
    }

    public double getLengthB() {
        return lengthB;
    }

    public double getLengthC() {
        return lengthC;
    }

    public Pair<Double, Double> getPoint1() {
        return point1;
    }

    public Pair<Double, Double> getPoint2() {
        return point2;
    }

    public Pair<Double, Double> getPoint3() {
        return point3;
    }

    private static boolean isTriangleExist(double lengthA, double lengthB, double lengthC)
    {
        // Определяет существование треугольника.
        return lengthA + lengthB > lengthC && lengthB + lengthC > lengthA && lengthA + lengthC > lengthB;
    }

    private static double getDistance(Pair<Double, Double> point1, Pair<Double, Double> point2)
    {
        // Возвращает расстояние между двумя точками.
        return Math.sqrt(Math.pow(Math.abs(point2.getKey() - point1.getKey()), 2)
                + Math.pow(Math.abs(point2.getValue() - point1.getValue()), 2));
    }

    @Override
    public String toString() {
        return "Triangle{" +
                "point1=" + point1 +
                ", point2=" + point2 +
                ", point3=" + point3 +
                ", lengthA=" + lengthA +
                ", lengthB=" + lengthB +
                ", lengthC=" + lengthC +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Triangle triangle = (Triangle) o;
        return Objects.equals(point1, triangle.point1) &&
                Objects.equals(point2, triangle.point2) &&
                Objects.equals(point3, triangle.point3);
    }

    @Override
    public int hashCode() {
        return Objects.hash(point1, point2, point3);
    }
}