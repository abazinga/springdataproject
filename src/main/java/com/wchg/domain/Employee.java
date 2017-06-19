package com.wchg.domain;

import javax.persistence.*;

/**
 * Author 王朝刚
 * Date 2017/6/19 19:48
 */

@Entity
@Table(name = "test_employee")
public class Employee {

    @Id
    @GeneratedValue
    private Integer id;

    @Column(length = 20)
    private String name;

    private Integer age;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
