package org.springdemo.basicspringboot.model;

import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
@Lazy
public class Laptop implements Computer{
    public void compile() {
        System.out.println("Compiling in laptop...");
    }
}
