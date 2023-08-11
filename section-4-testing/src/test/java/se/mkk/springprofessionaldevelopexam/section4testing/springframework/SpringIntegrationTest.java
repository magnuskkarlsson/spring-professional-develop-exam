package se.mkk.springprofessionaldevelopexam.section4testing.springframework;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import config.DefaultConfig;
import se.mkk.springprofessionaldevelopexam.section4testing.PersonService;

@SpringJUnitConfig(DefaultConfig.class) // No auto annotated beans are created, only these in Config class
@TestPropertySource(properties = { "db.username=foo", "db.password=changeit" }, //
        locations = "classpath:local.properties")
public class SpringIntegrationTest {

    @Autowired // autowired bean from above Config class
    private PersonService personService;

    @Test
    public void test() {
    }

    @DirtiesContext
    @Test
    public void contextClosedAndDestroyedAtTheEndOfTest() {
        // test failure and corrupt DB, need new Spring Context afterwards
    }
}
