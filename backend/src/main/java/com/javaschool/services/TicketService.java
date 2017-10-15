package com.javaschool.services;

import com.javaschool.dao.TicketDao;
import com.javaschool.entity.Route;
import com.javaschool.entity.Ticket;
import com.javaschool.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketService {
    @Autowired
    private TicketDao ticketDao;

    public void persistTicket(Ticket ticket) {
        ticketDao.create(ticket);
    }

    public List<Ticket> findTicketByUserAndRoute(User user, Route route) {
        return ticketDao.findTicketByUserAndRoute(user, route);

    }
}
