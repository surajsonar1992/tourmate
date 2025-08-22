package com.example.tourmate.service;

import com.example.tourmate.entity.Place;
import com.example.tourmate.repository.PlaceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service @RequiredArgsConstructor
public class PlaceService {
  private final PlaceRepository repo;

  public List<Place> findAll() { return repo.findAll(); }
//  public Place findById(Long id) { return repo.findById(id).orElseThrow(); }
  public Place save(Place p) { return repo.save(p); }
  public void delete(Long id) { repo.deleteById(id); }
}
