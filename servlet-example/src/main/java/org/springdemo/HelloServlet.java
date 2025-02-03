package org.springdemo;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/hello")
public class HelloServlet extends HttpServlet {
    public void service(HttpServletRequest req, HttpServletResponse res) throws IOException {
        System.out.println("Service called");
//        res.getWriter().println("/hello servlet called");

//        PrintWriter out = res.getWriter();
//        out.println("/hello service called");

        res.setContentType("text/html");
        PrintWriter out = res.getWriter();
        out.println("<h1> /hello service called </h1>");
    }
}
