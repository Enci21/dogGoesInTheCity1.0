package com.doggoesinthecity.doggoesapp;

import com.doggoesinthecity.doggoesapp.model.User;
import com.doggoesinthecity.doggoesapp.repositories.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Arrays;


@Slf4j
@Component
public class DataInitializer implements CommandLineRunner {

    private final PasswordEncoder passwordEncoder;
    private UserRepository userRepository;

    public DataInitializer(UserRepository userRepository) {
        this.userRepository = userRepository;
        this.passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

    @Override
    public void run(String... args) throws Exception {
        User hege = User.builder()
                .id(1L)
                .roles(Arrays.asList("ROLE_USER"))
                .username("Dog Goes")
                .password(passwordEncoder.encode("k"))
                .email("he@he")
                .build();
        userRepository.save(hege);
    }
}