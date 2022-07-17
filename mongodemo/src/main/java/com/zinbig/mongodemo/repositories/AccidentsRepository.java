/** Este paquete contiene todas las implementaciones de los repositorios. */
package com.zinbig.mongodemo.repositories;

import com.zinbig.mongodemo.model.Accident;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccidentsRepository extends MongoRepository<Accident, String> {

}
