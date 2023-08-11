package se.mkk.springprofessionaldevelopexam.javaconfiguration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext ctx = SpringApplication.run(Application.class, args);
		System.out.println(ctx.getBean("foo"));
		System.out.println(ctx.getBean("bar"));
		System.out.println(ctx.getBean("code"));
		System.out.println(ctx.getBean("person"));
	}
}
