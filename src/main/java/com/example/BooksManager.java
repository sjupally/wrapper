package com.example;

import com.example.entity.Author;
import com.example.entity.Book;
import com.example.util.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.Date;
import java.util.List;

/**
 * This program demonstrates using Hibernate framework to manage
 * a one-to-one mapping with foreign key using annotations.
 *
 * @author www.codejava.net
 */
public class BooksManager {

    public static void main(String[] args) {
        // builds a session factory from the service registry
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

        // obtains the session
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();

        // creates a Book entity
        for (int i = 1; i < 100; i++) {
            Book newBook = new Book();
            newBook.setTitle("Hibernate12"+i);
            newBook.setNirc("652ISFHA"+i);
            newBook.setPrice(1.5*i);
            newBook.setDescription("Simplified Data Persistence with Hibernate and JPA");
            newBook.setPublishedDate(new Date());
            // persists the book entity
            session.save(newBook);
        }


        Query query = session.createQuery("FROM Book");
        List<Book> list = query.list();




        session.getTransaction().commit();
        session.close();
    }

    public List<Book> getBooks(){
        // builds a session factory from the service registry
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

        // obtains the session
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();

        // creates a Book entity
        for (int i = 1; i < 100; i++) {
            Book newBook = new Book();
            newBook.setTitle("Hibernate12"+i);
            newBook.setNirc("652ISFHA"+i);
            newBook.setPrice(1.5*i);
            newBook.setDescription("Simplified Data Persistence with Hibernate and JPA");
            newBook.setPublishedDate(new Date());
            // persists the book entity
            session.save(newBook);
        }


        Query query = session.createQuery("FROM Book");
        List<Book> list = query.list();




        session.getTransaction().commit();
        session.close();
        return list;
    }
}