package com.wchg.repository;

import com.wchg.domain.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Author 王朝刚
 * Date 2017/6/19 20:19
 */

public interface EmployeeJpaRepository extends JpaRepository<Employee, Integer> {

}
