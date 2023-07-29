package com.spring.jdbc.dao;

import com.spring.jdbc.entity.Student;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.util.List;

public class StudentDaoImpl implements StudentDao{

    private JdbcTemplate jdbcTemplate;

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    //insert query
    @Override
    public int insert(Student student) {

        String query = "insert into student(id,name,city) values(?,?,?)";

        return this.jdbcTemplate.update(query, student.getId(), student.getName(), student.getCity());

    }
    // update data
    @Override
    public int change(Student student) {
        String update = "update student set name=?, city=? where id=?";
        return this.jdbcTemplate.update(update, student.getName(), student.getCity(), student.getId());
    }
    //delete data
    @Override
    public int delete(int studentId) {
        String delete = "delete from student where id=?";

        return this.jdbcTemplate.update(delete, studentId);
    }
    //get student => select query
    @Override
    public Student getStudent(int studentId) {
        String getQuery = "select * from student where id=?";
        RowMapper<Student> rowMapper = new RowMapperImpl();
        return this.jdbcTemplate.queryForObject(getQuery, rowMapper, studentId);
    }
    //select/get all data from DB
    @Override
    public List<Student> getAllStudent() {
        String query = "select * from student";
        return this.jdbcTemplate.query(query,new RowMapperImpl());
    }
}
