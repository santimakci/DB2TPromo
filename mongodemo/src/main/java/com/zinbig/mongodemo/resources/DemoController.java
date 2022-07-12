/** Este paquete contiene las clases que definen la api rest de la aplicación. */
package com.zinbig.mongodemo.resources;

import com.zinbig.mongodemo.dtos.UserRequestDTO;
import com.zinbig.mongodemo.model.User;
import com.zinbig.mongodemo.services.IUserService;

import java.util.List;

import javax.inject.Inject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

  @Inject
  private IUserService usersService;

  @PostMapping("/api/users")
  public void createUser(@RequestBody UserRequestDTO anUserRequestDTO) {
    this.getUsersService()
        .addUser(anUserRequestDTO.name, anUserRequestDTO.username, anUserRequestDTO.password);
  }

  @GetMapping("/")
  public String home(@RequestParam(required = false) String name) {
    List<User> users;
    if (name.equals("mongo")) {
      users = this.usersService.listUsersMongo();
    } else {
      users = this.usersService.listUsers();
    }
    return users.toString();
  }

  public IUserService getUsersService() {
    return this.usersService;
  }
}
