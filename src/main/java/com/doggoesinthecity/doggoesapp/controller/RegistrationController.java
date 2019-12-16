package com.doggoesinthecity.doggoesapp.controller;


import com.doggoesinthecity.doggoesapp.model.RegisterForm;
import com.doggoesinthecity.doggoesapp.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegistrationController {

    @Autowired
    RegistrationService registrationService;

    @PostMapping("/registration")
    public void registrationPage(@RequestBody RegisterForm registerForm){
        registrationService.newUserRegistration(registerForm);
    }
}
