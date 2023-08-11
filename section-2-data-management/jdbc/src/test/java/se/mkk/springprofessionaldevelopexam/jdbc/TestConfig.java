package se.mkk.springprofessionaldevelopexam.jdbc;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;

@Configuration
public class TestConfig {

    @Bean
    public DataSource dataSource() {
//        return DataSourceBuilder.create() //
//                .driverClassName("org.hsqldb.jdbc.JDBCDriver") //
//                .url("jdbc:hsqldb:mem:testdb;DB_CLOSE_DELAY=-1") //
//                .username("sa") //
//                .password("").build();
        return new EmbeddedDatabaseBuilder().addScript("schema.sql").addScript("data.sql").build();
    }

    @Bean
    public JdbcTemplate jdbcTemplate(DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }

    @Bean
    public PersonJdbcRepository personJdbcRepository(JdbcTemplate jdbcTemplate) {
        return new PersonJdbcRepository(jdbcTemplate);
    }
}
