package com.example.tourmate.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity @Table(name = "places")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class Place {
  @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false)
  private String name;

  @Column(nullable = false)
  private String city;

  @Column(length = 1200)
  private String description;

  private String imagePath; // e.g., /images/taj.jpg
}
