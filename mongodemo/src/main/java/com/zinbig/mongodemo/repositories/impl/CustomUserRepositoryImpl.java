/** Este paquete contiene las implementaciones de los repositorios personalizados. */
package com.zinbig.mongodemo.repositories.impl;

import com.zinbig.mongodemo.repositories.CustomUserRepository;

public class CustomUserRepositoryImpl implements CustomUserRepository {

  @Override
  public int getNumberOfUsersThatHasTheSamePassword() {
    return 4;
  }
}
