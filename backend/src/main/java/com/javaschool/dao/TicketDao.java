package com.javaschool.dao;

import com.javaschool.model.Ticket;

import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Created by bugav on 30.09.2017.
 */
public class TicketDao extends AbstractDao<Ticket> {
    @Override
    public void saveEntity(Ticket entity) {
        em.getTransaction().begin();
        em.persist(entity);
        em.getTransaction().commit();
    }

    @Override
    public List<Ticket> findAllEntities() {
        TypedQuery<Ticket> ticketTypedQuery = em.createQuery("SELECT tick FROM Ticket tick", Ticket.class);
        List<Ticket> tickets = ticketTypedQuery.getResultList();
        return tickets;
    }

    @Override
    public void removeEntity(Ticket ticket) {
        em.getTransaction().begin();
        em.remove(ticket);
        em.getTransaction().commit();
    }


    @Override
    public void deleteAllEntites() {
        TypedQuery<Ticket> ticketTypedQuery = em.createQuery("DELETE FROM User u", Ticket.class);
        ticketTypedQuery.executeUpdate();
    }
}
