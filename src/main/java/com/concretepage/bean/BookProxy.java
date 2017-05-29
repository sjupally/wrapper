package com.concretepage.bean;

import com.univocity.parsers.annotations.Parsed;

public class BookProxy {

    @Parsed
    private String title;
    @Parsed
    private String nirc;
    @Parsed
    private Double price;


    public BookProxy(String title, String nirc, Double price) {
        this.title = title;
        this.nirc = nirc;
        this.price = price;
    }

    public BookProxy() {

    }

    @Override
    public String toString() {
        return "BookProxy{" +
                "title='" + title + '\'' +
                ", nirc='" + nirc + '\'' +
                ", price=" + price +
                '}';
    }
}