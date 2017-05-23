package com.example.entity;

import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name = "BOOK")
public class Book {
    @Id
    @Column(name = "BOOK_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "TITLE")
    private String title;

    @Column(name = "NIRC")
    private String nirc;

    @Column(name = "price")
    private Double price;

    @Column(name = "description")
    private String description;

    @Column(name = "PUBLISHED")
    private Date publishedDate;

    public Book() {
    }

    public Book(String title, String nirc, Double price, String description, Date publishedDate) {
        this.title = title;
        this.nirc = nirc;
        this.price = price;
        this.description = description;
        this.publishedDate = publishedDate;
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

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", nirc='" + nirc + '\'' +
                ", price=" + price +
                ", description='" + description + '\'' +
                ", publishedDate=" + publishedDate +
                '}';
    }
}