package com.tsystems.jsfbeans;


import com.tsystems.ejbbeans.RestClient;
import com.tsystems.pojo.StationScheduleDTO;
import lombok.Getter;
import lombok.Setter;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 * Created by bugav on 03.11.2017.
 */
@ManagedBean
@RequestScoped
@Getter
@Setter
public class ScheduleBean {

    private String stationName;
    private String date;

    @EJB
    private RestClient restClient;

    private StationScheduleDTO[] dtos;

    public void requestSchedule() throws Exception {
        dtos = restClient.getAllDtos(stationName, date);
    }

}
