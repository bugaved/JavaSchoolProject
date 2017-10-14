package com.javaschool.dao;

import com.javaschool.entity.Ticket;
import org.springframework.stereotype.Component;

import javax.persistence.TypedQuery;
import java.util.List;

@Component
public class TicketDao extends AbstractDao<Ticket> {
    /**
     * {@inheritDoc}
     */
    @Override
    public void create(Ticket entity) {
        em.getTransaction().begin();
        em.persist(entity);
        em.getTransaction().commit();
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public List<Ticket> getAll() {
        TypedQuery<Ticket> ticketTypedQuery = em.createQuery("SELECT tick FROM Ticket tick", Ticket.class);
        List<Ticket> tickets = ticketTypedQuery.getResultList();
        return tickets;
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public void delete(Ticket ticket) {
        em.getTransaction().begin();
        em.remove(ticket);
        em.getTransaction().commit();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void deleteAllEntites() {
        TypedQuery<Ticket> ticketTypedQuery = em.createQuery("DELETE FROM User u", Ticket.class);
        ticketTypedQuery.executeUpdate();
    }
}
