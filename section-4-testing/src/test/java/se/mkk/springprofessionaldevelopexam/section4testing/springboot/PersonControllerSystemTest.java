package se.mkk.springprofessionaldevelopexam.section4testing.springboot;

import java.net.URI;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;

import se.mkk.springprofessionaldevelopexam.section4testing.Person;

// Spring Boot Testing
//
// @SpringBootTest - Full System Test
// @WebMvcTest - @MockBean
// @DataJpaTest, @DataJdbcTest
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class PersonControllerSystemTest {
    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void findAll() {
        String url = "/api/persons";
        Person[] persons = restTemplate.getForObject(url, Person[].class);
        System.out.println(List.of(persons));
    }

    @Test
    public void findById() {
        String url = "/api/persons/{id}";
        Person person = restTemplate.getForObject(url, Person.class, 0);
        System.out.println(person);
    }

    @Test
    public void create() {
        String url = "/api/persons";
        URI location = restTemplate.postForLocation(url, new Person().setName("David"));
        System.out.println(location);
        Person person = restTemplate.getForObject(location, Person.class);
        System.out.println(person);
    }

    @Test
    public void update() {
        String url = "/api/persons";
        RequestEntity<Person> req = RequestEntity.put(url) //
                .contentType(MediaType.APPLICATION_JSON) //
                .accept(MediaType.APPLICATION_JSON) //
                .body(new Person().setId(1).setName("David"));
        ResponseEntity<Void> resp = restTemplate.exchange(req, Void.class);
        System.out.println(resp.getStatusCode());

        String url2 = "/api/persons/{id}";
        Person person = restTemplate.getForObject(url2, Person.class, 1);
        System.out.println(person);
    }
}
