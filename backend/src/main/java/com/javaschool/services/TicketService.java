package com.javaschool.services;

import com.javaschool.dao.TicketDao;
import com.javaschool.entity.Ticket;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by bugav on 15.10.2017.
 */
public class TicketService {
    @Autowired
    private TicketDao ticketDao;

    public void persistTicket(Ticket ticket) {
        ticketDao.create(ticket);
    }
}
