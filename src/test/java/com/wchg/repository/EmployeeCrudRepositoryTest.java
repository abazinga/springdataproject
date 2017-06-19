package com.wchg.repository;

import com.wchg.domain.Employee;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;

/**
 * Author 王朝刚
 * Date 2017/6/19 20:41
 */
public class EmployeeCrudRepositoryTest {

    private ApplicationContext ctx = null;
    private EmployeeCrudRepository employeeCrudRepository = null;

    @Before
    public void setup() {
        ctx = new ClassPathXmlApplicationContext("beans-new.xml");
        employeeCrudRepository = ctx.getBean(EmployeeCrudRepository.class);
        System.out.println("setup()");
    }

    @After
    public void tearDown() {
        ctx = null;
        System.out.println("tearDown()");
    }

    @Test
    public void testSave() {
        List<Employee> employees = new ArrayList<Employee>();

        Employee employee = null;
        for (int i = 0; i < 100; i++) {
            employee = new Employee();
            employee.setName("test" + i);
            employee.setAge(100 - i);
            employees.add(employee);
        }

        employeeCrudRepository.save(employees);
    }
}
