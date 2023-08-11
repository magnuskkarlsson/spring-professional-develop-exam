package se.mkk.springprofessionaldevelopexam.javaconfiguration;

import org.springframework.beans.factory.annotation.Autowired;

public class Person {
	private final Foo foo;
	private final Foo bar;
	private final Foo code;

	@Autowired
	public Person(Foo foo, Foo bar, Foo code) {
		this.foo = foo;
		this.bar = bar;
		this.code = code;
	}

	@Override
	public String toString() {
		return "Person [foo=" + foo + ", bar=" + bar + ", code=" + code + "]";
	}
}
