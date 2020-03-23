package com.doggoesinthecity.doggoesapp.service;

import org.springframework.stereotype.Service;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

@Service
public class LogOutService {

    public void logOut(HttpServletRequest req) {
        Cookie[] cookies = req.getCookies();
        for (Cookie c : cookies) {
            if (c.getName().equals("token")) {
                c.setValue("");
            }
        }
    }
}
