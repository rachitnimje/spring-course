package org.halogen;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main {
    public static void main(String[] args) {
        Student student = new Student();

        student.setRollNo(16);
        student.setName("Rajesh");
        student.setAge(21);

        Configuration conf = new Configuration()
                .addAnnotatedClass(Student.class)
                .configure();

        SessionFactory sf = conf.buildSessionFactory();
        Session session = sf.openSession();

        session.beginTransaction();
//        session.persist(student);
        session.merge(student);
        session.getTransaction().commit();

        student = session.get(Student.class, 12);
        System.out.println(student);

        session.close();
        sf.close();
    }
}