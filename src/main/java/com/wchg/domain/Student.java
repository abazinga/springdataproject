package com.wchg.domain;

/**
 * Author 王朝刚
 * Date 2017/6/19 1:30
 */
public class Student {

    /**
     * 主键
     */
    private int id;

    /**
     * 年龄
     */
    private int age;

    /**
     * 姓名
     */
    private String name;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}
