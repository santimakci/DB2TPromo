/** Este paquete contiene todas las clases e interfaces que componen la capa de servicios. */
package com.zinbig.mongodemo.services;

import java.util.List;
import java.util.Optional;

import com.zinbig.mongodemo.dtos.UserDTO;
import com.zinbig.mongodemo.model.Accident;
import com.zinbig.mongodemo.model.User;

public interface IUserService {

  public UserDTO addUser(String aName, String anUsername, String aPassword);

  public List<User> listUsers();

  public List<User> listUsersMongo();

  public Accident getAccidentById(String anId);

  public Optional<Accident> getAccidentByIdInMongo(String anId);

}
