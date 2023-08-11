package se.mkk.springprofessionaldevelopexam.javaconfiguration;

public class Foo {
	private final String param;

	public Foo(String param) {
		this.param = param;
	}

	@Override
	public String toString() {
		return "Foo [param=" + param + "]";
	}
}
