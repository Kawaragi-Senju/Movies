package dao;

import com.example.movies.dao.DirectorRepository;
import com.example.movies.models.Director;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDate;

@DataJpaTest
public class DirectorRepositoryTest {

    @Autowired
    DirectorRepository directorRepository;


    @Test
    public void testDB(){
        Director director = new Director();
        director.setDate(LocalDate.ofEpochDay(1944-05-14));
        director.setName("fdansjfsjkdf");
//        Movies movies = new Movies();
//        movies.setDirector(null);
//        movies.setFilmname("sfdksfsmdf");
        directorRepository.save(director);
        Director director1 = directorRepository.getReferenceById(1);

        Assertions.assertEquals(director1, director);
    }
}