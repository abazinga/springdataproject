package com.wchg.dao;

import com.wchg.JDBCUtil;
import com.wchg.domain.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * StudentDAO访问接口实现类：采用最原始的JDBC的方式操作
 * <p>
 * Author 王朝刚
 * Date 2017/6/19 1:36
 */
public class StudentDAOImpl implements StudentDAO {
    public List<Student> query() {
        List<Student> students = new ArrayList<Student>();

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            String sql = "select id, name, age from student";
            connection = JDBCUtil.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                int age = resultSet.getInt("age");

                Student student = new Student();
                student.setId(id);
                student.setName(name);
                student.setAge(age);

                students.add(student);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.release(resultSet, preparedStatement, connection);
        }

        return students;
    }

    public void save(Student student) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            String sql = "INSERT INTO student(name,age) VALUES (?,?)";
            connection = JDBCUtil.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, student.getName());
            preparedStatement.setInt(2, student.getAge());

            preparedStatement.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.release(resultSet, preparedStatement, connection);
        }
    }
}
