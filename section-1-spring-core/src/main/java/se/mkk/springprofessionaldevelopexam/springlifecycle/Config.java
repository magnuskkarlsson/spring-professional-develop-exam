package se.mkk.springprofessionaldevelopexam.springlifecycle;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {

    // before beans are created, can i.e. read properties, register custom scopes
    @Bean
    public static BeanFactoryPostProcessor beanFactoryPostProcessor() {
        return new BeanFactoryPostProcessor() {

            @Override
            public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
                System.out.println("BeanFactoryPostProcessor#postProcessBeanFactory " + beanFactory);
            }
        };
    }

    // bean created, can modify bean in any way. run against every bean
    @Bean
    public BeanPostProcessor BeanPostProcessor() {
        return new BeanPostProcessor() {

            // runs before the initializer, @bean original bean
            @Override
            public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
                System.out.println("BeanPostProcessor#postProcessBeforeInitialization " + bean + " " + beanName);
                return bean; // remember to return bean
            }

            // runs after the initializer
            @Override
            public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
                System.out.println("BeanPostProcessor#postProcessAfterInitialization " + bean + " " + beanName);
                return bean; // remember to return bean
            }
        };
    }
}
