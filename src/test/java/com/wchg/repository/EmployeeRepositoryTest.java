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

    @Test
    public void testFindByNameStartingWithAndAgeLessThan() {
        List<Employee> employees = employeeRepository.findByNameStartingWithAndAgeLessThan("test",22);
        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }

    @Test
    public void testFindByNameEndingWithAndAgeLessThan() {
        List<Employee> employees = employeeRepository.findByNameEndingWithAndAgeLessThan("6",23);
        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }

    @Test
    public void testFindByNameInOrAgeLessThan() {
        List<String> names = new ArrayList<String>();
        names.add("test1");
        names.add("test2");
        names.add("test3");

        List<Employee> employees = employeeRepository.findByNameInOrAgeLessThan(names,22);
        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }

    @Test
    public void testFindByNameInAndAgeLessThan() {
        List<String> names = new ArrayList<String>();
        names.add("test1");
        names.add("test2");
        names.add("test3");

        List<Employee> employees = employeeRepository.findByNameInAndAgeLessThan(names,22);
        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }

    @Test
    public void testGetEmployeeByMaxId() {
        Employee employee = employeeRepository.getEmployeeByMaxId();
        System.out.println(employee);
    }

    @Test
    public void testQueryParam1() {
        List<Employee> employees = employeeRepository.queryParam1("test1",20);
        System.out.println(employees);
    }

    @Test
    public void testQueryParam2() {
        List<Employee> employees = employeeRepository.queryParam2("test1",20);
        System.out.println(employees);
    }

    @Test
    public void testQueryLike1() {
        List<Employee> employees = employeeRepository.queryLike1("test");
        System.out.println(employees);
    }

    @Test
    public void testQueryLike2() {
        List<Employee> employees = employeeRepository.queryLike2("test1");
        System.out.println(employees);
    }

    @Test
    public void testCount() {
        Long count = employeeRepository.count();
        System.out.println("count:" + count);
    }

    @Test
    public void testUpdate() {
        employeeRepository.update(1, 30);

    }
}
