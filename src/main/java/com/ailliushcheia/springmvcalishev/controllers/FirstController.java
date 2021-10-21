package com.ailliushcheia.springmvcalishev.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/first")
public class FirstController {

    @GetMapping("/hello")
    public String helloPage(HttpServletRequest request){
        String name = request.getParameter("name");
        String surname = request.getParameter("surname");

        System.out.println("Hello, " + name + " " + surname);

        return "first/hello";
    }

    @GetMapping("/hello1")
    public String helloPage1(
            @RequestParam(value = "name", required = false) String name,
            @RequestParam("surname") String surname){

        System.out.println("Hello, " + name + " " + surname);

        return "first/hello";
    }


    @GetMapping("/goodbye")
    public String goodByePage(){
        return "first/goodbye";
    }
}
