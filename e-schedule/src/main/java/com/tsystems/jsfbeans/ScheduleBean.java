package com.tsystems.jsfbeans;


import com.tsystems.ejbbeans.RestClient;
import com.tsystems.jms.NotifyReceiver;
import com.tsystems.pojo.StationScheduleDTO;
import com.tsystems.util.DateTimeComponent;
import com.tsystems.util.DateTimePatterns;
import lombok.Getter;
import lombok.Setter;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import javax.jms.JMSException;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by bugav on 03.11.2017.
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
    private NotifyReceiver receiver;


    public void requestSchedule() throws Exception {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        stringDate = dateFormat.format(date);
        dtos = restClient.getAllDtos(stationName, stringDate);

        for (StationScheduleDTO item : dtos) {
            item.setConvertedRequestedTime(component.convertDateToString(item.getRequestedTime(), DateTimePatterns.DATE_WITH_TIME.getValue()));
        }

    }

    public void checkQueue() {
        try {
            receiver.createConnection();
            boolean updated = receiver.receive();
            receiver.closeConnection();

            if (updated) {
                requestSchedule();
            }

        } catch (JMSException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
