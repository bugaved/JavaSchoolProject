package com.tsystems.controllers;

import com.javaschool.dto.StationDTO;
import com.javaschool.dto.StationScheduleDTO;
import com.javaschool.entity.Station;
import com.javaschool.services.StationService;
import com.tsystems.utils.DateTimeComponent;
import com.tsystems.utils.DateTimePatterns;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ScheduleRestController {

    @Autowired
    private DateTimeComponent converter;
    @Autowired
    private StationService stationService;


    @RequestMapping(value = "/dtos", produces = "application/json")
    public List<StationScheduleDTO> getSchedule(@RequestParam("stationName") String stationName, @RequestParam("scheduleDate") String scheduleDate) {

        DateTime convertedDate = converter.convertStringToDateTime(scheduleDate, DateTimePatterns.DATE_WITHOUT_TIME_AMERICAN.getValue());

        return stationService.getStationSchedule(stationName, convertedDate);
    }

    @RequestMapping(value = "/stations", produces = "application/json")
    public List<StationDTO> getStations() {

        List<StationDTO> stationsDTO = new ArrayList<>();

        List<Station> stations = stationService.getAllStations();

        for (Station station : stations) {
            stationsDTO.add(new StationDTO(station.getStationName(), station.getLatitude(), station.getLongitude()));
        }

        return stationsDTO;
    }

}

