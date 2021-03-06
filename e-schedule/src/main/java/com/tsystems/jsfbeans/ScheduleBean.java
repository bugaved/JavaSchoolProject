package com.tsystems.jsfbeans;


import com.tsystems.ejbbeans.RestClient;
import com.tsystems.jms.NotifyConsumer;
import com.tsystems.pojo.StationDTO;
import com.tsystems.pojo.StationScheduleDTO;
import com.tsystems.util.DateTimeComponent;
import com.tsystems.util.DateTimePatterns;
import lombok.Getter;
import lombok.Setter;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.view.ViewScoped;
import javax.jms.JMSException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * Bean for managing schedule by rest service and connecting to message broker
 */
@ManagedBean
@ViewScoped
@Getter
@Setter
public class ScheduleBean implements Serializable {

    private String stationName;
    private Date date;
    private String stringDate;
    private StationScheduleDTO[] dtos;


    @EJB
    private RestClient restClient;

    @EJB
    private DateTimeComponent component;

    @EJB
    private NotifyConsumer receiver;

    /**
     * Returns schedule of trains arriving and departuring from station.
     */
    public void requestSchedule() throws Exception {

        dtos = restClient.getAllDtos(stationName, component.convertDateToString(date, DateTimePatterns.DATE_WITHOUT_TIME_AMERICAN.getValue()));

        StationScheduleDTO[] distinctDtos = Arrays.stream(dtos).distinct().toArray(StationScheduleDTO[]::new);

        for (StationScheduleDTO item : distinctDtos) {
            item.setConvertedArrivalTime(component.convertDateToString(item.getArrivalTime(), DateTimePatterns.DATE_WITH_TIME.getValue()));
            item.setConvertedDepartureTime(component.convertDateToString(item.getDepartureTime(), DateTimePatterns.DATE_WITH_TIME.getValue()));
        }

        dtos = distinctDtos;

    }
    /**
     * Returns all stations from first application.
     */
    public List<String> requestStations() {

        List<String> stationsNames = new ArrayList<>();

        StationDTO[] stations;

        try {
            stations = restClient.getAllStations();

            for (StationDTO station : stations) {
                stationsNames.add(station.getStationName());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return stationsNames;

    }
    /**
     * checks availability of jms message in broker and if we have it - recieves it and starts requestSchedule()
     */
    public void checkQueue() throws Exception {

        try {
            receiver.createConnection();
            requestSchedule();
            receiver.receive();
        } catch (JMSException e) {
            System.out.println("JMS Exception!");
        } catch (Exception e) {
            System.out.println("");
        } finally {
            requestSchedule();
            receiver.closeConnection();
        }

    }
}

