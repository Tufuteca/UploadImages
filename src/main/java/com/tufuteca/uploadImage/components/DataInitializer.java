package com.tufuteca.uploadImage.components;

import com.tufuteca.uploadImage.model.Role;
import com.tufuteca.uploadImage.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class DataInitializer implements CommandLineRunner {

    @Autowired
    private RoleRepository roleRepository;

    @Override
    @Transactional
    public void run(String... args) throws Exception {
        if (roleRepository.count() == 0) {
            Role adminRole = new Role(1L, "ROLE_ADMIN");
            Role userRole = new Role(2L, "ROLE_USER");
            roleRepository.save(adminRole);
            roleRepository.save(userRole);
        }
    }
}
