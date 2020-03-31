package com.doggoesinthecity.doggoesapp.controller;

import com.doggoesinthecity.doggoesapp.model.LocationCredentials;
import com.doggoesinthecity.doggoesapp.service.GeolocationAPIService;
import lombok.extern.slf4j.Slf4j;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@Slf4j
public class LocationController {

    @Autowired
    GeolocationAPIService geolocationAPIService;

    @PostMapping("/location")
    public LocationCredentials checkUsersLocation() {
        var cucc = geolocationAPIService.getUsersPosition().getBody();
        log.info(cucc.toString());
        return cucc;
    }
}
