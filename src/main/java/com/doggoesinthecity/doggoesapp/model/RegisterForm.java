package com.doggoesinthecity.doggoesapp.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class RegisterForm {

    private String username;
    private String email;
    private String password;
    private String pwagain;

}
