package org.halogen.springdatajpa;

import org.halogen.springdatajpa.model.Student;
import org.halogen.springdatajpa.repo.StudentRepo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@SpringBootApplication
public class SpringDataJpaApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(SpringDataJpaApplication.class, args);
        StudentRepo repo = context.getBean(StudentRepo.class);

        Student s1 = context.getBean(Student.class);
        Student s2 = context.getBean(Student.class);
        Student s3 = context.getBean(Student.class);

        s1.setRollNo(1);
        s2.setRollNo(2);
        s3.setRollNo(3);

        s1.setName("Rachit");
        s2.setName("Chicken");
        s3.setName("Mutton");

        s1.setGrade(3);
        s2.setGrade(2);
        s3.setGrade(5);

        repo.save(s1);
        repo.save(s2);
        repo.save(s3);

//        List<Student> studInfo = repo.findAll();
//        System.out.println(studInfo);
//
//        System.out.println(repo.findById(1));
//
//        repo.delete(s1);
//        System.out.println(repo.findAll());
//
//        Optional<Student> temp = repo.findById(44);
//        System.out.println(temp);
//        System.out.println(temp.orElse(null));

//        System.out.println(repo.findByName("Rachit"));
//        System.out.println(repo.findByGrade(2));
//        System.out.println(repo.findByGradeGreaterThan(2));


    }

}
