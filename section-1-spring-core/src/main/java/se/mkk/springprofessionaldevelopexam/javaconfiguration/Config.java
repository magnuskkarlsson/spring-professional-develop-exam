package se.mkk.springprofessionaldevelopexam.javaconfiguration;

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
