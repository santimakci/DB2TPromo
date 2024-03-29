package com.zinbig.mongodemo.services;

import java.util.Date;
import java.util.List;

import com.zinbig.mongodemo.dtos.AccidentCommon;
import com.zinbig.mongodemo.model.Accident;

public interface IAccidentService {

    public List<Accident> listAccidentsBetweenDates(Date start, Date end);

    public Accident getAccidentById(String anId);

    public List<Accident> listAccidentsBetweenDatesMongo(Date start, Date end);

    public AccidentCommon findHumidityMoreCommon();

    public AccidentCommon findTemperatureMoreCommon();

    public AccidentCommon findWeatherConditionMoreCommon();

    public AccidentCommon findWindDirectionMoreCommon();

    public AccidentCommon findStartTimeMoreCommon();
    // public Accident getAccidentByIdInMongo(String anId);

    public void saveAccidentsElastic();

}
