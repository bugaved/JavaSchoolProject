package com.tsystems.ejbbeans;

import com.tsystems.pojo.StationScheduleDTO;

import javax.ejb.Local;
import java.util.List;

/**
 * Created by bugav on 05.11.2017.
 */
@Local
public interface RestClient {

    StationScheduleDTO[] getAllDtos(String stationName, String date) throws Exception;

}
