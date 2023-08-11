package se.mkk.springprofessionaldevelopexam.annotationconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {

    @Bean(initMethod = "postConstruct", destroyMethod = "preDestroy")
    public CannotModify cannotModify() {
        return new CannotModify();
    }
}
