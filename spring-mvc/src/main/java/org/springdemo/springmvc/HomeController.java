package org.springdemo.springmvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
    @ModelAttribute("course")
    public String course() {
        return "javafff";
    }

    @RequestMapping("/")
    public String home() {
        System.out.println("home method called");
        return "index";
    }

    @RequestMapping("/calculate")
    public ModelAndView calculate(@RequestParam("num1") int a, @RequestParam("num2") int b, ModelAndView modelAndView) {
        int sum = a + b;
        modelAndView.addObject("sum", sum);
        modelAndView.setViewName("result");
        return modelAndView;
    }

    @RequestMapping("/addAlien")
    public String addAlien(Alien a) {
        return "result";
    }
}
