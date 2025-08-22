package com.example.tourmate.controller;

import com.example.tourmate.entity.Place;
import com.example.tourmate.repository.PlaceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller @RequiredArgsConstructor
public class HomeController {
  private final PlaceRepository placeRepo;

  @GetMapping("/")
  public String home(Model model) {
    List<Place> places = placeRepo.findAll();
    if (places.isEmpty()) {
      placeRepo.save(Place.builder().name("Taj Mahal").city("Agra").description("Iconic ivory-white marble mausoleum.").imagePath("/images/taj.jpg").build());
      placeRepo.save(Place.builder().name("Gateway of India").city("Mumbai").description("20th-century basalt arch monument.").imagePath("/images/gateway.jpg").build());
      placeRepo.save(Place.builder().name("Hampi").city("Karnataka").description("UNESCO World Heritage ruins and temples.").imagePath("/images/hampi.jpg").build());
      places = placeRepo.findAll();
    }
    model.addAttribute("places", places);
    return "index";
  }
}
