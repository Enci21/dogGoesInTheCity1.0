package com.doggoesinthecity.doggoesapp.controller;

import com.doggoesinthecity.doggoesapp.model.Place;
import com.doggoesinthecity.doggoesapp.service.PlaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class PlaceController {

    @Autowired
    PlaceService placeService;

    @PostMapping
    public void addNewPlace(@RequestBody Place data) {
        placeService.addPlace(data);
    }
}
