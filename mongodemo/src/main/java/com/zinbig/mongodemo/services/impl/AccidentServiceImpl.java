/** Este paquete contiene las implementaciones de los servicios. */
package com.zinbig.mongodemo.services.impl;

import com.zinbig.mongodemo.dtos.AccidentCommon;
import com.zinbig.mongodemo.model.Accident;
import com.zinbig.mongodemo.repositories.AccidentsRepository;
import com.zinbig.mongodemo.repositories.JpaRepositories.JpaAccidentRepository;
import com.zinbig.mongodemo.services.IAccidentService;

import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AccidentServiceImpl implements IAccidentService {
    @Inject
    private JpaAccidentRepository jpaAccidentRepository;

    @Inject
    private AccidentsRepository accidentsRepository;

    @Autowired
    private SessionFactory sessionFactory;

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
    public Accident returnConditionMoreCommon(String column) {
        String col = "start_time";
        List<AccidentCommon> a = jpaAccidentRepository.returnConditionMoreCommon(col);
        Accident accident = new Accident();
        return accident;
    }

    // @Override
    // public Accident getAccidentByIdInMongo(String id) {
    // Accident accident = null;
    // try {
    // accident = accidentsRepository.findFirst();
    // if (accident != null) {
    // return accident;
    // } else {
    // return null;
    // }
    // } catch (Exception e) {
    // System.out.println(e.getMessage());
    // return null;
    // }
    // }
}
