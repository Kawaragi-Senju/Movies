package com.example.movies.dao;

import com.example.movies.models.TableName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TableNameREpository extends JpaRepository<TableName, Integer> {
}
