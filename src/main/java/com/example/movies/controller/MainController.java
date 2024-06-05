package com.example.movies.controller;

import com.example.movies.dao.DirectorRepository;
import com.example.movies.dao.MoviesRepository;
import com.example.movies.models.Director;
import com.example.movies.models.Movies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.time.LocalDate;

@Controller
public class MainController {

    @Autowired
    DirectorRepository directorRepository;

    @Autowired
    MoviesRepository moviesRepository;

    @GetMapping("/cm")
    public String createMovie(){
        Movies movies = new Movies();
        movies.setFilmname("Однажды в Голливуде");
        movies.setDirector_id(1L);
        moviesRepository.save(movies);
    return "post";
    }

    @GetMapping("/cd")
    public String createDirector(){
        Director director = new Director();
        director.setName("Тарантино");
        director.setDate(LocalDate.parse("1964-03-27"));
        directorRepository.save(director);
    return "post";
    }

    @GetMapping("/gbi")
    public String getById(@PathVariable(name = "id") Long id, Model model){
    return "result";
    }
}
