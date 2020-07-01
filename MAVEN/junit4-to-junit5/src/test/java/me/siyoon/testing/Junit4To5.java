package me.siyoon.testing;

import org.junit.*;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class Junit4To5 {
    @BeforeClass
    public static void beforeClass() {
        System.out.println("beforeClass");
    }

    @Before
    public void before() {
        System.out.println("before");
    }

    @Test
    public void shouldMigrateTestToSimpleTest() {
        Assert.assertEquals("expected", "expected");
    }

    @Test
    @Ignore
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

    @After
    public void after() {
        System.out.println("after");
    }

    @AfterClass
    public static void afterClass() {
        System.out.println("afterClass");
    }

    private int javaVersion() {
        return 8;
    }
}
