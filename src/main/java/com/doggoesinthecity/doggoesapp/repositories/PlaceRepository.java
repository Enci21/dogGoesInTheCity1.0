package com.doggoesinthecity.doggoesapp.repositories;

import com.doggoesinthecity.doggoesapp.model.Place;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlaceRepository extends JpaRepository<Place, Long> {
}
