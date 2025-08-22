//package com.example.tourmate.controller;
//
//import org.springframework.ai.chat.client.ChatClient;
//import org.springframework.http.MediaType;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.Map;
//
//@RestController
//@RequestMapping("/api/chat")
//public class ChatRestController {
//  private final ChatClient chatClient;
//  public ChatRestController(ChatClient chatClient) { this.chatClient = chatClient; }
//
//  public record ChatMessage(String message) {}
//
//  @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
//  public Map<String, Object> chat(@RequestBody ChatMessage req) {
//    String reply = chatClient
//      .prompt()
//      .user(req.message())
//      .call()
//      .content();
//    return Map.of("reply", reply);
//  }
//
//  // Optional (not wired in JS by default): SSE streaming example
//  // Uncomment and add WebFlux if you want Flux<ServerSentEvent<String>> streaming.
//}
