package org.springdemo.springjdbc.repository;

import org.springdemo.springjdbc.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentRepository {
    private JdbcTemplate jdbcTemp;

    public JdbcTemplate getJdbcTemp() {
        return jdbcTemp;
    }

    @Autowired
    public StudentRepository(JdbcTemplate jdbcTemp) {
        this.jdbcTemp = jdbcTemp;
    }

    public void save(Student student) {
        String sql = "insert into students (id, name, grade) values(?,?,?)";
        int rowsAffected = jdbcTemp.update(sql, student.getId(), student.getName(), student.getGrade());
        System.out.println("saved student: " + student);
        System.out.println("rows affected: " + rowsAffected);
    }

    public List<Student> findAll() {
        String sql = "select * from students";
        RowMapper<Student> rowMapper = new BeanPropertyRowMapper<>(Student.class);
        return jdbcTemp.query(sql, rowMapper);
    }
}
