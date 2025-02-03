package org.halogen.springdatajpa.repo;

import org.halogen.springdatajpa.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepo extends JpaRepository<Student, Integer> {
    List<Student> findByName(String name);
    List<Student> findByGrade(int grade);
    List<Student> findByNameAndGrade(String name, int grade);

    List<Student> findByGradeGreaterThan(int grade);
}
