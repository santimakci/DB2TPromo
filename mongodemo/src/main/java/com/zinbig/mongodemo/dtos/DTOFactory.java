package com.zinbig.mongodemo.dtos;

import com.zinbig.mongodemo.model.User;
import org.springframework.stereotype.Component;

@Component
public class DTOFactory {

  public UserDTO createUserDTO(User anUser) {
    return new UserDTO(anUser.getId(), anUser.getUsername(), anUser.getName(), anUser.version);
  }

}
