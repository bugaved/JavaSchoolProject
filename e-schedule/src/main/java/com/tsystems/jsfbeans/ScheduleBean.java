package com.tsystems.jsfbeans;


import com.tsystems.ejbbeans.InterfaceRestClient;
import com.tsystems.ejbbeans.ScheduleRestClient;
import com.tsystems.pojo.StationScheduleDTO;
import lombok.Getter;
import lombok.Setter;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.List;

/**
 * Created by bugav on 03.11.2017.
 */
@ManagedBean
@SessionScoped
@Getter
@Setter
public class ScheduleBean {

    private String stationName;
    private String date;

    @EJB
    private InterfaceRestClient scheduleRestClient;

    private List<StationScheduleDTO> dtos;

    public void requestSchedule() {
        dtos = scheduleRestClient.getAllDtos(stationName, date);
    }

}
