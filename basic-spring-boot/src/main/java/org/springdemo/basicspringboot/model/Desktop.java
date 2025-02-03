package org.springdemo.basicspringboot.model;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Lazy
public class Desktop implements Computer{
    public void compile() {
        System.out.println("Compiling in desktop...");
    }
}
