package com.tufuteca.uploadImage.config;


import com.tufuteca.uploadImage.model.Users;
import com.tufuteca.uploadImage.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private UsersRepository usersRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Optional<Users> user = usersRepository.findByLogin(username);

        return user.map(MyUserDetails::new)
                .orElseThrow(() -> new UsernameNotFoundException(username + "User not found"));
        }


}

