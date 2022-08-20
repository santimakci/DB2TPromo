package com.zinbig.mongodemo.repositories.JpaRepositories;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.zinbig.mongodemo.dtos.AccidentCommon;
import com.zinbig.mongodemo.model.Accident;

@Repository
public interface JpaAccidentRepository extends JpaRepository<Accident, String> {

    @Query("FROM Accident a WHERE a.start_time BETWEEN ?1 AND ?2")
    public List<Accident> findBetweenDatesAccidents(Date start, Date end);

    @Query("SELECT humidity AS condition, COUNT(*) AS total FROM Accident GROUP BY condition ORDER BY total DESC")
    public List<AccidentCommon> findHumidityMoreCommon(Pageable pageable);

    @Query("SELECT temperature AS condition, COUNT(*) AS total FROM Accident GROUP BY condition ORDER BY total DESC")
    public List<AccidentCommon> findTemperatureMoreCommon(Pageable pageable);

    @Query("SELECT wind_direction AS condition, COUNT(*) AS total FROM Accident GROUP BY condition ORDER BY total DESC")
    public List<AccidentCommon> findWindDirectionMoreCommon(Pageable pageable);

    @Query("SELECT weather_condition AS condition, COUNT(*) AS total FROM Accident GROUP BY condition ORDER BY total DESC")
    public List<AccidentCommon> findWeatherConditionMoreCommon(Pageable pageable);

    @Query("SELECT start_time AS condition, COUNT(*) AS total FROM Accident GROUP BY condition ORDER BY total DESC")
    public List<AccidentCommon> findStartTimeMoreCommon(Pageable pageable);

    // @Query("SELECT AS col, COUNT(*) AS tot FROM Accident GROUP BY col ORDER BY
    // tot DESC")
}
