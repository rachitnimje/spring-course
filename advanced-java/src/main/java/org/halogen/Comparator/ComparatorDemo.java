package org.halogen.Comparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

//class Student implements Comparable<Student> {
class Student {
    int age;
    String name;

    public Student(int age, String name) {
        this.age = age;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }

//    @Override
//    public int compareTo(Student student) {
//        if(this.age > student.age)
//            return 1;
//        else
//            return -1;
//    }
}

public class ComparatorDemo {
    public static void main(String[] args) {
        ArrayList<Student> students = new ArrayList<Student>();

        students.add(new Student(22, "Tonya"));
        students.add(new Student(20, "Rachit"));
        students.add(new Student(21, "Dhruvesh"));

        Comparator<Student> comp = (s1, s2) -> s1.age >= s2.age ? 1 : -1;;

        Collections.sort(students, comp);

        System.out.println(students);
    }
}
