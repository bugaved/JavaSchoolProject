package com.tsystems.ejbbeans;


import com.tsystems.pojo.StationScheduleDTO;
import org.glassfish.jersey.client.ClientConfig;
import org.glassfish.jersey.client.ClientProperties;
import org.glassfish.jersey.filter.LoggingFilter;

import javax.annotation.PostConstruct;
import javax.ejb.Local;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by bugav on 03.11.2017.
 */
@Local
public class ScheduleRestClient {


    private WebTarget webTarget;


    public ScheduleRestClient() {
    }

    @PostConstruct
    public void init() {

        ClientConfig clientConfig = new ClientConfig()
                .property(ClientProperties.READ_TIMEOUT, 30000)
                .property(ClientProperties.CONNECT_TIMEOUT, 5000);

        webTarget = ClientBuilder
                .newClient(clientConfig)
                .register(new LoggingFilter())
                .target("http://localhost:8080/webmodule/rest/bgg/");
    }

    public List<StationScheduleDTO> getAllDtos(String stationName, String date) {

        String path = "";

        StationScheduleDTO[] dtos = webTarget
                .path(path)
                .request()
                .get()
                .readEntity(StationScheduleDTO[].class);

        return Arrays.stream(dtos).collect(Collectors.toList());
    }

}
