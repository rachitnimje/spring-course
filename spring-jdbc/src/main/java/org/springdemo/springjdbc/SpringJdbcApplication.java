package org.springdemo.springjdbc;

import org.springdemo.springjdbc.model.Student;
import org.springdemo.springjdbc.service.StudentService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.List;

@SpringBootApplication
public class SpringJdbcApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(SpringJdbcApplication.class, args);

        Student student = context.getBean(Student.class);
        student.setName("rachit");
        student.setId(5);
        student.setGrade(4);

        StudentService service = context.getBean(StudentService.class);
        service.addStudent(student);
//
        List<Student> students = service.findAll();
        System.out.println(students);

    }
}
