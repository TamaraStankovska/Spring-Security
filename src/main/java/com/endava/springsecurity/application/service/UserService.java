package com.endava.springsecurity.application.service;

import com.endava.springsecurity.application.model.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

public interface UserService extends UserDetailsService {
    User findByUsername(String username);
    void save(User user);
}
