package com.doggoesinthecity.doggoesapp.service;

import com.doggoesinthecity.doggoesapp.model.RegisterForm;
import com.doggoesinthecity.doggoesapp.model.User;
import com.doggoesinthecity.doggoesapp.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Arrays;


@Service
public class RegistrationService {

    @Autowired
    UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    public RegistrationService() {
        this.passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

    public void newUserRegistration(@RequestBody RegisterForm registerForm) throws RuntimeException {
        if (userRepository.findByEmail(registerForm.getEmail()).isPresent()) {
            throw new RuntimeException("You already registered with this email!");
        }
        if (!registerForm.getPassword().equals(registerForm.getPwagain())) {
            throw new RuntimeException("Nem egyeznek a jelszavak!");
        }

        User newUser = User.builder()
                .email(registerForm.getEmail())
                .password(passwordEncoder.encode(registerForm.getPassword()))
                .username(registerForm.getUsername())
                .roles(Arrays.asList("ROLE_USER"))
                .build();
        userRepository.save(newUser);
    }
}
