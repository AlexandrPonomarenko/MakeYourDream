package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
//@RequestMapping("/")
public class MainController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(Model model){
        model.addAttribute("in", "Hello index");
        return "index";
    }


    @RequestMapping(value = "/main" ,method = RequestMethod.GET)
    public String goMain(Model model){
        model.addAttribute("message", "Hello Spring5");
        System.out.println("main");
        return "main";
    }

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String home(Model model){
        model.addAttribute("message", "Hello home");
        System.out.println("home");
        return "home";
    }
}
