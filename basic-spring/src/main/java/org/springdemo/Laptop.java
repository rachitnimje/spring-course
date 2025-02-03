package org.springdemo;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Lazy
public class Laptop implements Computer{
    public Laptop() {
        System.out.println("Laptop object created");
    }

    public void compile() {
        System.out.println("Compiling in laptop...");
    }
}
