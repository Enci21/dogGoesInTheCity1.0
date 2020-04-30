package com.doggoesinthecity.doggoesapp.controller;

import com.doggoesinthecity.doggoesapp.model.Place;
import com.doggoesinthecity.doggoesapp.model.Type;
import com.doggoesinthecity.doggoesapp.service.PlaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

    @GetMapping("/types")
    public List sendTypes() {
        return new ArrayList(Arrays.asList(Type.values()));
    }

    @GetMapping("/all")
    public List sendAllPlace() {
        return placeService.allPlace();
    }

}
