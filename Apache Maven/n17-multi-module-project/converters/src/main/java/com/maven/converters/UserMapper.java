package com.maven.converters;

import com.mavendemo.domain.UserCommand;
import com.mavendemo.entities.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {
  UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

  UserCommand userToUserCommand(User user);

  User userCommandToUser(UserCommand userCommand);
}
