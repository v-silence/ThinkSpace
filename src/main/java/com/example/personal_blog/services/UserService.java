package com.example.personal_blog.services;


import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.personal_blog.repositories.UserRepository;

@Service
public class UserService implements UserDetailsService{
    //@Autowired
    private final UserRepository userRep;
    public UserService(UserRepository userRep){
        this.userRep=userRep;
    }
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRep.findByUsername(username);
    }
    
}
