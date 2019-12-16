package com.doggoesinthecity.doggoesapp.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class RegisterForm {

    String username;
    String email;
    String password;

}
