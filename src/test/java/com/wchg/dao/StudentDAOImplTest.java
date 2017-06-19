package com.wchg.dao;

import com.wchg.domain.Student;
import org.junit.Test;

import java.util.List;

/**
 * Author 王朝刚
 * Date 2017/6/19 1:45
 */
public class StudentDAOImplTest {

    @Test
    public void testQuery() {
        StudentDAO studentDAO = new StudentDAOImpl();
        List<Student> students = studentDAO.query();

        for (Student student : students) {
            System.out.println("id:" + student.getId()
                    + ", name:" + student.getName()
                    + ", age:" + student.getAge());
        }
    }

    @Test
    public void testSave() {
        StudentDAO studentDAO = new StudentDAOImpl();
        Student student = new Student();
        student.setName("John");
        student.setAge(30);

        studentDAO.save(student);
    }
}
