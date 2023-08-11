package se.mkk.springprofessionaldevelopexam.jpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = SpringApplication.run(Application.class, args);
        PersonCrudRepository repo = ctx.getBean("personCrudRepository", PersonCrudRepository.class);
        System.out.println(repo.findAll());
        System.out.println(repo.findById(1L));
        System.out.println(repo.save(new Person().setName("NEW NAME")));
        System.out.println(repo.findAll());
        Person entity = repo.findById(1L).get().setName("UPDATE NAME");
        System.out.println(repo.save(entity));
        System.out.println(repo.findAll());
        repo.deleteById(3L);
        System.out.println(repo.findAll());
    }
}
