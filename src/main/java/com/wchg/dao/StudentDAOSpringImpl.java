package com.wchg.dao;

import com.wchg.domain.Student;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Author 王朝刚
 * Date 2017/6/19 2:16
 */
public class StudentDAOSpringImpl implements StudentDAO {

    private JdbcTemplate jdbcTemplate;

    public List<Student> query() {
        final List<Student> students = new ArrayList<Student>();
        String sql = "select id, name, age from student";

        jdbcTemplate.query(sql, new RowCallbackHandler() {
            public void processRow(ResultSet resultSet) throws SQLException {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                int age = resultSet.getInt("age");

                Student student = new Student();
                student.setId(id);
                student.setName(name);
                student.setAge(age);

                students.add(student);
            }
        });
        return students;
    }

    public void save(Student student) {
        String sql = "INSERT INTO student(name, age) VALUES(?,?)";
        jdbcTemplate.update(sql, student.getName(), student.getAge());
    }


    // setter and getter

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
}
