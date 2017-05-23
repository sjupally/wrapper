package com.example.entity;


import javax.persistence.*;

@Entity
@Table(name = "AUTHOR")
public class Author {
    @Id
    @Column(name = "AUTHOR_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "EMAIL")
    private String email;

    public Author() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Author(String name, String email) {
        this.name = name;
        this.email = email;

    }


}