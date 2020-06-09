package com.company.bookmodel;

import java.util.Arrays;

public class Book {

    private static int idUnique = 0;

    private int id;
    private String name;
    private String[] authors;
    private String publishingHouse;
    private int year;
    private int numberOfPages;
    private double price;
    private String bindingType;

    public Book() {
        id = idUnique++;
        name = "Программирование Java";
        authors = new String[]{"Стрельченко И.В", "Невмержицкий Г.Н"};
        publishingHouse = "АСТ";
        year = 2015;
        numberOfPages = 545;
        price = 25.75;
        bindingType = "Твердый";
    }

    public Book(String name, String[] authors, String publishingHouse, int year, int numberOfPages, double price, String bindingType) {
        id = idUnique++;
        this.name = name;
        this.authors = authors;
        this.publishingHouse = publishingHouse;
        this.year = year;
        this.numberOfPages = numberOfPages;
        this.price = price;
        this.bindingType = bindingType;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String[] getAuthors() {
        return authors;
    }

    public String getPublishingHouse() {
        return publishingHouse;
    }

    public int getYear() {
        return year;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    public double getPrice() {
        return price;
    }

    public String getBindingType() {
        return bindingType;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAuthors(String[] authors) {
        this.authors = authors;
    }

    public void setPublishingHouse(String publishingHouse) {
        this.publishingHouse = publishingHouse;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setNumberOfPages(int numberOfPages) {
        this.numberOfPages = numberOfPages;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setBindingType(String bindingType) {
        this.bindingType = bindingType;
    }

    public void printInfo()
    {
        System.out.println(toString());
    }

    @Override
    public String toString() {
        return "Книга {" +
                "id: " + id +
                ", Название: " + name +
                ", Авторы: " + Arrays.toString(authors) +
                ", Издательство: " + publishingHouse +
                ", Год: " + year +
                ", Количество страниц: " + numberOfPages +
                ", Цена: " + price + " USD" +
                ", Тип переплета: " + bindingType +
                '}';
    }

    public boolean isBookWithAGivenAuthor(String author)
    {
        // Является ли книга книгой заданного автора.
        for (String authorOfBook : authors)
        {
            if (authorOfBook.equalsIgnoreCase(author))
                return true;
        }
        return false;
    }

    public boolean isBookWithAGivenPublishingHouse(String publishingHouse)
    {
        // Является ли книга книгой заданного издательства.
        return this.publishingHouse.equals(publishingHouse);
    }

    public boolean isBookAfterGivenYear(int year)
    {
        // Является ли год выпуска книги больше заданного.
        return this.year > year;
    }
}