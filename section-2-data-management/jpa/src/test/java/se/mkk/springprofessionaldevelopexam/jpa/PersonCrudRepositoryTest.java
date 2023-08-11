package se.mkk.springprofessionaldevelopexam.jpa;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

// What's part of the Spring Test Context: @Repository, EntityManager, TestEntityManager, DataSource
//
// What's not part of the Spring Test Context: @Service, @Component, @Controller beans
@DataJpaTest
public class PersonCrudRepositoryTest {

    @Autowired
    private PersonCrudRepository personCrudRepository;

    @Test
    public void findAll() {
        Iterable<Person> persons = personCrudRepository.findAll();
        assertNotNull(persons);
    }
}
