package com.example.personal_blog.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.personal_blog.models.Post;


public interface PostRepository extends CrudRepository<Post, Long>{
    List<Post> findByAuthor(String author);
}
