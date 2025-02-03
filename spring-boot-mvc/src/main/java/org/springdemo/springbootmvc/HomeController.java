package org.springdemo.springbootmvc;

import model.Alien;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

// for showing the page on the localhost, we need to install tomcat jasper dependency from maven repo

@Controller
public class HomeController {
    @ModelAttribute
    public void modelAttributes(Model model) {
        model.addAttribute("name", "Rachit");
    }

    @RequestMapping("/")
    public String home() {
        return "index";
    }

//    @RequestMapping("/result")
//    public ModelAndView result(@RequestParam("num1") int a, @RequestParam("num2") int b) {
////        int a = Integer.parseInt(req.getParameter("num1"));
////        int b = Integer.parseInt(req.getParameter("num2"));
//
//        ModelAndView mv = new ModelAndView("result");
////        mv.setViewName("result");
//        int c = a + b;
//
////        HttpSession session = req.getSession();
////        session.setAttribute("num3", c);
//
//        mv.addObject("num3", c);
////        return "result.jsp";
//        return mv;
//    }

    @RequestMapping("/result")
    public String result(@RequestParam("num1") int a, @RequestParam("num2") int b, Model model) {
        int c = a + b;
        model.addAttribute("num3", c);

        return "result";
    }

    @RequestMapping("/addAlien")
    public String addAlien(@ModelAttribute Alien alien) {
//        Alien alien = new Alien();
//        alien.setAid(aid);
//        alien.setAname(aname);

//        model.addAttribute("alien", alien);

        return "result";
    }
}
