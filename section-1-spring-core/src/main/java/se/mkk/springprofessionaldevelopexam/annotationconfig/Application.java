package se.mkk.springprofessionaldevelopexam.annotationconfig;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
// override, reset default and set root scan package
@ComponentScan("se.mkk.springprofessionaldevelopexam.annotationconfig")
public class Application {

    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = SpringApplication.run(Application.class, args);
        System.out.println(ctx.getBean("personService", PersonService.class).getStatus());
        ctx.getBean("personService", PersonService.class).exec();
    }
}
