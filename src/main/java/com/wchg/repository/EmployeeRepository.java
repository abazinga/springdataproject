package com.wchg.repository;

import com.wchg.domain.Employee;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.RepositoryDefinition;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Author 王朝刚
 * Date 2017/6/19 20:19
 */

// 能够通过注解达到不使用extends方法
@RepositoryDefinition(domainClass = Employee.class, idClass = Integer.class)
public interface EmployeeRepository {//extends Repository<Employee, Integer>{

    Employee findByName(String name);

    // where name like ?% and age < ?
    List<Employee> findByNameStartingWithAndAgeLessThan(String name, Integer age);

    // where name like %? and age < ?
    List<Employee> findByNameEndingWithAndAgeLessThan(String name, Integer age);

    // where name in (?,?,...) or age < ?
    List<Employee> findByNameInOrAgeLessThan(List<String> names, Integer age);

    // where name in (?,?,...) and age < ?
    List<Employee> findByNameInAndAgeLessThan(List<String> names, Integer age);

    /**
     * 弊端：
     * 1. 方法名比较长：约定大于配置
     * 2. 对于一些复杂的查询，是很难实现
     *
     * 解决方式：@Query注解
     */

    @Query("select o from Employee o where id = (select max(id) from Employee t1)")
    Employee getEmployeeByMaxId();

    @Query("select o from  Employee o where o.name = ?1 and o.age = ?2")
    List<Employee> queryParam1(String name, Integer age);


    @Query("select o from  Employee o where o.name = :name and o.age = :age")
    List<Employee> queryParam2(@Param("name") String name, @Param("age") Integer age);

    @Query("select o from Employee o where o.name like %?1%")
    List<Employee> queryLike1(String name);

    @Query("select o from Employee o where o.name like %:name%")
    List<Employee> queryLike2(@Param("name") String name);

    @Query(nativeQuery = true, value = "select count(1) from Employee")
    Long count();


    @Modifying
    @Query("update Employee o set o.age = :age where o.id = :id")
    void update(@Param("id") Integer id, @Param("age") Integer age);


}
