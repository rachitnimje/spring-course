package org.springdemo.springjdbc.service;

import org.springdemo.springjdbc.model.Student;
import org.springdemo.springjdbc.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {
    private StudentRepository studRepo;

    public StudentRepository getStudRepo() {
        return studRepo;
    }

    @Autowired
    public void setStudRepo(StudentRepository studRepo) {
        this.studRepo = studRepo;
    }

    public void addStudent(Student student) {
        studRepo.save(student);
    }

    public List<Student> findAll() {
        return studRepo.findAll();
    }
}
