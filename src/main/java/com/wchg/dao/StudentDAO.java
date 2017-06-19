package com.wchg.dao;

import com.wchg.domain.Student;

import java.util.List;

/**
 * StudentDAO访问接口
 * <p>
 * Author 王朝刚
 * Date 2017/6/19 1:34
 */
public interface StudentDAO {

    /**
     * 查询所有学生
     *
     * @return 所有学生
     */
    public List<Student> query();

    /**
     * @param student
     */
    public void save(Student student);
}
