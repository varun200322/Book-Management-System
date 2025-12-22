package com.book.dao;

import org.hibernate.SessionFactory;
import org.hibernate.SharedSessionContract;
import org.hibernate.query.QueryProducer;
import org.hibernate.query.SelectionQuery;

import com.book.entity.Book;
import com.book.utility.HibernateUtil;
import com.mysql.cj.Session;

import java.util.List;
import jakarta.transaction.HeuristicMixedException;
import jakarta.transaction.HeuristicRollbackException;
import jakarta.transaction.RollbackException;
import jakarta.transaction.SystemException;
import jakarta.transaction.Transaction;

public class BookDao 
{
	public static void saveBook(Book book)
	{
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = (Session) sessionFactory.openSession();
		Transaction tx = (Transaction) ((SharedSessionContract) session).beginTransaction();
		((org.hibernate.Session) session).persist(book);
		try {
			tx.commit();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RollbackException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (HeuristicMixedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (HeuristicRollbackException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		session.forceClose();
	}
	public static List<Book> listBook()
	{
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = (Session) sessionFactory.openSession();
		SelectionQuery<Book> query = ((QueryProducer) session).createSelectionQuery("from Book", Book.class);
		List<Book> bookList = query.list();
		return bookList;
		
	}
}
