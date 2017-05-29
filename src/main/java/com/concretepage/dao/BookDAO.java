package com.concretepage.dao;

import com.concretepage.entity.Article;
import com.concretepage.entity.Author;
import com.concretepage.entity.Book;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Transactional
@Repository
public class BookDAO implements IBookDAO {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Book> getAllBooks(String hql) {
        return (List<Book>) entityManager.createQuery(hql).getResultList();
    }

    @Override
    public void addBook(Book book) {
        entityManager.persist(book);
    }
}
