package com.example.movies.dao;

import com.example.movies.models.TableName;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.TestPropertySource;

@DataJpaTest
@TestPropertySource(properties = {"spring.jpa.hibernate.ddl-auto=validate"})
public class TableNameREpositoryTest {

    @Autowired
    TableNameREpository tableNameREpository;

    @Test
    public void testBase(){
        TableName tableName = new TableName();
        tableName.setName("fdsafs");
        tableName.setAge(1234);

        Assertions.assertDoesNotThrow(() -> tableNameREpository.save(tableName));
    }

}
