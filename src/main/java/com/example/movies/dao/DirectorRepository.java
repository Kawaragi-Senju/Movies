package com.example.movies.dao;

import com.example.movies.models.Director;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface DirectorRepository extends JpaRepository<Director, Integer> {
    @EntityGraph(attributePaths = {"movies"})
    Director getDirectorById(Long id);
}
