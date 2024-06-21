package com.tufuteca.uploadImage.service;

import com.tufuteca.uploadImage.model.Role;
import com.tufuteca.uploadImage.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RoleService {
    @Autowired
    private RoleRepository roleRepository;

    public Role getRoleById(Long id){
        return roleRepository.getById(id);
    }
}
