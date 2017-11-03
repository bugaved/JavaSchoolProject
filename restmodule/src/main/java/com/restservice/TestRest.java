package com.restservice;

import com.google.gson.Gson;
import com.javaschool.dto.StationScheduleDTO;
import com.pojo.User;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;


@Path("/bgg")
public class TestRest {

    @GET
    public String getUsers(@QueryParam("param1") String name, @QueryParam("param2") String lastName) {
        List<User> users = new ArrayList<User>();
        User user1 = new User(name, lastName);
        User user2 = new User("Vasya", "Koshkin");
        User user3 = new User("Alex", "Lampard");
        users.add(user1);
        users.add(user3);
        users.add(user2);

        String json = new Gson().toJson(users);

        return json;
    }

    @Path("/dtos")
    @GET
    public String getAllEmployees(@QueryParam("param1") String name, @QueryParam("param2") String lastName) {

        List<StationScheduleDTO> dtos = new ArrayList<>();

        return "";
    }

}

