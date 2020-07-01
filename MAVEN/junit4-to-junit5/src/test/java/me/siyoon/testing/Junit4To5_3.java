package me.siyoon.testing;

import org.junit.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class Junit4To5_3 {
    @BeforeAll
    public static void beforeClass() {
        System.out.println("beforeClass");
    }

    @BeforeEach
    public void before() {
        System.out.println("before");
    }

    @Test
    public void shouldMigrateTestToSimpleTest() {
        Assert.assertEquals("expected", "expected");
    }

    @Test
    @Disabled
    public void ignoreTestToDisableTest() {

    }

    @Test
    public void shouldStillSupportHamcrestMatchers() {
        assertThat(1, equalTo(1));
    }

    @Test
    public void shouldStillSupportAssume() {
        Assume.assumeTrue(javaVersion() > 0);
    }

    @AfterEach
    public void after() {
        System.out.println("after");
    }

    @AfterAll
    public static void afterClass() {
        System.out.println("afterClass");
    }

    private int javaVersion() {
        return 8;
    }
}
