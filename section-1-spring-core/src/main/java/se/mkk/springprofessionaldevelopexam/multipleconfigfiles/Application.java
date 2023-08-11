package se.mkk.springprofessionaldevelopexam.multipleconfigfiles;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import({ ApplicationConfig.class, InfrastructureConfig.class })
public class Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext ctx = SpringApplication.run(Application.class, args);
		Adress adress1 = ctx.getBean("adress", Adress.class);
		Adress adress2 = ctx.getBean("adress", Adress.class);
		System.out.println(adress1.equals(adress2));

		Person person1 = ctx.getBean("something", Person.class);
		Person person2 = ctx.getBean("something", Person.class);
		System.out.println(person1.equals(person2));
	}
}
