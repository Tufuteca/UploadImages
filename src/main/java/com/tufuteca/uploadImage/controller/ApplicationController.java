package com.tufuteca.uploadImage.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ApplicationController {

    @GetMapping("/")
    public String getIndexPage(Model model){
        return "index";
    }

    @GetMapping("/authorization")
    public String getAuthorizationPage(){
        return "authorization";
    }

    @GetMapping("/register")
    public String getRegistrationPage(){
        return "registration";
    }
}
