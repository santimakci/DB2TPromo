package com.zinbig.mongodemo.repositories.JpaRepositories;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.zinbig.mongodemo.dtos.AccidentCommon;
import com.zinbig.mongodemo.model.Accident;

@Repository
public interface JpaAccidentRepository extends JpaRepository<Accident, String> {

    @Query("FROM Accident a WHERE a.start_time BETWEEN ?1 AND ?2")
    public List<Accident> findBetweenDatesAccidents(Date start, Date end);

    @Query(nativeQuery = true, value = "SELECT :col AS col, COUNT(*) AS tot FROM  accident GROUP BY col ORDER BY tot DESC LIMIT 1")
    public List<AccidentCommon> returnConditionMoreCommon(@Param("col") String col);

    // @Query("SELECT AS col, COUNT(*) AS tot FROM Accident GROUP BY col ORDER BY
    // tot DESC")
}
