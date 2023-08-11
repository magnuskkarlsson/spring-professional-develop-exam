package se.mkk.springprofessionaldevelopexam.section4testing.springframework;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import config.DefaultConfig;

@SpringJUnitConfig(DefaultConfig.class)
@Sql({ "/schema.sql", "/testsql/data.sql" }) // Run these before each @Test, unless override @Sql
public class PersonRepositoryTest {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Test
    public void test() {
        String sql = "SELECT id, name FROM person";
        List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql);
        assertThat(rows.size()).isEqualTo(2);
        System.out.println(rows);
    }

    @Test
    @Sql(scripts = { "/testsql/setup.sql" })
    @Sql(scripts = { "/testsql/cleanup.sql" }, executionPhase = ExecutionPhase.AFTER_TEST_METHOD)
    public void testSetupClean() {
        String sql = "SELECT id, name FROM person";
        List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql);
        assertThat(rows.size()).isEqualTo(2);
        System.out.println(rows);
    }
}
