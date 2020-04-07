package com.doggoesinthecity.doggoesapp.controller;

import com.doggoesinthecity.doggoesapp.service.LogOutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@CrossOrigin
@RequestMapping("/log")
public class LogOutController {

    @Autowired
    LogOutService logOutService;

    @GetMapping("/out")
    public ResponseEntity logOut(HttpServletRequest req, HttpServletResponse response) {
        logOutService.logOut(req, response);
        return ResponseEntity.ok("");
    }
}
