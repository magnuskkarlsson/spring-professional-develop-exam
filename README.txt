https://start.spring.io/

Add Spring Boot DevTools. Generate.

-- Spring Framework DI

Spring Framework does not create any bean automatically. You have to do it yourself by coding. Either with

  - Java config
  - Annotation config
  
-- Java Config

In @Configuration class you have to create beans manually

Bean name: 
  1. From @Bean name/value attribute
  2. From method name

package se.mkk.springprofessionaldevelopexam1.javaconfiguration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {

	// method name will be bean name/id
	@Bean
	public Foo foo(@Value("${param1.value}") String param) {
		return new Foo(param);
	}

	// method name will be bean name/id
	@Bean
	public Foo bar(@Value("${param2.value}") String param) {
		return new Foo(param);
	}

	// bean annotation name/value will be bean name/id
	@Bean("code")
	public Foo xyz(@Value("${param3.value}") String param) {
		return new Foo(param);
	}

	// we request Foo bean with name/id: foo, bar and code
	@Bean
	public Person person(Foo foo, Foo bar, Foo code) {
		return new Person(foo, bar, code);
	}
}

-- Annotation Config


