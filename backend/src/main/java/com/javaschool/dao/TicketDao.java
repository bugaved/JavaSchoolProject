package com.javaschool.dao;

import com.javaschool.entity.Route;
import com.javaschool.entity.Ticket;
import com.javaschool.entity.User;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.TypedQuery;
import java.util.List;

@Component
@Transactional
public class TicketDao extends AbstractDao<Ticket> {

    /**
     * {@inheritDoc}
     */
    @Override
    public void create(Ticket entity) {
        em.persist(entity);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Ticket> getAll() {
        TypedQuery<Ticket> ticketTypedQuery = em.createQuery("SELECT tick FROM Ticket tick", Ticket.class);
        return ticketTypedQuery.getResultList();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void delete(Ticket ticket) {
        Ticket searchingTicket = findTicketByUserAndRoute(ticket.getUser(), ticket.getRoute());
        em.remove(searchingTicket);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void deleteAllEntities() {
        em.createQuery("DELETE FROM User u", Ticket.class).executeUpdate();
    }

    /**
     * Returns ticket of required route, belongs to required user
     *
     * @param user  - user who have our ticket
     * @param route - route of the ticket
     * @return object of type ticket
     */
    public Ticket findTicketByUserAndRoute(User user, Route route) {

        TypedQuery<Ticket> ticketTypedQuery = em.createQuery("SELECT tick FROM Ticket tick " +
                "WHERE tick.user =?1 AND tick.route=?2", Ticket.class);

        ticketTypedQuery.setParameter(1, user);
        ticketTypedQuery.setParameter(2, route);

        return ticketTypedQuery.getSingleResult();
    }
    /**
     * Returns List of tickets belongs to required user
     *
     * @param user  - user who have our ticket
     * @return List of objects of type ticket
     */
    public List<Ticket> findTicketsByUser(User user) {

        TypedQuery<Ticket> ticketTypedQuery = em.createQuery("SELECT tick FROM Ticket tick " +
                "WHERE tick.user =?1", Ticket.class);

        ticketTypedQuery.setParameter(1, user);
        return ticketTypedQuery.getResultList();

    }
}
