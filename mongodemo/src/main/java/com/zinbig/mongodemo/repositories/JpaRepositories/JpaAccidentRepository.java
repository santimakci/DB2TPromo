package com.zinbig.mongodemo.repositories.JpaRepositories;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.zinbig.mongodemo.model.Accident;

@Repository
public interface JpaAccidentRepository extends JpaRepository<Accident, String> {

    @Query("FROM Accident a WHERE a.start_time BETWEEN ?1 AND ?2")
    public List<Accident> findBetweenDatesAccidents(Date start, Date end);

}
