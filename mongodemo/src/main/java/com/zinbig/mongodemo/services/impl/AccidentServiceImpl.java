/** Este paquete contiene las implementaciones de los servicios. */
package com.zinbig.mongodemo.services.impl;

import com.zinbig.mongodemo.dtos.AccidentCommon;
import com.zinbig.mongodemo.model.Accident;
import com.zinbig.mongodemo.repositories.AccidentsRepository;
import com.zinbig.mongodemo.repositories.ElasticRepostories.AccidentsElasticRepository;
import com.zinbig.mongodemo.repositories.JpaRepositories.JpaAccidentRepository;
import com.zinbig.mongodemo.services.IAccidentService;

import java.util.Date;
import java.util.List;

import javax.inject.Inject;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AccidentServiceImpl implements IAccidentService {
    @Inject
    private JpaAccidentRepository jpaAccidentRepository;

    @Inject
    private AccidentsRepository accidentsRepository;

    @Inject
    private AccidentsElasticRepository elasticAccidentsRepository;

    @Override
    public List<Accident> listAccidentsBetweenDates(Date start, Date end) {
        return jpaAccidentRepository.findBetweenDatesAccidents(start, end);
    }

    @Override
    public Accident getAccidentById(String id) {
        return jpaAccidentRepository.findById(id).get();
    }

    @Override
    public List<Accident> listAccidentsBetweenDatesMongo(Date start, Date end) {
        return accidentsRepository.findBetweenDatesAccidents(start, end);
    }

    @Override
    public AccidentCommon findHumidityMoreCommon() {
        Pageable top = PageRequest.of(0, 1);
        return jpaAccidentRepository.findHumidityMoreCommon(top).get(0);
    }

    @Override
    public AccidentCommon findTemperatureMoreCommon() {
        Pageable top = PageRequest.of(0, 1);
        return jpaAccidentRepository.findTemperatureMoreCommon(top).get(0);
    }

    @Override
    public AccidentCommon findWeatherConditionMoreCommon() {
        Pageable top = PageRequest.of(0, 1);
        return jpaAccidentRepository.findWeatherConditionMoreCommon(top).get(0);
    }

    @Override
    public AccidentCommon findWindDirectionMoreCommon() {
        Pageable top = PageRequest.of(0, 1);
        return jpaAccidentRepository.findWindDirectionMoreCommon(top).get(0);
    }

    @Override
    public AccidentCommon findStartTimeMoreCommon() {
        Pageable top = PageRequest.of(0, 1);
        return jpaAccidentRepository.findStartTimeMoreCommon(top).get(0);
    }

    @Override
    public void saveAccidentsElastic() {
        Pageable topN;
        List<Accident> accidents;
        int total = 0;
        int totalErrors = 0;
        Long totalAccidents = jpaAccidentRepository.getTotalAccidents();
        totalAccidents = totalAccidents / 1000;
        for (int i = 0; i <= totalAccidents; i++) {
            try {
                topN = PageRequest.of(i, 1000);
                accidents = jpaAccidentRepository.findNAccidents(topN);
                elasticAccidentsRepository.saveAll(accidents);
                total = total + accidents.size();
                System.out.println("Total: " + total);
                System.out.println("Restantes:" + (totalAccidents - i) * 1000);
            } catch (Exception e) {
                totalErrors++;
                System.out.println("Error: " + e.getMessage());
            }
        }
        System.out.println("Total cargados: " + total);
        System.out.println("Total errores: " + totalErrors);
    }

}
