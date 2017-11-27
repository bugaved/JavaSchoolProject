package com.tsystems.controllers;

import com.javaschool.dto.StationScheduleDTO;
import com.javaschool.dto.TrainsStationsDTO;
import com.javaschool.entity.Station;
import com.javaschool.services.StationService;
import com.javaschool.services.TrainService;
import com.tsystems.utils.DateTimeComponent;
import com.tsystems.utils.DateTimePatterns;
import com.tsystems.utils.DistanceComponent;
import org.apache.log4j.Logger;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class MainPageController {

    private final static Logger logger = Logger.getLogger(MainPageController.class);

    @Autowired
    private TrainService trainService;

    @Autowired
    private StationService stationService;

    @Autowired
    private DateTimeComponent converter;

    @Autowired
    private DistanceComponent distanceComponent;

    @RequestMapping(value = "/findTrains", method = RequestMethod.POST)
    public String findTrainsByDate(@RequestParam(value = "stationFrom") String stationFrom,
                                   @RequestParam(value = "stationTo") String stationTo,
                                   @RequestParam(value = "travelDate") String travelDate,
                                   Model model) {

        logParamsFindTrains(stationFrom, stationTo, travelDate);

        DateTime convertedDate = converter.convertStringToDateTime(travelDate, DateTimePatterns.DATE_WITHOUT_TIME_AMERICAN.getValue());
        List<TrainsStationsDTO> trains = trainService.getTrainsByStationsAndDate(stationFrom, stationTo, convertedDate);

        trains.forEach(item -> item.setDistanсe(distanceComponent.countDistanceBetweenStations(item.getStationFrom(), item.getStationTo())));

        model.addAttribute("trains", trains);

        return "trains.jsp";
    }

    private void logParamsFindTrains(String stationFrom, String stationTo, String travelDate) {

        logger.info("------------------------------------------------");
        logger.info("|MainPageController class|, |findTrainsByDate method|, |departure station param| is:" + stationFrom);
        logger.info("|MainPageController class|, |findTrainsByDate method|, |arrival station param| is:" + stationTo);
        logger.info("|MainPageController class|, |findTrainsByDate method|, |departure date param| is:" + travelDate);

        logger.info("------------------------------------------------");

    }


    @RequestMapping("/findStationWaypoints")
    public ModelAndView getStationSchedule(@RequestParam(value = "stationName") String stationName,
                                           @RequestParam(value = "scheduleDate") String scheduleDate,
                                           Model model) {

        logParamsGetStationSchedule(stationName, scheduleDate);

        DateTime convertedDate = converter.convertStringToDateTime(scheduleDate, DateTimePatterns.DATE_WITHOUT_TIME_AMERICAN.getValue());

        List<StationScheduleDTO> schedule = stationService.getStationSchedule(stationName, convertedDate);

        ModelAndView view = new ModelAndView("schedule.jsp");
        view.addObject("schedule", schedule);

        return view;
    }

    private void logParamsGetStationSchedule(String stationName, String scheduleDate) {

        logger.info("------------------------------------------------");
        logger.info("|MainPageController class|, |getStationSchedule method|, |station name param| is:" + stationName);
        logger.info("|MainPageController class|, |getStationSchedule method|, |schedule date param| is:" + scheduleDate);

        logger.info("------------------------------------------------");

    }

}
