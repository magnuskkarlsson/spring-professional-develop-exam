package se.mkk.springprofessionaldevelopexam.profile;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		// -Dspring.profiles.active=dev,embedded
		System.setProperty("spring.profiles.active", "dev");
		ConfigurableApplicationContext ctx = SpringApplication.run(Application.class, args);
		System.out.println(ctx.getBean("personService"));
	}
}
