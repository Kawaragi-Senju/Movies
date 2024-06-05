package com.example.movies.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("/cm")
    public String createMovie(){

    }

    @GetMapping("/cd")
    public String createDirector(){

    }
}
