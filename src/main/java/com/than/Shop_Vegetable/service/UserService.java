package com.than.Shop_Vegetable.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.than.Shop_Vegetable.model.Users;
import com.than.Shop_Vegetable.repository.UserRepository;

@Service
public class UserService implements UserDetailsService{
    
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        List<Users> users = userRepository.findByUsername(username);
        String password = null;
        List<GrantedAuthority> list = null;

        if(users.isEmpty()){
            throw new UsernameNotFoundException("UserDetails have not find username = " + username);
        }

        username = users.get(0).getUsername();
        password = users.get(0).getPassword();
        list = new ArrayList<>();
        list.add(new SimpleGrantedAuthority(users.get(0).getRoles()));

        return new User(username, password, list);
    }

    public void SaveUser(Users users){
        String newPassword = passwordEncoder.encode(users.getPassword());
        users.setPassword(newPassword);
        userRepository.save(users);
    }

    

}
