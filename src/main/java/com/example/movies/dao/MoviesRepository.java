package com.example.movies.dao;

import com.example.movies.models.Movies;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface MoviesRepository extends JpaRepository<Movies, Integer> {
}
