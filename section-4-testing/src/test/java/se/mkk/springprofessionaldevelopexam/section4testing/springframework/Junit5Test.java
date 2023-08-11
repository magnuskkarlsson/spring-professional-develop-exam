package se.mkk.springprofessionaldevelopexam.section4testing.springframework;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Junit5Test {

    @BeforeAll
    public static void beforeAll() {
        System.out.println("BeforeAll");
    }

    @BeforeEach
    public void beforeEach() {
        System.out.println("BeforeEach");
    }

    @AfterEach
    public void afterEach() {
        System.out.println("AfterEach");
    }

    @AfterAll
    public static void afterAll() {
        System.out.println("AfterAll");
    }

    @Test
    @DisplayName("More descriptive text than method name")
    public void test() {
        assertTrue(true);
        System.out.println("Test");
    }

    @Disabled
    @Test
    public void disabled() {
        fail("Disabled test");
        System.out.println("Disabled");
    }
}
