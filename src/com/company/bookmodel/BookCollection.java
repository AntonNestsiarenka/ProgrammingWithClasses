package com.company.bookmodel;

import java.util.ArrayList;

public class BookCollection {

    private ArrayList<Book> books = new ArrayList<Book>();

    public BookCollection(Book book)
    {
        addBookToBookCollection(book);
    }

    public BookCollection(Book...books)
    {
        for (Book book : books)
        {
            addBookToBookCollection(book);
        }
    }

    public BookCollection(ArrayList<Book> books)
    {
        this.books = books;
    }

    public ArrayList<Book> getBooks() {
        return books;
    }

    public void addBookToBookCollection(Book book)
    {
        // Добавление книги в коллекцию.
        books.add(book);
    }

    public void addBooksToBookCollection(ArrayList<Book> books)
    {
        // Добавление стопки книг в коллекцию.
        if (this.books != books)
            this.books.addAll(books);
    }

    public void addBookCollectionToBookCollection(BookCollection bookCollection)
    {
        // Добавление коллекции книг в коллекцию (объединение).
        if (this.books != bookCollection.getBooks())
            this.books.addAll(bookCollection.getBooks());
    }

    public ArrayList<Book> getBooksWithAGivenAuthor(String author)
    {
        // Возвращает список книг с заданным автором.
        ArrayList<Book> booksWithAGivenAuthor = new ArrayList<Book>();
        for (Book book : books)
        {
            if (book.isBookWithAGivenAuthor(author))
            {
                booksWithAGivenAuthor.add(book);
            }
        }
        return booksWithAGivenAuthor;
    }

    public ArrayList<Book> getBooksWithAGivenPublishingHouse(String publishingHouse)
    {
        // Возвращает список книг с заданным издательством.
        ArrayList<Book> booksWithAGivenPublishingHouse = new ArrayList<Book>();
        for (Book book : books)
        {
            if (book.isBookWithAGivenPublishingHouse(publishingHouse))
            {
                booksWithAGivenPublishingHouse.add(book);
            }
        }
        return booksWithAGivenPublishingHouse;
    }

    public ArrayList<Book> getBooksAfterGivenYear(int year)
    {
        // Возвращает список книг выпущенных после заданного года.
        ArrayList<Book> booksAfterGivenYear = new ArrayList<Book>();
        for (Book book : books)
        {
            if (book.isBookAfterGivenYear(year))
            {
                booksAfterGivenYear.add(book);
            }
        }
        return booksAfterGivenYear;
    }

    public void printInfo()
    {
        // Вывод в консоль информации о всех книгах коллекции.
        for (Book book : books)
        {
            book.printInfo();
        }
        System.out.println();
    }

    public static void printInfo(ArrayList<Book> books)
    {
        // Вывод в консоль информации о заданных книгах.
        for (Book book : books)
        {
            book.printInfo();
        }
        System.out.println();
    }
}