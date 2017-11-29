package com.javaschool.services;

import com.javaschool.dto.TrainsStationsDTO;
import com.javaschool.entity.Train;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath*:spring-context.xml")
public class TrainServiceTest {

    @Autowired
    private TrainService trainService;

    @Autowired
    private RouteService routeService;

    @Test
    public void getExistTrainsByStationsAndDateTest() {
        String stringDate = "2017-09-04";
        DateTimeFormatter formatter = DateTimeFormat.forPattern("yyyy-MM-dd");
        DateTime date = formatter.parseDateTime(stringDate);
        List<TrainsStationsDTO> trains = trainService.getTrainsByStationsAndDate("Novosibirsk", "Vladivostok", date);
        assertNotNull(trains);
    }

    @Test
    public void getNonExistTrainsByStationsAndDateTest() {
        String stringDate = "2016-09-04";
        DateTimeFormatter formatter = DateTimeFormat.forPattern("yyyy-MM-dd");
        DateTime date = formatter.parseDateTime(stringDate);
        List<TrainsStationsDTO> trains = trainService.getTrainsByStationsAndDate("Novosibirsk", "Vladivostok", date);
        assertTrue(trains.isEmpty());
    }

    @Test
    public void findExistTrainByRouteTest() {
        Train train = trainService.findTrainByRoute(routeService.findRouteByCode("MAG10"));
        assertEquals("MAG10", train.getRoute().getCode());
    }

    @Test
    public void findNonExistTrainByRouteTest() {
        Train train = trainService.findTrainByRoute(routeService.findRouteByCode("AAA11"));
        assertNull(train);
    }
    @Test
    public void getAllTrainsTest() {
        List<Train> trains = trainService.getAllTrains();
        assertNotNull(trains);
    }

}
