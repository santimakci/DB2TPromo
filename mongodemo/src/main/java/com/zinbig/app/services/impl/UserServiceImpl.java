/** Este paquete contiene las implementaciones de los servicios. */
package com.zinbig.app.services.impl;

import com.zinbig.app.dtos.DTOFactory;
import com.zinbig.app.dtos.UserDTO;
import com.zinbig.app.model.User;
import com.zinbig.app.repositories.UserRepository;
import com.zinbig.app.repositories.JpaRepositories.JpaUserRepository;
import com.zinbig.app.services.IUserService;

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

  @Override
  public List<User> listUsersMongo() {
    return userRepository.findAll();
  }

  @Override
  public User getUserJpaByUsername(String username) {
    return jpaUserRepository.findByUsername(username);
  }

  @Override
  public User getUserMongoByUsername(String username) {
    return userRepository.findByUsername(username);
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
