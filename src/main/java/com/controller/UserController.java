package com.controller;

import com.model.User;
import com.service.security.SecurityService;
import com.service.UserService;
import com.validator.UserValidator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UserController {

    private static final Logger logger = LogManager.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @Autowired
    private SecurityService securityService;

    @Autowired
    private UserValidator userValidator;

//    @RequestMapping(value = "/registration" ,method = RequestMethod.GET)
//    public ModelAndView registration(){
//        ModelAndView modelAndView = new ModelAndView();
//        User user = new User();
//        modelAndView.addObject("user", user);
//        System.out.println("registration");
//        modelAndView.setViewName("registration");
//        return modelAndView;
//    }

    @RequestMapping(value = "/registration" ,method = RequestMethod.GET)
    public String registration(Model model){
        model.addAttribute("userForm", new User());
        System.out.println("regstration");
        return "registration";
    }

    @RequestMapping(value = "/registration" ,method = RequestMethod.POST)
    public String createNewUser(@ModelAttribute("userForm") User userForm, BindingResult bindingResult, Model model){
        logger.debug("BEFORE VALIDATOR" + userForm.getLogin(), userForm.getName(), userForm.getPassword(), userForm.getPasswordTwo());

        userValidator.validate(userForm, bindingResult);

        logger.debug("BEFORE IF" + userForm.getLogin(), userForm.getName(), userForm.getPassword(), userForm.getPasswordTwo());
        if(bindingResult.hasErrors()){
            return "registration";
        }

        logger.debug("AFTER IF"  + userForm.getLogin() + " - " + userForm.getName() +
                " - " + userForm.getPassword()+ " - " +  userForm.getPasswordTwo() + " - " + userForm.getEmail());
        userService.saveUser(userForm);

        securityService.autoLogin(userForm.getLogin(), userForm.getPasswordTwo());

//        System.out.println("registration"+ userForm.getLogin() + " - " + userForm.getName() +
//                " - " + userForm.getPassword()+ " - " +  userForm.getPasswordTwo() + " - " + userForm.getEmail());
        return "redirect:/authorization?success";
    }

    @RequestMapping(value = "/authorization" ,method = RequestMethod.GET)
    public String authorization(Model model, String error, String logout){
        if (error != null){
            model.addAttribute("error", "Your username and password is invalid.");
        }

        if (logout != null)
            model.addAttribute("message", "You have been logged out successfully.");
        logger.debug("authorization GET");
        return "authorization";
    }

//    @RequestMapping(value = "/authorization" ,method = RequestMethod.POST)
//    public String authorization(Model model, String error, String logout){
//        if (error != null){
//            model.addAttribute("error", "Your username and password is invalid.");
//        }
//
//        if (logout != null)
//            model.addAttribute("message", "You have been logged out successfully.");
//        logger.debug("authorization POST");
//        return "authorization";
//    }

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String home(Model model){
        model.addAttribute("message", "Hello home");
        System.out.println("home");
        return "home";
    }

}
