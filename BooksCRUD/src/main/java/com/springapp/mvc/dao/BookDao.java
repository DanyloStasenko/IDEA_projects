package com.springapp.mvc.dao;

import com.springapp.mvc.model.Book;

import java.util.List;

public interface BookDao
{
    public void addBook(Book book);
    public void updateBook(Book book);
    public void removeBook(int id);
    public Book getBookById(int id);
    public List<Book> listBooks();
}
