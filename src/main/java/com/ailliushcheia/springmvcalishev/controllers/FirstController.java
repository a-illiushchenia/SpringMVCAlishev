package com.ailliushcheia.springmvcalishev.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/first")
public class FirstController {

    @GetMapping("/hello")
    public String helloPage1(
            @RequestParam(value = "name", required = false) String name,
            @RequestParam(value = "surname", required = false) String surname,
            Model model){

        model.addAttribute("message", "Hello, " + name + " " + surname);


        return "first/hello";
    }


    @GetMapping("/goodbye")
    public String goodByePage(){
        return "first/goodbye";
    }

    @GetMapping("first/calculator")
    public String calculator(@RequestParam(value = "a", required = false) String a,
                             @RequestParam(value = "b", required = false) String b,
                             @RequestParam(value = "action", required = false) String action,
                             Model model){

        String message = "";
        double actionResult;

        if(a == null || b == null || action == null){
            message = "Bad request parameters";
        }else {
            int aInt = 0,bInt = 0;
            try{
                aInt = Integer.parseInt(a);
                bInt = Integer.parseInt(b);
            } catch (NumberFormatException e){
                message = "Bad 'a' or 'b' parameters";
            }

            if(message.equals("")){
                switch (action){
                    case "multiplication":
                        message = aInt + " * " + bInt + " = " + (aInt * bInt);
                        break;
                    case "addition":
                        message = aInt + " + " + bInt + " = " + (aInt + bInt);
                        break;
                    case "subtraction":
                        message = aInt + " - " + bInt + " = " + (aInt - bInt);
                        break;
                    case "division":
                        message = aInt + " / " + bInt + " = " + (aInt / bInt);
                        break;
                    default: message = "Bad 'action' parameters";
                }
            }
        }

        model.addAttribute("message", message);

        return "first/calculator";
    }
}
