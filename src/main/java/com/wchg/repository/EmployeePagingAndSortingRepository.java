package com.wchg.repository;

import com.wchg.domain.Employee;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Author 王朝刚
 * Date 2017/6/19 21:29
 */
public interface EmployeePagingAndSortingRepository extends PagingAndSortingRepository<Employee, Integer> {



}
