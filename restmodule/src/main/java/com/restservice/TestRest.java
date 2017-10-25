package com.restservice;

import com.pojo.User;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/bgg")
public class TestRest {

    @GET
    @Path("/{param}")
    @Produces({MediaType.APPLICATION_JSON})
    public User getTickets(@PathParam("param") String msg) {
        return new User("Denis","Vasilyev");
    }

}
