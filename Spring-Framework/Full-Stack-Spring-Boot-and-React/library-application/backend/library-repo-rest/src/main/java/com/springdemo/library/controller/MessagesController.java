package com.springdemo.library.controller;

import com.springdemo.library.model.Message;
import com.springdemo.library.requestmodels.AdminQuestionRequest;
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
  private final String userType = "\"userType\"";

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

  @PutMapping("/secure/admin/message")
  public void putMessage(@RequestHeader(value = "Authorization") String token,
                         @RequestBody AdminQuestionRequest adminQuestionRequest) throws Exception {

    String userEmail = ExtractJWT.payloadJWTExtraction(token, sub);
    String admin = ExtractJWT.payloadJWTExtraction(token, userType);

    // if the current user is not admin throw exception
    if (admin == null || !admin.equals("admin")) {
      throw new Exception("Administration page only.");
    }

    messagesService.putMessage(adminQuestionRequest, userEmail);
  }
}
