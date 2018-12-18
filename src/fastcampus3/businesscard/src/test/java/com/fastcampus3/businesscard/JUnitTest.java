package com.fastcampus3.businesscard;

import org.junit.Before;
import org.junit.Test;

import java.util.Random;

public class JUnitTest {
    private Random random;
    @Before
    public void init() {
        random = new Random(); //객체 초기화
        System.out.println("init");
    }
    @Test
    public void test1() throws Exception {
        System.out.println(random.nextInt());
        System.out.println("Test1");
    }

    @Test
    public void test2() throws Exception {
        System.out.println("Test2");
    }
}
