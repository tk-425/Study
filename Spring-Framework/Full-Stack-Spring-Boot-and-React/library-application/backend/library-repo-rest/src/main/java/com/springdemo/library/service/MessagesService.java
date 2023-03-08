package com.springdemo.library.service;

import com.springdemo.library.model.Message;
import com.springdemo.library.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class MessagesService {

  private final MessageRepository messageRepository;

  @Autowired
  public MessagesService(MessageRepository messageRepository) {
    this.messageRepository = messageRepository;
  }

  public void postMessage(Message messageRequest, String userEmail) {
    Message message = new Message(messageRequest.getTitle(), messageRequest.getQuestion());
    message.setUserEmail(userEmail);

    messageRepository.save(message);
  }
}
