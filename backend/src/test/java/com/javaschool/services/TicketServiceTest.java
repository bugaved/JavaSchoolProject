package com.javaschool.services;

import com.javaschool.entity.Route;
import com.javaschool.entity.Ticket;
import com.javaschool.entity.User;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath*:spring-context.xml")
public class TicketServiceTest {


    @Autowired
    private UserService userService;

    @Autowired
    private RouteService routeService;

    @Autowired
    private TicketService ticketService;


    @Test
    public void findExistingTicketTest() {
        User user = userService.findById(10);
        Route route = routeService.findRouteByCode("MAG10");
        Ticket ticket = ticketService.findTicketByUserAndRoute(user, route);
        assertEquals("MAG10", ticket.getRoute().getCode());
    }

    @Test
    public void findNotExistingTicketTest() {
        User user = userService.findById(11);
        Route route = routeService.findRouteByCode("UE11");
        Ticket ticket = ticketService.findTicketByUserAndRoute(user, route);
        assertNull(ticket);
    }

    @Test
    public void findTicketsByUserTest() {
        User user = userService.findById(10);
        List<Ticket> tickets = ticketService.findTicketsByUser(user);
        assertNotNull(tickets);
    }

    @Test
    public void createTicketTest() {
        User user = userService.findById(12);
        Route route = routeService.findRouteByCode("MM1");
        Ticket ticket = new Ticket(route, user);
        ticketService.persistTicket(ticket);

        Ticket testTicket = ticketService.findTicketByUserAndRoute(user, route);
        assertEquals("MM1", testTicket.getRoute().getCode());

    }

    @After
    public void cleanStation() {
        User user = userService.findById(12);
        Route route = routeService.findRouteByCode("MM1");
        Ticket ticket = ticketService.findTicketByUserAndRoute(user, route);

        if (ticket != null) {
            ticketService.deleteTicket(ticket);
        }
    }
}
