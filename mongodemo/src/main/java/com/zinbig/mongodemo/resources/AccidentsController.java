package com.zinbig.mongodemo.resources;

import com.zinbig.mongodemo.dtos.AccidentCommon;
import com.zinbig.mongodemo.model.Accident;
import com.zinbig.mongodemo.services.IAccidentService;

import java.util.Date;
import java.util.List;
import java.util.TimeZone;

import javax.inject.Inject;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccidentsController {

    @Inject
    private IAccidentService accidentService;

    @GetMapping("/api/accidents/")
    public ResponseEntity<List<Accident>> listAccidents(@RequestParam(required = false) String start,
            @RequestParam(required = false) String end,
            @RequestParam(required = false, defaultValue = "postgres") String name) throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");

        List<Accident> accidents;
        if (name.equals("mongo")) {
            formatter.setTimeZone(TimeZone.getTimeZone("UTC"));
            Date startD = formatter.parse(start + "T00:00:00");
            Date endD = formatter.parse(end + "T00:00:00");
            accidents = accidentService.listAccidentsBetweenDatesMongo(startD, endD);
        } else {
            Date startD = formatter.parse(start + "T00:00:00");
            Date endD = formatter.parse(end + "T00:00:00");
            accidents = accidentService.listAccidentsBetweenDates(startD, endD);
        }
        return ResponseEntity.ok(accidents);
    }

    @GetMapping("/api/accidents/commons/humidity/")
    public ResponseEntity<AccidentCommon> returnConditionMoreCommon() throws ParseException {
        AccidentCommon accident = accidentService.findHumidityMoreCommon();
        return ResponseEntity.ok(accident);
    }

    @GetMapping("/api/accidents/commons/temperature/")
    public ResponseEntity<AccidentCommon> returnTemperatureMoreCommon() throws ParseException {
        AccidentCommon accident = accidentService.findTemperatureMoreCommon();
        return ResponseEntity.ok(accident);
    }

    @GetMapping("/api/accidents/commons/whather/")
    public ResponseEntity<AccidentCommon> returnWindSpeedMoreCommon() throws ParseException {
        AccidentCommon accident = accidentService.findWeatherConditionMoreCommon();
        return ResponseEntity.ok(accident);
    }

    @GetMapping("/api/accidents/commons/winddirection/")
    public ResponseEntity<AccidentCommon> returnWindDirectionMoreCommon() throws ParseException {
        AccidentCommon accident = accidentService.findWindDirectionMoreCommon();
        return ResponseEntity.ok(accident);
    }

    @GetMapping("/api/accidents/commons/starttime/")
    public ResponseEntity<AccidentCommon> returnStartTimeMoreCommon() throws ParseException {
        AccidentCommon accident = accidentService.findStartTimeMoreCommon();
        return ResponseEntity.ok(accident);
    }

    @PostMapping("/api/accidents/elastic/")
    public ResponseEntity<String> saveAccidentsElastic() throws ParseException {
        accidentService.saveAccidentsElastic();
        return ResponseEntity.ok("Accidents saved in elastic");
    }

}
