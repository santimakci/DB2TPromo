package com.zinbig.mongodemo.resources;

import com.zinbig.mongodemo.model.Accident;
import com.zinbig.mongodemo.services.IAccidentService;

import java.util.Date;
import java.util.List;
import java.util.TimeZone;

import javax.inject.Inject;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
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
        // print total accidents
        System.out.println("Total accidents: " + accidents.size());

        return ResponseEntity.ok(accidents);
    }

    // @GetMapping("/accidents/{id}")
    // public ResponseEntity<Accident> getAccident(@PathVariable String id,
    // @RequestParam(required = false, defaultValue = "postgres") String name) {
    // Accident accident;
    // if (name.equals("mongo")) {
    // accident = this.accidentService.getAccidentByIdInMongo(id);
    // } else {
    // accident = this.accidentService.getAccidentById(id);
    // }
    // if (accident == null) {
    // return ResponseEntity.notFound().build();
    // } else {
    // return ResponseEntity.ok(accident);
    // }
    // }

}
