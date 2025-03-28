package com.example.personal_blog.controllers;

import java.util.Collections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.example.personal_blog.models.User;
import com.example.personal_blog.repositories.UserRepository;
import com.example.personal_blog.models.Role;
import org.springframework.web.bind.annotation.PostMapping;



@Controller
public class RegistrationController {

    @Autowired
    private UserRepository userRep;
    @GetMapping("/registration")
    public String registration(Model model) {
        return "registration";
    }

    @PostMapping("/registration")
    public String add_user(User user,Model model) {
        User userFromDb = userRep.findByUsername(user.getUsername());
        if(userFromDb!=null){
            model.addAttribute("message", "User exists");
            return "registration";
        }
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String rawPassword = user.getPassword(); //Получите обычный пароль из объекта пользователя
        String encodedPassword = passwordEncoder.encode(rawPassword); //Закодируйте пароль
        user.setPassword(encodedPassword); //Установите закодированный пароль в объекте пользователя    
        user.setRoles(Collections.singleton(Role.USER));
        userRep.save(user);
        model.addAttribute("message", "Registration succesed");
        return "redirect:/login";
    }
    
    
}

