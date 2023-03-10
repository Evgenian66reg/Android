package ru.topacademy.sqlite2.models;

public class Book {
    private int id;
    private String name;
    private String author;
    private int year_publication;

    public Book() {
    }

    public Book(int id){
        this.id = id;
    }

    public Book(int id, String name, String author, int year_publication) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.year_publication = year_publication;
    }

    public Book(String name, String author, int year_publication) {
        this.name = name;
        this.author = author;
        this.year_publication = year_publication;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getYearPublication() {
        return year_publication;
    }

    public void setYearPublication(int year_publication) {
        this.year_publication = year_publication;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Book){
            Book book = (Book) obj;
            if (book.name.equals(this.name) &&
                    book.author.equals(this.author) &&
                         book.year_publication == this.year_publication && book.id == this.id){
                return true;
            }
            return false;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Книга: " +
                "id = " + id +
                ",\n    Название книги = " + name +
                ",\n    Автор = " + author +
                ",\n    Год публикации = " + year_publication;
    }

    public String showBook(){
        return "Книга: " +
                "id = " + String.valueOf(id) +
                ",\n    Название книги = " + name +
                ",\n    Автор = " + author +
                ",\n    Год публикации = " + String.valueOf(year_publication);
    }
}
