package com.book.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.book.entity.Book;
import com.book.utility.HibernateUtil;

public class BookDao
{
    public static void saveBook(Book book)
    {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

        if (sessionFactory == null)
        {
            throw new RuntimeException("SessionFactory is NULL. Check HibernateUtil.");
        }

        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();

        session.persist(book);

        tx.commit();
        session.close();
    }

    public static List<Book> listBook()
    {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Query<Book> query = session.createQuery("from Book", Book.class);
        List<Book> bookList = query.list();
        session.close();
        return bookList;
    }
}
