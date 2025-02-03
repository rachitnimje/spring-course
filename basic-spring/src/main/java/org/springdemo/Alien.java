package org.springdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Alien {
    @Value("21")
    private int age;
    // you can assign the default values to the variables using the property tag in spring.xml file
    // or you can put it in the constructor or initialize the variable with the value
//    @Autowired
//    @Qualifier("desktop")
    private Computer com;

    public Alien() {
        System.out.println("Alien object created");
    }

    public Alien(int age) {
        this.age = age;
    }

//     constructor injection
    @Autowired
    public Alien(Computer com) {
        this.com = com;
    }

    public Computer getCom() {
        return com;
    }

    // setter injection
//    @Autowired
    public void setCom(Computer com) {
        this.com = com;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
//        System.out.println("Age assigned");
        this.age = age;
    }

    public void code() {
        System.out.println("I'm coding..");
        com.compile();
    }
}
