package com.springapp.mvc.dao;

import com.springapp.mvc.model.Book;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class BookDaoImpl implements BookDao
{
    private static final Logger logger = LoggerFactory.getLogger(BookDaoImpl.class);

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory)
    {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void addBook(Book book)
    {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(book);
        logger.info("Book succesfully saved" + book);
    }

    @Override
    public void updateBook(Book book)
    {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(book);
        logger.info("Book updated" + book);
    }

    @Override
    public void removeBook(int id)
    {
        Session session = this.sessionFactory.getCurrentSession();
        Book book = (Book) session.load(Book.class, new Integer(id));
        if (book!=null)
        {
            session.delete(book);
        }
        logger.info("Book deleted" + book);
    }

    @Override
    public Book getBookById(int id)
    {
        Session session = this.sessionFactory.getCurrentSession();
        Book book = (Book) session.load(Book.class, new Integer(id));
        logger.info("Book loaded" + book);
        return book;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Book> listBooks()
    {
        Session session = this.sessionFactory.getCurrentSession();
        List<Book> bookList = session.createQuery("from Book").list();

        for(Book book : bookList)
        {
            logger.info("Book list: " + book);
        }
        return bookList;
    }
}
