package com.example.personal_blog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.personal_blog.models.User;



public interface UserRepository extends JpaRepository<User, Long>{
    User findByUsername(String username);

}
