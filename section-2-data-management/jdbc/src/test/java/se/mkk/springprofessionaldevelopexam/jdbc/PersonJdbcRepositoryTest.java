package se.mkk.springprofessionaldevelopexam.jdbc;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Commit;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.transaction.annotation.Transactional;

@SpringJUnitConfig({ Config.class, TestConfig.class }) // @ContextConfiguration, no @EnableAutoConfiguration
// make all tests transactional
// after all @Test are transaction rolled back
@Transactional
@TestPropertySource(properties = { "username=myway" }, locations = { "classpath:/local.properties" })
public class PersonJdbcRepositoryTest {
    @Autowired
    private PersonJdbcRepository personJdbcRepository;

    @Test
    @Commit // this test is commited after @Test
    public void findAll() {
        System.out.println(personJdbcRepository.findAll());
    }

    @Test
    public void insert() {
        System.out.println(personJdbcRepository.insert(new Person().setId(3).setName("NEW NAME")));
        System.out.println(personJdbcRepository.findAll());
    }

    @Test
    @DirtiesContext // next test gets a new Application Context
    public void delete() {
        System.out.println(personJdbcRepository.delete(2));
    }
}
