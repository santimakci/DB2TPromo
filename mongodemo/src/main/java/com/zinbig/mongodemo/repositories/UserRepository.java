/** Este paquete contiene todas las implementaciones de los repositorios. */
package com.zinbig.mongodemo.repositories;

import com.zinbig.mongodemo.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User, String>, CustomUserRepository {

  public User findByName(String aName);

  public User findByUsername(String aUsername);

  // @Query("{name: ?1, username:?0}")
  // public User findUserX(String anUsername, String aName);
}
