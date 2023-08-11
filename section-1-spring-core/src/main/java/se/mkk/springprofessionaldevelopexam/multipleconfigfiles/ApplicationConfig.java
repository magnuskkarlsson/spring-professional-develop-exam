package se.mkk.springprofessionaldevelopexam.multipleconfigfiles;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:/appl-config.properties")
@PropertySource("file:appl-config2.properties")
public class ApplicationConfig {

	@Bean
	public Adress adress(@Value("${appl-config.param1}") String applConfigParam1) {
		return new Adress(applConfigParam1);
	}
}
