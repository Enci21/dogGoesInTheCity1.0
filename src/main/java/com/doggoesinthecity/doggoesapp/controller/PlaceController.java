package com.doggoesinthecity.doggoesapp.controller;

import com.doggoesinthecity.doggoesapp.model.Place;
import com.doggoesinthecity.doggoesapp.service.PlaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/place")
public class PlaceController {

    @Autowired
    PlaceService placeService;

    @PostMapping("/new")
    public void addNewPlace(@RequestBody Place data) {
        placeService.addPlace(data);
    }
}
