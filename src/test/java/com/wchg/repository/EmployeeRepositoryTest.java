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
public class EmployeeRepositoryTest {

    private ApplicationContext ctx = null;
    private EmployeeRepository employeeRepository = null;

    @Before
    public void setup() {
        ctx = new ClassPathXmlApplicationContext("beans-new.xml");
        employeeRepository = ctx.getBean(EmployeeRepository.class);
        System.out.println("setup()");
    }

    @After
    public void tearDown() {
        ctx = null;
        System.out.println("tearDown()");
    }

    @Test
    public void testFindByName() {
        System.out.println(employeeRepository);
        Employee employee = employeeRepository.findByName("zhangsan");
        System.out.println(employee);
    }
}
