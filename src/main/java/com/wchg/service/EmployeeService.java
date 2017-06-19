package com.wchg.service;

import com.wchg.domain.Employee;
import com.wchg.repository.EmployeeCrudRepository;
import com.wchg.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Author 王朝刚
 * Date 2017/6/19 22:33
 */

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private EmployeeCrudRepository employeeCrudRepository;


    @Transactional
    public void update(Integer id, Integer age) {
        employeeRepository.update(id,age);
    }

    @Transactional
    public void save(List<Employee> employees) {
        employeeCrudRepository.save(employees);
    }
}
