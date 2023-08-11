package se.mkk.springprofessionaldevelopexam.jpa;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import jakarta.persistence.EntityManagerFactory;

@Configuration
@EnableTransactionManagement // required 1 for transaction
public class Config {

    // required 2 for transaction
//    @Bean
//    public PlatformTransactionManager platformTransactionManager(EntityManagerFactory emf) {
//        return new JpaTransactionManager(emf);
//    }
}
