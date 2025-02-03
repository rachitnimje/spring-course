package org.springdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Lazy
@Primary
public class Desktop implements  Computer{
    int RAM;

    public Desktop() {
        System.out.println("Desktop obj created");
    }

    public void compile() {
        System.out.println("Compiling in desktop...");
    }
}
