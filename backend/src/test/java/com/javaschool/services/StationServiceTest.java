package com.javaschool.services;

import com.javaschool.dto.StationScheduleDTO;
import com.javaschool.entity.Station;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.text.ParseException;
import java.util.List;

import static org.junit.Assert.*;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath*:spring-context.xml")
public class StationServiceTest {

    @Autowired
    private StationService stationService;

    @Test
    public void findExistingStationTest() {
        Station station = stationService.findStationByName("Moscow");
        assertEquals("Moscow", station.getStationName());
    }

    @Test
    public void findNonExistingStationTest() {
        Station station = stationService.findStationByName("BFFGG");
        assertNull(station);
    }

    @Test
    public void findAllStationsTest() {
        List<Station> stations = stationService.getAllStations();
        assertTrue(!stations.isEmpty());
    }

    @Test
    public void getStationScheduleTest() throws ParseException {
        String stringDate = "2017-09-04";
        DateTimeFormatter formatter = DateTimeFormat.forPattern("yyyy-MM-dd");
        DateTime date = formatter.parseDateTime(stringDate);
        List<StationScheduleDTO> stationDTOs = stationService.getStationSchedule("Novosibirsk", date);
        assertNotNull(stationDTOs);
    }

    @Test
    public void createStationTest() {

        Station station = new Station("Test", 11.11, 22.22);
        stationService.createStation(station);

        Station testStation = stationService.findStationByName("Test");
        assertEquals("Test", testStation.getStationName());

    }

    @After
    public void cleanStation() {

        Station station = stationService.findStationByName("Test");

        if (station != null) {
            stationService.deleteStation(station);
        }
    }
}
