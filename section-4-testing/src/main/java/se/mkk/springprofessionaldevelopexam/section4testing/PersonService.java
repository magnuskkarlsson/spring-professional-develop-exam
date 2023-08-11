package se.mkk.springprofessionaldevelopexam.section4testing;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import jakarta.annotation.PostConstruct;

@Service
public class PersonService {
    private final List<Person> persons = new ArrayList<>();

    @PostConstruct
    public void postConstruct() {
        persons.add(new Person().setId(0).setName("John Doe"));
        persons.add(new Person().setId(1).setName("Foo Bar"));
    }

    public List<Person> findAll() {
        return persons;
    }

    public Person findById(int id) {
        return persons.get(id);
    }

    public Person create(Person person) {
        persons.add(person.setId(persons.size()));
        return person;
    }

    public void update(Person person) {
        Person entity = persons.get(person.getId());
        entity.setName(person.getName());
    }

    public void delete(int id) {
        persons.remove(id);
    }
}
