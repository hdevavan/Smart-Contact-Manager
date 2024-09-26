package com.smart.controllers;

import com.smart.dao.UserRepository;
import com.smart.entities.Contact;
import com.smart.entities.User;
import com.smart.helper.Message;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
        model.addAttribute("user", new User());
        return "signup";
    }

    @RequestMapping("/login/")
    public String login(Model model) {
        model.addAttribute("title","Login");
        return "login";
    }

    @RequestMapping(value = "/do_register", method = RequestMethod.POST)
    public String doRegister(@ModelAttribute("user") User user, @RequestParam(value="agreement", defaultValue = "false") boolean agreement, Model model, HttpSession session) {
        try {
            if(!agreement){
                System.out.println("You have entered the wrong data");
                model.addAttribute("user", user);
                throw new Exception("User haven't checked the terms and conditions ");
            }
            user.setImage("profile.jpg");
            user.setRole("ROLE_USER");
            user.setEnabled(true);
            userRepo.save(user);
            session.setAttribute("message", new Message("User added successfully.", "alert-success"));
        } catch (Exception e){
            session.setAttribute("message", new Message(e.getMessage(),"alert-danger"));
            return "signup";
        }
        return "signup";

    }
}
