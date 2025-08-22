package com.example.tourmate.controller;

import com.example.tourmate.entity.Place;
import com.example.tourmate.service.PlaceService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller @RequiredArgsConstructor
@RequestMapping("/places")
public class PlaceController {

  private final PlaceService service;

  @GetMapping
  public String list(Model model) {
    model.addAttribute("places", service.findAll());
    return "places";
  }

  @GetMapping("/new")
  public String createForm(Model model) {
    model.addAttribute("place", new Place());
    return "place_form";
  }

  @PostMapping
  public String create(@ModelAttribute("place") @Valid Place place, BindingResult br, Model model) {
    if (br.hasErrors()) return "place_form";
    service.save(place);
    return "redirect:/places";
  }

  @GetMapping("/{id}/edit")
  public String editForm(@PathVariable Long id, Model model) {
//    model.addAttribute("place", service.findById(id));
    return "place_form";
  }

  @PostMapping("/{id}")
  public String update(@PathVariable Long id, @ModelAttribute("place") @Valid Place place, BindingResult br) {
    if (br.hasErrors()) return "place_form";
    place.setId(id);
    service.save(place);
    return "redirect:/places";
  }

  @PostMapping("/{id}/delete")
  public String delete(@PathVariable Long id) {
    service.delete(id);
    return "redirect:/places";
  }
}
