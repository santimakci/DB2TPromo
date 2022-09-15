package com.zinbig.app.dtos;

import org.springframework.stereotype.Component;

import com.zinbig.app.model.User;

@Component
public class DTOFactory {

  public UserDTO createUserDTO(User anUser) {
    return new UserDTO(anUser.getId(), anUser.getUsername(), anUser.getName(), anUser.version);
  }

}
