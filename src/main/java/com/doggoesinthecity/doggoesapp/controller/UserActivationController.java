package com.doggoesinthecity.doggoesapp.controller;

import com.doggoesinthecity.doggoesapp.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class UserActivationController {

    @Autowired
    RegistrationService registrationService;

    @PostMapping("/activate/{userId}")
    public void userActivation(@PathVariable("userId") Long userId) {
        registrationService.setUserActive(userId);
    }
}
