package config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;

import se.mkk.springprofessionaldevelopexam.section4testing.PersonService;

@Configuration
public class DefaultConfig {

    @Bean
    public PersonService personService() {
        return new PersonService();
    }

    @Bean
    public DataSource dataSource() {
        return new EmbeddedDatabaseBuilder().setName("testdb").build(); // .addScript("schema.sql")
    }

    @Bean
    public JdbcTemplate jdbcTemplate(DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }
}
