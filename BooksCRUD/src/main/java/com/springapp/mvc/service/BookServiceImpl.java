package com.springapp.mvc.service;

import com.springapp.mvc.dao.BookDao;
import com.springapp.mvc.model.Book;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BookServiceImpl implements BookService
{
    private BookDao bookDao;

    public void setBookDao(BookDao bookDao)
    {
        this.bookDao = bookDao;
    }

    @Override
    @Transactional
    public void addBook(Book book)
    {
        this.bookDao.addBook(book);
    }

    @Override
    @Transactional
    public void updateBook(Book book)
    {
        this.bookDao.updateBook(book);

    }

    @Override
    @Transactional
    public void removeBook(int id)
    {
        this.bookDao.removeBook(id);

    }

    @Override
    @Transactional
    public Book getBookById(int id)
    {
        return this.bookDao.getBookById(id);
    }

    @Override
    @Transactional
    public List<Book> listBooks()
    {
        return this.bookDao.listBooks();
    }
}
