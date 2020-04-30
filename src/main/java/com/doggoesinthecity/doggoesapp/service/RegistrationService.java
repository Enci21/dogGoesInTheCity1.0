package com.doggoesinthecity.doggoesapp.service;

import com.doggoesinthecity.doggoesapp.model.Activation;
import com.doggoesinthecity.doggoesapp.model.RegisterForm;
import com.doggoesinthecity.doggoesapp.model.User;
import com.doggoesinthecity.doggoesapp.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
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

    @Autowired
    EmailService emailService;

    @Autowired
    SimpleMailMessage template;

    public RegistrationService() {
        this.passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

    public void newUserRegistration(@RequestBody RegisterForm registerForm) throws Exception {
        if (userRepository.findByEmail(registerForm.getEmail()).isPresent()) {
            throw new Exception("You already registered with this email!");
        }
        if (userRepository.findByUsername(registerForm.getUsername()).isPresent()) {
            throw new Exception("Username is already in use!");
        }
        if (!registerForm.getPassword().equals(registerForm.getPwagain())) {
            throw new Exception("Passwords don't match!");
        }


        User newUser = User.builder()
                .email(registerForm.getEmail())
                .activation(Activation.INACTIVE)
                .password(passwordEncoder.encode(registerForm.getPassword()))
                .username(registerForm.getUsername())
                .roles(Arrays.asList("ROLE_USER"))
                .build();
        userRepository.save(newUser);
        String text = String.format(
                template.getText() + newUser.getId(),
                registerForm.getUsername());

        emailService.sendSimpleMessage(registerForm.getEmail(), template.getSubject(), text);
    }

    public void setUserActive(Long userId) {
        User user = userRepository.findById(userId).get();
        user.setActivation(Activation.ACTIVE);
        userRepository.save(user);
    }
}
