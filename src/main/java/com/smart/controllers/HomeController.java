package com.smart.controllers;

import com.smart.dao.UserRepository;
import com.smart.entities.Contact;
import com.smart.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@Controller
public class HomeController {

    @Autowired
    private UserRepository userRepo;

    @RequestMapping("/")
    public String home(Model model) {
        model.addAttribute("title","Home");
        return "home";
    }

    @RequestMapping("/about/")
    public String about(Model model) {
        model.addAttribute("title","About - Smart Contact Manager");
        return "about";
    }

    @RequestMapping("/sign-up/")
    public String signUp(Model model) {
        model.addAttribute("title","Sign-Up");
        return "signup";
    }

    @RequestMapping("/login/")
    public String login(Model model) {
        model.addAttribute("title","Login");
        return "login";
    }

    @RequestMapping(value = "/do_register", method = RequestMethod.POST)
    public String doRegister(Model model) {
        model.addAttribute("title","Login");
        return "login";
    }
}
