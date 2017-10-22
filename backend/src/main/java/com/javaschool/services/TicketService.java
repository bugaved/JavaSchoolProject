package com.javaschool.services;

import com.javaschool.dao.TicketDao;
import com.javaschool.entity.Route;
import com.javaschool.entity.Ticket;
import com.javaschool.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.NoResultException;
import java.util.List;


@Service
public class TicketService {
    @Autowired
    private TicketDao ticketDao;

    public void persistTicket(Ticket ticket) {
        ticketDao.create(ticket);
    }

    public Ticket findTicketByUserAndRoute(User user, Route route) {

        Ticket ticket = null;

        try {
            ticket = ticketDao.findTicketByUserAndRoute(user, route);
        } catch (NoResultException e) {
            System.out.println("No such ticket found");
        }

        return ticket;
    }

    public List<Ticket> findTicketsByUser(User user){
        return ticketDao.findTicketsByUser(user);
    }

}
