package com.mavendemo.controllers;

import com.maven.converters.UserMapper;
import com.mavendemo.domain.UserCommand;
import com.mavendemo.entities.User;

public class UserController {

  User saveUser(UserCommand command) {

    // Not a real implementation (just for illustrative purposes)
    return UserMapper.INSTANCE.userCommandToUser(command);
  }
}
