package com.tufuteca.uploadImage.controller;

import com.tufuteca.uploadImage.config.SecurityConfig;
import com.tufuteca.uploadImage.model.Role;
import com.tufuteca.uploadImage.model.Users;
import com.tufuteca.uploadImage.service.RoleService;
import com.tufuteca.uploadImage.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class RegistrationController {
    @Autowired
    private UsersService userService;
    @Autowired
    private SecurityConfig securityConfig;
    @Autowired
    private RoleService roleService;

    @PostMapping("/registration")
    public String registerUser(@RequestParam("login") String login,
                               @RequestParam("password") String password,
                               Model model) {
        // Логика регистрации пользователя
        var newUser = new Users();
        newUser.setLogin(login);
        newUser.setPassword(securityConfig.passwordEncoder().encode(password));
        Role role = roleService.getRoleById(2L);
        if (role != null) {
            newUser.setRole(role);
        } else {
            model.addAttribute("errorMessage", "Произошла непредвиденная ошибка. Попробуйте позже");
            return "registration";
        }
        try {
            userService.addUser(newUser);
            return "redirect:/authorization";
        } catch (DataIntegrityViolationException e) {
            System.out.println(4);
            // Обработка ошибки дублирования записи
            String errorMessage = determineErrorMessage(e);
            model.addAttribute("errorMessage", errorMessage);
            return "registration";
        }
    }

    private String determineErrorMessage(DataIntegrityViolationException e) {
        String errorMessage;
        if (e.getMessage().contains("uk_ow0gan20590jrb00upg3va2fn")) {
            errorMessage = "Пользователь с таким логином уже зарегистрирован.";
        } else{
            errorMessage = "Произшла непредвиденная ошибка. Попробуйте позже";
        }

        return errorMessage;
    }
}
