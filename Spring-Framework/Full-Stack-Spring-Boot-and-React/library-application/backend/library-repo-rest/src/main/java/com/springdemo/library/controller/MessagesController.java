package com.springdemo.library.controller;

import com.springdemo.library.model.Message;
import com.springdemo.library.service.MessagesService;
import com.springdemo.library.utils.ExtractJWT;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("http://localhost:3000")
@RestController
@RequestMapping("/api/messages")
public class MessagesController {

  private final MessagesService messagesService;
  private final String sub = "\"sub\"";

  @Autowired
  public MessagesController(MessagesService messagesService) {
    this.messagesService = messagesService;
  }

  @PostMapping("/secure/add/message")
  public void postMessage(@RequestHeader(value = "Authorization") String token,
                          @RequestBody Message messageRequest) {

    String userEmail = ExtractJWT.payloadJWTExtraction(token, sub);
    messagesService.postMessage(messageRequest, userEmail);
  }
}
