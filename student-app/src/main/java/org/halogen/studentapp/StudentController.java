package org.halogen.studentapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StudentController {

    @Autowired
    private StudentRepo studentRepo;

    @GetMapping("/students")
    public List<Student> getStudents(){
        return studentRepo.findAll();
    }

    @GetMapping("/addStudent")
    public String addStudent(){
        Student s = new Student();
        s.setName("dhruvesh");
        s.setAge(21);

        studentRepo.save(s);
        return "Student added";
    }
}
