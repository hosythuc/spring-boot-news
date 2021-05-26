package com.hosythuc.blogv2.service;

import com.hosythuc.blogv2.model.entity.UserEntity;
import com.hosythuc.blogv2.model.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class UserDetailServiceImpl implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        UserEntity user = userRepository.findByUserName(s);

        if (user == null) {
            throw new UsernameNotFoundException("user not found");
        }


        return null;
    }
}
