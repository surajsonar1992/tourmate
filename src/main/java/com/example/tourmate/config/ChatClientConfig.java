package com.example.tourmate.config;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ChatClientConfig {
  @Bean
  ChatClient chatClient(ChatClient.Builder builder) {
    return builder
      .defaultSystem("You are TourMate, a concise travel assistant. Keep answers short and practical.")
      .build();
  }
}
