package com.example.movies.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "director")
public class Director {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "birthday")
    private LocalDate date;

    @OneToMany(mappedBy = "director", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private  List<Movies> movies;

    public List<Movies> getMovies() {
        return movies;
    }

    public void setMovies(List<Movies> movies) {
        this.movies = movies;
    }

    public Director() {
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof Director)){
            return false;
        }
        Director director = (Director) obj;
        return Objects.equals(director.getName(), name) && Objects.equals(director.getDate(), date);
    }
}
