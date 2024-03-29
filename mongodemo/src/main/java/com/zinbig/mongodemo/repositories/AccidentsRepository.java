/** Este paquete contiene todas las implementaciones de los repositorios. */
package com.zinbig.mongodemo.repositories;

import com.zinbig.mongodemo.model.Accident;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.data.mongodb.repository.Query;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccidentsRepository extends MongoRepository<Accident, String> {

    // @Query("{ID: '?0'}")
    Optional<Accident> findById(String id);

    // get first accident
    @Query("{}")
    List<Accident> findFirst();

    @Query("{start_time: {$gte: ?0, $lte: ?1}}")
    List<Accident> findBetweenDatesAccidents(Date start, Date end);

}
