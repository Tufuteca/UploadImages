package com.tufuteca.uploadImage.components;

import com.tufuteca.uploadImage.config.SecurityConfig;
import com.tufuteca.uploadImage.model.Role;
import com.tufuteca.uploadImage.model.Users;
import com.tufuteca.uploadImage.repository.RoleRepository;
import com.tufuteca.uploadImage.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Component
public class DataInitializer implements CommandLineRunner {

    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private UsersRepository usersRepository;
    @Autowired
    private SecurityConfig securityConfig;

    @Override
    @Transactional
    public void run(String... args) throws Exception {
        if (roleRepository.count() == 0) {
            Role adminRole = new Role(1L, "ROLE_ADMIN");
            Role userRole = new Role(2L, "ROLE_USER");
            roleRepository.save(adminRole);
            roleRepository.save(userRole);
        }
        if(usersRepository.count() ==0){
            Users admin = new Users();
            admin.setLogin("admin");
            admin.setPassword(securityConfig.passwordEncoder().encode("admin"));
            Optional<Role> roleOptional = roleRepository.findById(1L);
            if (roleOptional.isPresent()) {
                Role role = roleOptional.get();
                admin.setRole(role);
                usersRepository.save(admin);
            }else{
                System.out.println("Роль не найдена");
            }
        }
    }
}
