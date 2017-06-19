package com.wchg.repository;

import com.wchg.domain.Employee;
import org.springframework.data.repository.CrudRepository;

/**
 * Author 王朝刚
 * Date 2017/6/19 21:22
 */
public interface EmployeeCrudRepository extends CrudRepository<Employee, Integer> {

}
