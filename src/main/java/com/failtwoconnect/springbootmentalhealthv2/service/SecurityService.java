package com.failtwoconnect.springbootmentalhealthv2.service;

import com.failtwoconnect.springbootmentalhealthv2.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SecurityService {

    private UserService userService;
    @Autowired
    public SecurityService(UserService userService) {
        this.userService = userService;
    }

}
