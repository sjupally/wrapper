package com.concretepage.dao;

import com.concretepage.entity.Article;
import com.concretepage.entity.Author;
import com.concretepage.entity.Book;

import java.util.List;

public interface IBookDAO {
    List<Book> getAllBooks(String hql);
    void addBook(Book book);
}
 