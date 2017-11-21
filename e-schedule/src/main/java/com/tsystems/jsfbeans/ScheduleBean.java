package com.tsystems.jsfbeans;


import com.tsystems.ejbbeans.RestClient;
import com.tsystems.pojo.StationScheduleDTO;
import lombok.Getter;
import lombok.Setter;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by bugav on 03.11.2017.
 */
@ManagedBean
@RequestScoped
@Getter
@Setter
public class ScheduleBean {

    private String stationName;
    private Date date;
    private String StringDate;

    @EJB
    private RestClient restClient;

    private StationScheduleDTO[] dtos;

    public void requestSchedule() throws Exception {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        StringDate = dateFormat.format(date);
        dtos = restClient.getAllDtos(stationName, StringDate);
    }

}
