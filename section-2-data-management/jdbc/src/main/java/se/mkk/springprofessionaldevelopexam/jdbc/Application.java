package se.mkk.springprofessionaldevelopexam.jdbc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = SpringApplication.run(Application.class, args);
        PersonJdbcRepository repo = ctx.getBean("personJdbcRepository", PersonJdbcRepository.class);
        System.out.println(repo.findAll());
        System.out.println(repo.findById(1));
        System.out.println(repo.insert(new Person().setId(3).setName("NEW NAME")));
        System.out.println(repo.findAll());
        System.out.println(repo.update(new Person().setId(3).setName("UPDATE NAME")));
        System.out.println(repo.findAll());
        System.out.println(repo.delete(3));
        System.out.println(repo.findAll());
    }
}
