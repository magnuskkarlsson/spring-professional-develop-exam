package se.mkk.springprofessionaldevelopexam.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jmx.JmxException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Repository

@Transactional(propagation = Propagation.REQUIRED, // default can also be Propagation.REQUIRES_NEW
        timeout = 60, // timeout in seconds, can be override with method annotation
        rollbackFor = DataAccessException.class, noRollbackFor = { JmxException.class })
public class PersonJdbcRepository {
    private final JdbcTemplate jdbcTemplate;
    // To map to domain object, use:
    // 1. RowMapper
    // 2. ResultSetExtractor - used for queries not mapped to domain object
    private final PersonRowMapper personRowMapper = new PersonRowMapper();

    // NO mapping domain objects, use:
    // 1. queryForMap - singular row
    // 2. queryForList - multiple rows

    @Autowired
    public PersonJdbcRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Person> findAll() {
        String sql = "SELECT id, name FROM person";
        return jdbcTemplate.query(sql, personRowMapper);
    }

    public Person findById(int id) {
        String sql = "SELECT id, name FROM person WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, personRowMapper, id);
    }

    public int insert(Person person) {
        String sql = "INSERT INTO person (id, name) VALUES (?, ?)";
        return jdbcTemplate.update(sql, person.getId(), person.getName());
    }

    public int update(Person person) {
        String sql = "UPDATE person SET name = ? WHERE id = ?";
        return jdbcTemplate.update(sql, person.getName(), person.getId());
    }

    public int delete(int id) {
        String sql = "DELETE FROM person WHERE id = ?";
        return jdbcTemplate.update(sql, id);
    }

    public class PersonRowMapper implements RowMapper<Person> {

        @Override
        public Person mapRow(ResultSet rs, int rowNum) throws SQLException {
            int id = rs.getInt("id");
            String name = rs.getString("name");
            return new Person().setId(id).setName(name);
        }
    }
}
