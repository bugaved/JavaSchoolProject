package com.tsystems.controllers;

import com.javaschool.dto.StationScheduleDTO;
import com.javaschool.dto.TrainsStationsDTO;
import com.javaschool.services.StationService;
import com.javaschool.services.TrainService;
import com.tsystems.utils.DateTimeComponent;
import com.tsystems.utils.DateTimePatterns;
import com.tsystems.utils.DistanceComponent;
import com.tsystems.utils.PriceComponent;
import org.apache.log4j.Logger;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.stream.Collectors;
/**
 * Controller that rules home page
 */
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

    @Autowired
    private PriceComponent priceComponent;

    /**
     * Finds train that runs between 2 required stations in required date
     *
     * @param stationFrom   - departure station
     * @param stationTo     - arrival station
     * @param travelDate   - required date
     * @return name of trains.jsp page
     */
    @RequestMapping(value = "/findTrains", method = RequestMethod.POST)
    public String findTrainsByDate(@RequestParam(value = "stationFrom") String stationFrom,
                                   @RequestParam(value = "stationTo") String stationTo,
                                   @RequestParam(value = "travelDate") String travelDate,
                                   Model model) {

        logParamsFindTrains(stationFrom, stationTo, travelDate);

        DateTime convertedDate = converter.convertStringToDateTime(travelDate, DateTimePatterns.DATE_WITHOUT_TIME_AMERICAN.getValue());
        List<TrainsStationsDTO> trains = trainService.getTrainsByStationsAndDate(stationFrom, stationTo, convertedDate);

        trains.forEach(item -> {
            item.setDistanсe(distanceComponent.countDistanceBetweenStations(item.getStationFrom(), item.getStationTo()));
            item.setPrice(priceComponent.countPrice(item.getCode(), item.getDistanсe()));
        });

        model.addAttribute("trains", trains);

        return "trains.jsp";
    }

    /**
     * Finds all train arrivals and departures from required station in required date
     *
     * @param stationName   - name of the station
     * @param scheduleDate   - required date
     * @return name of schedule.jsp page
     */
    @RequestMapping("/findStationWaypoints")
    public String getStationSchedule(@RequestParam(value = "stationName") String stationName,
                                     @RequestParam(value = "scheduleDate") String scheduleDate,
                                     Model model) {

        logParamsGetStationSchedule(stationName, scheduleDate);

        DateTime convertedDate = converter.convertStringToDateTime(scheduleDate, DateTimePatterns.DATE_WITHOUT_TIME_AMERICAN.getValue());

        List<StationScheduleDTO> schedule = stationService.getStationSchedule(stationName, convertedDate)
                .stream().distinct().collect(Collectors.toList());

        model.addAttribute("schedule", schedule);
        return "schedule.jsp";
    }

    private void logParamsGetStationSchedule(String stationName, String scheduleDate) {

        logger.info("------------------------------------------------");
        logger.info("|MainPageController class|, |getStationSchedule method|, |station name param| is:" + stationName);
        logger.info("|MainPageController class|, |getStationSchedule method|, |schedule date param| is:" + scheduleDate);

        logger.info("------------------------------------------------");

    }

    private void logParamsFindTrains(String stationFrom, String stationTo, String travelDate) {

        logger.info("------------------------------------------------");
        logger.info("|MainPageController class|, |findTrainsByDate method|, |departure station param| is:" + stationFrom);
        logger.info("|MainPageController class|, |findTrainsByDate method|, |arrival station param| is:" + stationTo);
        logger.info("|MainPageController class|, |findTrainsByDate method|, |departure date param| is:" + travelDate);

        logger.info("------------------------------------------------");

    }

}
