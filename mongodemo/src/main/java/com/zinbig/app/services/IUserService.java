/** Este paquete contiene todas las clases e interfaces que componen la capa de servicios. */
package com.zinbig.app.services;

import java.util.List;

import com.zinbig.app.dtos.UserDTO;
import com.zinbig.app.model.User;

public interface IUserService {

  public UserDTO addUser(String aName, String anUsername, String aPassword);

  public List<User> listUsers();

  public List<User> listUsersMongo();

  public User getUserMongoByUsername(String id);

  public User getUserJpaByUsername(String id);

}
