/** Este paquete contiene las clases que definen la api rest de la aplicación. */
package com.zinbig.mongodemo.resources;

import com.zinbig.mongodemo.dtos.UserRequestDTO;
import com.zinbig.mongodemo.model.User;
import com.zinbig.mongodemo.services.IUserService;
import javax.inject.Inject;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UsersController {

  @Inject
  private IUserService usersService;

  @PostMapping("/api/users")
  public void createUser(@RequestBody UserRequestDTO anUserRequestDTO) {
    this.getUsersService()
        .addUser(anUserRequestDTO.name, anUserRequestDTO.username, anUserRequestDTO.password);
  }

  @GetMapping("/api/users/{username}")
  public ResponseEntity<User> getUser(@PathVariable("username") String username,
      @RequestParam(required = false, defaultValue = "postgres") String name) {

    User user;
    if (name.equals("mongo")) {
      user = this.usersService.getUserMongoByUsername(username);
    } else {
      user = this.usersService.getUserJpaByUsername(username);
    }
    if (user == null) {
      return ResponseEntity.notFound().build();
    } else {
      return ResponseEntity.ok(user);
    }
  }

  @GetMapping("/")
  public String home(@RequestParam(required = false) String name) {
    return "Hello " + name;
  }

  public IUserService getUsersService() {
    return this.usersService;
  }
}
