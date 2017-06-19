package com.wchg.dao;

import com.wchg.domain.Student;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * Author 王朝刚
 * Date 2017/6/19 2:27
 */
public class SpringJDBCTest {

    private ApplicationContext ctx = null;
    private StudentDAO studentDAO = null;

    @Before
    public void setup() {
        ctx = new ClassPathXmlApplicationContext("beans.xml");
        studentDAO = (StudentDAO) ctx.getBean("studentDAO");
    }

    @Test
    public void testQuery() {
        List<Student> students = studentDAO.query();

        for (Student student : students) {
            System.out.println("id:" + student.getId()
                    + ", name:" + student.getName()
                    + ", age:" + student.getAge());
        }
    }

    @Test
    public void testSave() {
        Student student = new Student();
        student.setName("Michale");
        student.setAge(30);

        studentDAO.save(student);
    }
}
