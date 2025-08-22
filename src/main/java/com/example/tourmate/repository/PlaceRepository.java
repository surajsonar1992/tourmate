package com.example.tourmate.repository;

import com.example.tourmate.entity.Place;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlaceRepository extends JpaRepository<Place, Long> { }
