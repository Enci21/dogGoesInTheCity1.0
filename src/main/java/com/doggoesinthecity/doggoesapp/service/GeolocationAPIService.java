package com.doggoesinthecity.doggoesapp.service;

import com.doggoesinthecity.doggoesapp.model.LocationCredentials;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class GeolocationAPIService {

    private String apiKey = "AIzaSyBbTzAMDUBhz_wLEP789mltsgMHYFUx8Oo";

    public ResponseEntity<LocationCredentials> getUsersPosition() {
        String apiPath = "https://www.googleapis.com/geolocation/v1/geolocate?key=" + apiKey;
        HttpEntity request = new HttpEntity(new LocationCredentials());
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<LocationCredentials> response = restTemplate.exchange(apiPath, HttpMethod.POST, request, LocationCredentials.class);
        return response;
    }

}
