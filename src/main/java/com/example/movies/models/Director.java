package com.example.movies.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.time.LocalDate;

@Entity
public class Director {
    @Id
    private Long id;

    @Column(name = "name")
    String name;

    @Column(name = "birthday")
    LocalDate date;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
