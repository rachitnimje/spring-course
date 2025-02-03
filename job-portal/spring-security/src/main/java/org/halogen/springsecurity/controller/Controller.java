package org.halogen.springsecurity.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @GetMapping("/hello")
    public String hello(HttpServletRequest request) {
        return "hello " + request.getSession().getId();
    }

    @GetMapping("/about")
    public String about(HttpServletRequest request) {
        return "by rachit " + request.getSession().getId();
    }
}
