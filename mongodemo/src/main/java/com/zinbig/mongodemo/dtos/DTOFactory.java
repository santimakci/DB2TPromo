/**
 * Este paquete contiene las clases que se utilizan para transferir información de las distintas
 * instancias entre capas.
 */
package com.zinbig.mongodemo.dtos;

import com.zinbig.mongodemo.model.User;
import org.springframework.stereotype.Component;

/**
 * Las instancias de esta clase se utilizan para crear DTOs en forma centralizada.
 *
 * @author Javier Bazzocco
 */
@Component
public class DTOFactory {

  /**
   * Crea un DTO que representará a un usuario.
   *
   * @param anUser es el usuario que debe ser representado.
   * @return un DTO con los datos básicos.
   */
  public UserDTO createUserDTO(User anUser) {
    return new UserDTO(anUser.getId(), anUser.getUsername(), anUser.getName(), anUser.version);
  }
}
