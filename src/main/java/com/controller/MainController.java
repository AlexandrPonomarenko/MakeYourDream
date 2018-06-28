package com.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MainController {
    private static final Logger logger = LogManager.getLogger(MainController.class);

//    @RequestMapping(value = "/", method = RequestMethod.GET)
//    public String index(Model model){
//        model.addAttribute("in", "Hello index");
//        logger.debug("index()");
//        return "redirect:/main";
//    }


    @RequestMapping(value = {"/", "/main"}, method = RequestMethod.GET)
    public String goMain(Model model){
        model.addAttribute("message", "Hello Spring5");
        System.out.println("main");
        logger.debug("main");
        return "main";
    }
}
