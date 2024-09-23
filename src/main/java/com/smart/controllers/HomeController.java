package com.smart.controllers;

import com.smart.dao.UserRepository;
import com.smart.entities.Contact;
import com.smart.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class HomeController {

    @Autowired
    private UserRepository userRepo;

    @RequestMapping("/home")
    @ResponseBody
    public User home() {
        User user = new User();
        user.setId(1);
        user.setName("Harsh Devavanshi");
        user.setEmail("harsh@example.com");
        user.setPassword("password123");
        user.setImage("profile.jpg");
        user.setAbout("Full Stack Developer from New Delhi");
        user.setRole("ROLE_USER");
        user.setEnabled(true);
        Contact c = new Contact();
        user.getContacts().add(c);

        return userRepo.save(user);
    }
}
