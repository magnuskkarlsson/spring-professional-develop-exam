package se.mkk.springprofessionaldevelopexam.multipleconfigfiles;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

// bean name/id from class name
@Component
public class OtherPerson {

	// spring uses default constructor first ...
	public OtherPerson() {
	}

	// ... if not annotated with @Autowired
	@Autowired
	public OtherPerson(@Value("${paramZ.value:mydefaultvalue}") String value1, Environment env) {
		System.out.println("value1=" + value1);

		System.out.println(env.getProperty("param1.value"));
		System.out.println(env.getProperty("paramX.value", "default"));
		System.out.println(env.getProperty("paramXY.value", Integer.class, 678));
		System.out.println("param4.value=" + env.getProperty("param4.value", Boolean.class));
	}
}
