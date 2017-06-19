package com.wchg.repository;

import com.wchg.domain.Employee;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.*;

/**
 * Author 王朝刚
 * Date 2017/6/19 20:41
 */
public class EmployeeJpaSpecificationRepositoryTest {

    private ApplicationContext ctx = null;
    private EmployeeJpaSpecificationRepository employeeJpaSpecificationRepository = null;

    @Before
    public void setup() {
        ctx = new ClassPathXmlApplicationContext("beans-new.xml");
        employeeJpaSpecificationRepository = ctx.getBean(EmployeeJpaSpecificationRepository.class);
        System.out.println("setup()");
    }

    @After
    public void tearDown() {
        ctx = null;
        System.out.println("tearDown()");
    }

    /**
     * 1. 分页
     * 2. 排序
     * 3. 查询条件
     */
    @Test
    public void testQuery() {
        Sort.Order order = new Sort.Order(Sort.Direction.DESC, "id");
        Sort sort = new Sort(order);

        // page: index是从0开始
        Pageable pageable = new PageRequest(0,10,sort);

        Specification specification = new Specification() {
            public Predicate toPredicate(Root root, CriteriaQuery query, CriteriaBuilder cb) {
                // root --> Employee --> age
                Path path = root.get("age");
                return cb.gt(path,50);
            }
        };

        Page<Employee> page = employeeJpaSpecificationRepository.findAll(specification, pageable);

        System.out.println("查询的总页数：" + page.getTotalPages());
        System.out.println("查询的总记录数：" + page.getTotalElements());
        System.out.println("查询的当前页：" + (page.getNumber() + 1));
        System.out.println("查询的当前页内容：" + page.getContent());
        System.out.println("查询的当前页面的记录数：" + page.getNumberOfElements());


    }



}
