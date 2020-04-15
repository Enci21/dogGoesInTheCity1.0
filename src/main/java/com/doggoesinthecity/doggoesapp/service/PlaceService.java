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
                .name(data.getName())
                .type(data.getType())
                .street(data.getStreet())
                .building(data.getBuilding())
                .city(data.getCity())
                .state(data.getState())
                .postalCode(data.getPostalCode())
                .country(data.getCountry())
                .openingHoursFrom(data.getOpeningHoursFrom())
                .openingHoursTo(data.getOpeningHoursTo())
                .number(data.getNumber())
                .build();
        placeRepository.save(place);
    }
}
