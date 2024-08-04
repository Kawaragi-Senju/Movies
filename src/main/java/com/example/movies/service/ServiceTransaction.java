package com.example.movies.service;

import com.example.movies.dao.DirectorRepository;
import com.example.movies.models.Director;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ServiceTransaction {

    @Autowired
    DirectorRepository directorRepository;
//    @Autowired
//    public ServiceTransaction(DirectorRepository directorRepository){
//        this.directorRepository = directorRepository;
//    }



    @Transactional(isolation = Isolation.READ_UNCOMMITTED, rollbackFor = RuntimeException.class)
    public String service() {
        Director director = new Director();
        director.setName("sfdskf");
        directorRepository.save(director);
        throw new RuntimeException("HA-Ha");
    }

    public Director getById(Long id){
        Director director = new Director();
        return directorRepository.getDirectorById(id);
    }
}
