/** Este paquete contiene las implementaciones de los repositorios personalizados. */
package com.zinbig.app.repositories.impl;

import com.zinbig.app.repositories.CustomUserRepository;

public class CustomUserRepositoryImpl implements CustomUserRepository {

  @Override
  public int getNumberOfUsersThatHasTheSamePassword() {
    return 4;
  }
}
