package org.springdemo.basicspringboot;

import org.springdemo.basicspringboot.model.Laptop;
import org.springdemo.basicspringboot.service.LaptopService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class LearnSpring1Application {
    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(LearnSpring1Application.class, args);
//        Alien obj = context.getBean(Alien.class);
//        obj.code();
//        System.out.println(obj.getAge());

        Laptop laptop = context.getBean(Laptop.class);
        LaptopService service = context.getBean(LaptopService.class);

        service.addLaptop(laptop);
    }
}
