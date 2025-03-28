package com.example.personal_blog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;




@Controller
public class PagesController {

    @GetMapping("/post")
    public String postsPage() {
        return "post";
    }

    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }
    
    
}
