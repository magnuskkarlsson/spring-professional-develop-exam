package se.mkk.springprofessionaldevelopexam.section4testing.springframework;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import config.DefaultConfig;

@SpringJUnitConfig(DefaultConfig.class)
@ActiveProfiles({ "dev", "local" })
public class ActiveProfilesTest {

    @Test
    public void test() {
        assertTrue(true);
        System.out.println("Test");
    }
}
