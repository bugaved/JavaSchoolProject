package com.tsystems.ejbbeans;

import com.tsystems.pojo.StationDTO;
import com.tsystems.pojo.StationScheduleDTO;

import javax.ejb.Local;
import java.util.List;

/**
 * Created by bugav on 05.11.2017.
 */
@Local
public interface RestClient {

    /**
     * parses json from producer with all dto, that represents station schedule
     *
     * @param stationName   - Name of required station
     * @param date     - required date
     * @return array of objects stationScheduleDTOs
     */
    StationScheduleDTO[] getAllDtos(String stationName, String date) throws Exception;
    /**
     * parses json from producer with all dto, that represents list of stations
     *quired station
     * @return array of objects stationDTOs
     */
    StationDTO[] getAllStations() throws Exception;
}
