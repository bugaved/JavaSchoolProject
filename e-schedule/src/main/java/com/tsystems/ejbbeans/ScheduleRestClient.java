package com.tsystems.ejbbeans;


import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;
import com.tsystems.pojo.StationScheduleDTO;
import org.glassfish.jersey.client.ClientConfig;
import org.glassfish.jersey.client.ClientProperties;
import org.glassfish.jersey.filter.LoggingFilter;
import org.glassfish.jersey.jackson.JacksonFeature;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import java.util.Arrays;
import java.util.List;

/**
 * Created by bugav on 03.11.2017.
 */
@Stateless
public class ScheduleRestClient implements InterfaceRestClient {


    private WebTarget webTarget;


    public ScheduleRestClient() {
    }

    @PostConstruct
    public void init() {

        ClientConfig clientConfig = new ClientConfig()
                .property(ClientProperties.READ_TIMEOUT, 30000)
                .property(ClientProperties.CONNECT_TIMEOUT, 5000)
                .register(JacksonJsonProvider.class)
                .register(JacksonFeature.class);


        webTarget = ClientBuilder
                .newClient(clientConfig)
                .register(new LoggingFilter())
                .target("http://localhost:8081/dtos?stationName=Novosibirsk&scheduleDate=2017-09-04");
}

    public List<StationScheduleDTO> getAllDtos(String stationName, String date) {

        String path = "/dtos?stationName=" + "Novosibirsk" + "&scheduleDate=" + "2017-09-04";
        try {
            String dtos = webTarget
//                    .path(path)
                    .request()
                    .header("Content-Type", MediaType.APPLICATION_JSON)
                    .get(Object.class).toString();

            return new ObjectMapper().readValue(dtos, new TypeReference<List<StationScheduleDTO>>() {
            });
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

}
