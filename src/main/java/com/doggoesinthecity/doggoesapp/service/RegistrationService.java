package com.doggoesinthecity.doggoesapp.service;

import com.doggoesinthecity.doggoesapp.model.RegisterForm;
import com.doggoesinthecity.doggoesapp.model.User;
import com.doggoesinthecity.doggoesapp.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class RegistrationService {

    @Autowired
    UserRepository userRepository;

    public void newUserRegistration(@RequestBody RegisterForm registerForm){

        if (userRepository.findByEmail(registerForm.getEmail()) != null){
            System.out.println("You are already registered whit this email!");
        }
        if (userRepository.findByUsername(registerForm.getUsername()) != null){
            System.out.println("This username already exist!");
        } else {
            User newUser = User.builder()
                    .email(registerForm.getEmail())
                    .password(registerForm.getPassword())
                    .username(registerForm.getUsername())
                    .build();
            userRepository.save(newUser);
        }

    }
}
