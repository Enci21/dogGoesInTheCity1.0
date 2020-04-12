package com.doggoesinthecity.doggoesapp.service;

import com.doggoesinthecity.doggoesapp.model.Place;
import com.doggoesinthecity.doggoesapp.repositories.PlaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlaceService {

    @Autowired
    PlaceRepository placeRepository;


    public void addPlace(Place data) {

        Place place = Place.builder()
                .address(data.getAddress())
                .name(data.getName())
                .number(data.getNumber())
                .openingHours(data.getOpeningHours())
                .build();
        placeRepository.save(place);
    }
}
