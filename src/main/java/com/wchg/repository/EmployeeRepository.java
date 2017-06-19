package com.wchg.repository;

import com.wchg.domain.Employee;
import org.springframework.data.repository.RepositoryDefinition;

/**
 * Author 王朝刚
 * Date 2017/6/19 20:19
 */

// 能够通过注解达到不使用extends方法
@RepositoryDefinition(domainClass = Employee.class, idClass = Integer.class)
public interface EmployeeRepository {//extends Repository<Employee, Integer>{

    public Employee findByName(String name);
}
