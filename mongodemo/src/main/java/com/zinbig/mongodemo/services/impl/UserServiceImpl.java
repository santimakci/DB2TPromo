/** Este paquete contiene las implementaciones de los servicios. */
package com.zinbig.mongodemo.services.impl;

import com.zinbig.mongodemo.dtos.DTOFactory;
import com.zinbig.mongodemo.dtos.UserDTO;
import com.zinbig.mongodemo.model.User;
import com.zinbig.mongodemo.repositories.UserRepository;
import com.zinbig.mongodemo.repositories.JpaRepositories.JpaUserRepository;
import com.zinbig.mongodemo.services.IUserService;

import java.util.List;

import javax.inject.Inject;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserServiceImpl implements IUserService {

  @Inject
  private UserRepository userRepository;

  @Inject
  private DTOFactory dtoFactory;

  @Inject
  private JpaUserRepository jpaUserRepository;

  @Override
  public List<User> listUsers() {
    return jpaUserRepository.findAll();
  }

  public UserDTO addUser(String aName, String anUsername, String aPassword) {

    User newUser = new User(anUsername, aPassword, aName);

    this.getUserRepository().save(newUser);

    return this.getDtoFactory().createUserDTO(newUser);
  }

  public UserRepository getUserRepository() {
    return this.userRepository;
  }

  public DTOFactory getDtoFactory() {
    return this.dtoFactory;
  }
}
