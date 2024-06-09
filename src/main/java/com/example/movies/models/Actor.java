package com.example.movies.models;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "actors")
public class Actor {

    @Column(name = "name")
    String name;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToMany()
    @JoinTable(name = "moviesactors",
            joinColumns =  { @JoinColumn(name = "id_actor", referencedColumnName = "id")},
            inverseJoinColumns = @JoinColumn(name = "id_movie", referencedColumnName = "id"))
    List<Movies> moviesList;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
