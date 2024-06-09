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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
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
        movies.setFilmname("Бесславные ублюдки");
        moviesRepository.save(movies);
    return "post";
    }

    @GetMapping("/cd")
    public String createDirector(){
        Director director = new Director();
        director.setName("Квентин Тарантино");
        director.setDate(LocalDate.parse("1944-05-14"));
        directorRepository.save(director);
    return "post";
    }

    @GetMapping("/gbi/{id}")
    public @ResponseBody Director getById(@PathVariable(name = "id") Long id){
        Director director = directorRepository.getDirectorById(id);
        System.out.println("sdffdfsf");
    return director;
    }
}
