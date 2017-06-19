package com.wchg;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.util.Assert;

import javax.sql.DataSource;

/**
 * Author 王朝刚
 * Date 2017/6/19 2:08
 */
public class DataSourceTest {

    private ApplicationContext ctx = null;

    @Before
    public void setup() {
        ctx = new ClassPathXmlApplicationContext("beans.xml");
        System.out.println("setup()");
    }

    @After
    public void tearDown() {
        System.out.println("tearDown()");
        ctx = null;
    }

    @Test
    public void testDataSource() {
        DataSource dataSource = (DataSource) ctx.getBean("dataSource");
        Assert.notNull(dataSource);
    }

    @Test
    public void testJdbcTemplate() {
        JdbcTemplate jdbcTemplate = (JdbcTemplate) ctx.getBean("jdbcTemplate");
        Assert.notNull(jdbcTemplate);
    }


}
