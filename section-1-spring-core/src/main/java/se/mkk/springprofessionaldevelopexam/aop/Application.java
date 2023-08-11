package se.mkk.springprofessionaldevelopexam.aop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * <code><pre>
 *  <dependency> 
 *      <groupId>org.springframework</groupId> 
 *      <artifactId>spring-aspects</artifactId> 
 *  </dependency>
 * </pre></code>
 */
@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = SpringApplication.run(Application.class, args);
        System.out.println(ctx.getBean("person", Person.class).doSomething());
        ctx.getBean("person", Person.class).throwException();
    }
}
