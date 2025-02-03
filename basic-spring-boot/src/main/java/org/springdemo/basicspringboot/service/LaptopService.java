package org.springdemo.basicspringboot.service;

import org.springdemo.basicspringboot.LaptopRepository;
import org.springdemo.basicspringboot.model.Laptop;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LaptopService {
    private final LaptopRepository laptopRepo;

    @Autowired
    public LaptopService(LaptopRepository laptopRepo) {
        this.laptopRepo = laptopRepo;
    }

    public void addLaptop(Laptop laptop) {
        System.out.println("Laptop added");
        laptopRepo.save(laptop);
    }

    public boolean condOfLaptop(Laptop laptop) {
        return false;
    }
}
