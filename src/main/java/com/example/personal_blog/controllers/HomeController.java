package com.example.personal_blog.controllers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.example.personal_blog.models.Post;
import com.example.personal_blog.repositories.PostRepository;

@Controller
public class HomeController {
    @Autowired
    private PostRepository postRepository;
    @GetMapping("/")
    public String homePage(Model model) {
        Iterable<Post> posts = postRepository.findAll();
        List<Post> myList = new ArrayList<>();
        posts.forEach(myList::add);
        int start = Math.max(0, myList.size() - 10); //Вычислите начальный индекс
        myList = myList.subList(start, myList.size()); //Получите подсписок
        Collections.reverse(myList);
       
        for(int i=0; i < myList.size();i++){
            System.out.println(myList.toString());
        }
        model.addAttribute("posts", myList);
        return "home";
    }
    
}
