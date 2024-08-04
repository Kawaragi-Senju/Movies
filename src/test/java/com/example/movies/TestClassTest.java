package com.example.movies;

import com.example.movies.controller.MainController;
import com.example.movies.dao.DirectorRepository;
import com.example.movies.dao.MoviesRepository;
import com.example.movies.models.Director;
import com.example.movies.models.Movies;
import com.example.movies.service.ServiceTransaction;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
@WebMvcTest(controllers = MainController.class)
public class TestClassTest {
    TestClass testClass = new TestClass();

    @Autowired
    MockMvc mockMvc;


    @MockBean
    ServiceTransaction serviceTransaction;

    @MockBean
    DirectorRepository directorRepository;


    @InjectMocks
    ServiceTransaction serviceTransactions;

    @MockBean
    MoviesRepository moviesRepository;

//    @Test
//    public void test(){
//        String str = "Privet";
//        Assertions.assertEquals(testClass.test(), str);
//    }
//
//    @Test
//    public void testt(){
//        String str = "Двадцать два";
//        Executable executable = () -> testClass.returnInt(str);
//        Assertions.assertThrows(RuntimeException.class, executable);
//    }

    @Test
    public void testTest(){
        Director director = new Director();
        when(directorRepository.getDirectorById(1L)).thenReturn(director);
        Director directorS = serviceTransactions.getById(1L);

        Assertions.assertEquals(director, directorS);
    }

    @Test
    public void gbiTest() throws Exception {
        mockMvc.perform(get("/gbi/{id}", 1)).andExpect(status().isOk());
    }

    @Test
    public void amTest() throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        Movies movies = new Movies();
        Movies newMovies = new Movies();
        movies.setId(1L);
        movies.setFilmname("filmname");
        movies.setActorList(null);
        movies.setDirector(null);
        when(moviesRepository.getReferenceById(1)).thenReturn(movies);

        mockMvc.perform(get("/am")).andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(content().json(objectMapper.writeValueAsString(movies)));
    }
}
