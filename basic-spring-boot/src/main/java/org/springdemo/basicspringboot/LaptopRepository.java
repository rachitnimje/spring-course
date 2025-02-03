package org.springdemo.basicspringboot;

import org.springdemo.basicspringboot.model.Laptop;
import org.springframework.stereotype.Repository;

@Repository
public class LaptopRepository {
    public void save(Laptop laptop) {
        System.out.println("Laptop saved");
    }
}
