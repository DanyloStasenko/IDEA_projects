package com.springapp.mvc.model;
import javax.persistence.*;

@Entity
@Table(name = "books")
public class Book
{
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "book_title")
    private String bookTitle;

    @Column(name = "book_author")
    private String bookAuthor;

    @Column(name = "book_price")
    private int bookPrice;


    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getBookTitle()
    {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle)
    {
        this.bookTitle = bookTitle;
    }

    public String getBookAuthor()
    {
        return bookAuthor;
    }

    public void setBookAuthor(String bookAuthor)
    {
        this.bookAuthor = bookAuthor;
    }

    public int getBookPrice()
    {
        return bookPrice;
    }

    public void setBookPrice(int bookPrice)
    {
        this.bookPrice = bookPrice;
    }

    @Override
    public String toString()
    {
        return "Book{"+
                "id"+id+
                ", bookTitle='" + bookTitle + '\'' +
                ", bookAuthor='" + bookAuthor + '\'' +
                ", bookTitle='" + bookPrice +
                '}';

    }
}
