package com.doggoesinthecity.doggoesapp.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@Service
public class LogOutService {

    public ResponseEntity logOut(HttpServletRequest req, HttpServletResponse response) {
        Cookie cookie = new Cookie("token", null);
        cookie.setMaxAge(60 * 60 * 24);
        cookie.setHttpOnly(true);
        cookie.setPath("/");
        response.addCookie(cookie);
        return ResponseEntity.ok("");
    }
}
