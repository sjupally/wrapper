package com.concretepage.entity;

import com.univocity.parsers.annotations.FixedWidth;
import com.univocity.parsers.annotations.Format;
import com.univocity.parsers.annotations.Nested;
import com.univocity.parsers.annotations.Parsed;
import com.univocity.parsers.fixed.FieldAlignment;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "BOOK")
public class Book {
    @Id
    @Column(name = "BOOK_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @FixedWidth(value = 30, alignment = FieldAlignment.LEFT, padding = '0')
    @Parsed
    @Column(name = "TITLE")
    private String title;

    @FixedWidth(value = 30, alignment = FieldAlignment.RIGHT, padding = '0')
    @Parsed
    @Column(name = "NIRC")
    private String nirc;

    @FixedWidth(value = 35)
    @Format(formats = "#0.00", options = "decimalSeparator=.")
    @Parsed
    @Column(name = "price")
    private Double price;

    @Column(name = "description")
    private String description;

    @Column(name = "PUBLISHED")
    private Date publishedDate;

    @Nested
    @OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "AUTHOR_ID")
    private Author author;

    public  Book() {

    }

    public Book(String title, String nirc, Double price, String description, Date publishedDate, Author author) {
        this.title = title;
        this.nirc = nirc;
        this.price = price;
        this.description = description;
        this.publishedDate = publishedDate;
        this.author = author;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getNirc() {
        return nirc;
    }

    public void setNirc(String nirc) {
        this.nirc = nirc;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getPublishedDate() {
        return publishedDate;
    }

    public void setPublishedDate(Date publishedDate) {
        this.publishedDate = publishedDate;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "BookProxy{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", nirc='" + nirc + '\'' +
                ", price=" + price +
                ", description='" + description + '\'' +
                ", publishedDate=" + publishedDate +
                '}';
    }
}