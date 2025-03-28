package com.example.personal_blog.controllers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.personal_blog.models.Post;
import com.example.personal_blog.models.User;
import com.example.personal_blog.repositories.PostRepository;

@Controller
public class ProfileController {

     @Autowired
    private PostRepository postRepository;

     @GetMapping("/profile")
    public String aboutPage( @AuthenticationPrincipal User user, Model model) {
        model.addAttribute("username", user.getUsername());
        model.addAttribute("about", user.getAbout());
        Iterable<Post> posts = postRepository.findByAuthor(user.getUsername());
        List<Post> myList = new ArrayList<>();
        posts.forEach(myList::add);
        Collections.reverse(myList);
        model.addAttribute("posts", myList);
        return "profile";
    }

    @PostMapping("/profile")
    public String blogPostAdd(@AuthenticationPrincipal User user, @RequestParam String title, @RequestParam String full_text, Model model) {
        Post post = new Post(user.getUsername(), title, full_text);
        postRepository.save(post);
        return "redirect:/profile";
    }

    @PostMapping("/profile/{id}/remove")
    public String removearticle(Model model, @PathVariable(value="id") Long id) {
        Post post = postRepository.findById(id).orElseThrow();
        postRepository.delete(post);
        return "redirect:/profile";
    }
    
}
