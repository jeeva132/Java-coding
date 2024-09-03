package com.pra;

import java.util.Scanner;

class Author {
    private String name;
    private String bornYear;
    private String genres;
    private int totalBook;
    private int noOfBook;
    private Book[] listOfBook;

    public Author(String name, String bornYear, String genres, int totalBook, int noOfBook, Book[] listOfBook) {
        this.name = name;
        this.bornYear = bornYear;
        this.genres = genres;
        this.totalBook = totalBook;
        this.noOfBook = noOfBook;
        this.listOfBook = listOfBook;
    }

    public String getName() {
        return name;
    }

    public String getBornYear() {
        return bornYear;
    }

    public String getGenres() {
        return genres;
    }

    public int getTotalBook() {
        return totalBook;
    }

    public int getNoOfBook() {
        return noOfBook;
    }

    public Book[] getListOfBook() {
        return listOfBook;
    }
}

class Book {
    private int bookId;
    private String bName;
    private String publishedYear;
    private int noOfCopiesSold;
    private double price;
    private double turnover;

    public Book(int bookId, String bName, String publishedYear, int noOfCopiesSold, double price) {
        this.bookId = bookId;
        this.bName = bName;
        this.publishedYear = publishedYear;
        this.noOfCopiesSold = noOfCopiesSold;
        this.price = price;
        this.turnover = price * noOfCopiesSold;
    }

    public int getBookId() {
        return bookId;
    }

    public String getBookName() {
        return bName;
    }

    public String getPublishedYear() {
        return publishedYear;
    }

    public int getNoOfCopiesSold() {
        return noOfCopiesSold;
    }

    public double getPrice() {
        return price;
    }

    public double getTurnover() {
        return turnover;
    }
}

public class PRA21 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        sc.nextLine(); // Number of authors

        Author[] authors = new Author[n];

        for (int i = 0; i < n; i++) {
            String name = sc.nextLine();
            String bornYear = sc.nextLine();
            String genres = sc.nextLine();
            int totalBook = sc.nextInt();
            int noOfBook = sc.nextInt();

            Book[] books = new Book[noOfBook];

            for (int j = 0; j < noOfBook; j++) {
                int bookId = sc.nextInt();
                sc.nextLine();
                String bookName = sc.nextLine();
                String publishedYear = sc.nextLine();
                int noOfCopiesSold = sc.nextInt();
                double price = sc.nextDouble();
                sc.nextLine();

                books[j] = new Book(bookId, bookName, publishedYear, noOfCopiesSold, price);
            }

            authors[i] = new Author(name, bornYear, genres, totalBook, noOfBook, books);
        }

        String year = sc.nextLine();

        System.out.println("Book & author details of each author with max turnover:");
        getMaximumTurnoverBookOfEachAuthor(authors);

        System.out.println("Book & author details for books published in the year " + year + ":");
        getBookByPublishedYear(authors, year);

        sc.close();
    }

    public static void getMaximumTurnoverBookOfEachAuthor(Author[] authors) {
        for (Author author : authors) {
            Book bookWithMaxTurnover = null;
            double maxTurnover = 0.0;

            for (Book book : author.getListOfBook()) {
                if (book.getTurnover() > maxTurnover) {
                    maxTurnover = book.getTurnover();
                    bookWithMaxTurnover = book;
                }
            }

            if (bookWithMaxTurnover != null) {
                System.out.println("Author: " + author.getName());
                System.out.println("Genres: " + author.getGenres());
                System.out.println("Book ID: " + bookWithMaxTurnover.getBookId());
                System.out.println("Book Name: " + bookWithMaxTurnover.getBookName());
                System.out.println("Published Year: " + bookWithMaxTurnover.getPublishedYear());
                System.out.println("Turnover: $" + bookWithMaxTurnover.getTurnover());
                System.out.println("-----");
            }
        }
    }

    public static void getBookByPublishedYear(Author[] authors, String year) {
        for (Author author : authors) {
            for (Book book : author.getListOfBook()) {
                if (book.getPublishedYear().equals(year)) {
                    System.out.println("Author: " + author.getName());
                    System.out.println("Genres: " + author.getGenres());
                    System.out.println("Book ID: " + book.getBookId());
                    System.out.println("Book Name: " + book.getBookName());
                    System.out.println("Published Year: " + book.getPublishedYear());
                    System.out.println("-----");
                }
            }
        }
    }
}
