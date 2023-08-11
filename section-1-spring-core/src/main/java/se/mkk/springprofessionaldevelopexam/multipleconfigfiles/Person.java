package se.mkk.springprofessionaldevelopexam.multipleconfigfiles;

import org.springframework.context.annotation.DependsOn;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

// bean name/id from annotation name/value
@Component("something")
@DependsOn("adress")
// default bean scope is singleton
// ConfigurableBeanFactory#SCOPE_PROTOTYPE
// ConfigurableBeanFactory#SCOPE_SINGLETON
// org.springframework.web.context.WebApplicationContext#SCOPE_REQUEST
// org.springframework.web.context.WebApplicationContext#SCOPE_SESSION
@Scope("prototype")
public class Person {

}
