package com.tsystems.ejbbeans;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tsystems.pojo.StationDTO;
import com.tsystems.pojo.StationScheduleDTO;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import javax.ejb.Stateless;
import java.util.List;

/**
 * Created by bugav on 19.11.2017.
 */
@Stateless
public class RestClientImpl implements RestClient {


    @Override
    public StationScheduleDTO[] getAllDtos(String stationName, String date) throws Exception {

        String URI_DTO = "http://localhost:8081/dtos?stationName=" + stationName + "&scheduleDate=" + date;

        StationScheduleDTO[] dtos;

        // create new client
        OkHttpClient httpclient = new OkHttpClient();
        Request request = new Request.Builder().url(URI_DTO).get().build();

        try (Response response = httpclient.newCall(request).execute()) {
            // converts response into an array of dtos
            ObjectMapper mapper = new ObjectMapper();
            dtos = mapper.readValue(response.body().bytes(), StationScheduleDTO[].class);
        }

        return dtos;
    }

    @Override
    public StationDTO[] getAllStations() throws Exception {

        String URI_DTO = "http://localhost:8081/stations";

        StationDTO[] stations;

        OkHttpClient httpclient = new OkHttpClient();
        Request request = new Request.Builder().url(URI_DTO).get().build();

        try (Response response = httpclient.newCall(request).execute()) {
            // converts response into an array of dtos
            ObjectMapper mapper = new ObjectMapper();
            stations = mapper.readValue(response.body().bytes(), StationDTO[].class);
        }

        return stations;
    }

}
