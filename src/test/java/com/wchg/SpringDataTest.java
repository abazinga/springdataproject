package com.wchg;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Author 王朝刚
 * Date 2017/6/19 19:46
 */
public class SpringDataTest {

    private ApplicationContext ctx = null;

    @Before
    public void setup() {
        System.out.println("setup()");
        ctx = new ClassPathXmlApplicationContext("beans-new.xml");

    }

    @After
    public void tearDown() {
        ctx = null;
        System.out.println("tearDown()");
    }

    @Test
    public void test() {

    }

}
