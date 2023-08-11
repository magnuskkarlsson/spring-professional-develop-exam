package se.mkk.springprofessionaldevelopexam.profile;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class PersonService {
	private final String param;

	public PersonService(@Value("${param99.value}") String param) {
		this.param = param;
	}

	@Override
	public String toString() {
		return "PersonService [param=" + param + "]";
	}
}
