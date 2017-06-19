package com.wchg.repository;

import com.wchg.domain.Employee;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Author 王朝刚
 * Date 2017/6/19 20:41
 */
public class EmployeeJpaRepositoryTest {

    private ApplicationContext ctx = null;
    private EmployeeJpaRepository employeeJpaRepository = null;

    @Before
    public void setup() {
        ctx = new ClassPathXmlApplicationContext("beans-new.xml");
        employeeJpaRepository = ctx.getBean(EmployeeJpaRepository.class);
        System.out.println("setup()");
    }

    @After
    public void tearDown() {
        ctx = null;
        System.out.println("tearDown()");
    }

    @Test
    public void testFind() {
        Employee employee = employeeJpaRepository.findOne(88);
        System.out.println(employee);

        System.out.println("employee(10):" + employeeJpaRepository.exists(10));
        System.out.println("employee(102):" + employeeJpaRepository.exists(102));
    }



}
