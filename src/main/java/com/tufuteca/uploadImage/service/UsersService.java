package com.tufuteca.uploadImage.service;

import com.tufuteca.uploadImage.model.Users;
import com.tufuteca.uploadImage.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsersService {

    @Autowired
    private UsersRepository usersRepository;


    public void addUser(Users newUser) {
        usersRepository.save(newUser);
    }
}
