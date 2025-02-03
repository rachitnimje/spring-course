package org.springdemo.springbootmvc2;

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
        return "index";
    }

    @RequestMapping("/calculate")
    public ModelAndView calculate(@RequestParam("num1") int a, @RequestParam("num2") int b, ModelAndView modelAndView) {
//        Using session
//        int a = Integer.parseInt(req.getParameter("num1"));
//        int b = Integer.parseInt(req.getParameter("num2"));
//        int sum = a + b;
//        session.setAttribute("sum", sum);

//        int sum = a + b;
//        model.addAttribute("sum", sum);
//        return "result";

        int sum = a + b;
        modelAndView.addObject("sum", sum);
        modelAndView.setViewName("result");
        return modelAndView;
    }

    @RequestMapping("/addAlien")
    public String addAlien(Alien a) {
//        mv.addObject("alien", a);
//        mv.setViewName("result");

        return "result";
    }
}
