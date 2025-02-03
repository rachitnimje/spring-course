package org.springdemo;

import org.springdemo.config.AppConfig;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.FileSystemResource;

public class App 
{
    public static void main(String[] args ) {
        //
//        ApplicationContext factory = new ClassPathXmlApplicationContext("spring.xml");
//        Alien obj = (Alien)factory.getBean("alien");
//        obj.code();
//        obj.age = 20;
//        System.out.println("Object 1 age: " + obj.age);
//
//        Alien obj2 = (Alien)factory.getBean("alien");
//        System.out.println("Object 2 age: " + obj2.age);

        // output:
        // Object 2 age: 20
        // Object 1 age: 20
        // This is because both are pointing to the same object that is created by spring
        // This is because of the singleton property of spring
        // When the scope of the class is defined to "prototype" in the spring.xm file, we can create multiple object of the same class
        // Output:
        // Object created
        //I'm coding..
        //Object 1 age: 20
        //Object created
        //Object 2 age: 0

//        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
//        Alien obj = (Alien)context.getBean("alien");
//        obj.code();
//        System.out.println(obj.getAge());
//
////        Desktop obj2 = (Desktop) context.getBean("com");
//        Desktop obj2 = context.getBean("com", Desktop.class);

        // java based config
//        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
//        Desktop desk = context.getBean("chicken", Desktop.class);
//        desk.compile();
//        desk.RAM = 4;
//        System.out.println(desk.RAM);
//
//        Desktop desk2 = context.getBean("chicken", Desktop.class);
//        System.out.println(desk2.RAM);

        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        Alien alien = (Alien) context.getBean("alien");
        System.out.println(alien.getAge());
        alien.code();
    }

}
