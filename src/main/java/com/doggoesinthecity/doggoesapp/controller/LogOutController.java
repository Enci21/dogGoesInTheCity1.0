package com.doggoesinthecity.doggoesapp.controller;

import com.doggoesinthecity.doggoesapp.service.LogOutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@CrossOrigin
public class LogOutController {

    @Autowired
    LogOutService logOutService;

    @PutMapping("/logout")
    public void logOut(HttpServletRequest req) {
        logOutService.logOut(req);

    }
}
