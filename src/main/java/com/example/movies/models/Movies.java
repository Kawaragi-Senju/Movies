package com.example.movies.models;

import jakarta.persistence.*;

@Entity
@Table(name = "movies")
public class Movies {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "filmname")
    String filmname;

    @Column(name = "director_id")
    Long directorId;

    @ManyToOne()
    @JoinColumn(name ="director_id",  updatable = false, insertable = false)
    Director director;

    public String getFilmname() {
        return filmname;
    }

    public void setFilmname(String filmname) {
        this.filmname = filmname;
    }

    public Long getDirector_id() {
        return directorId;
    }

    public void setDirector_id(Long director_id) {
        this.directorId = director_id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
