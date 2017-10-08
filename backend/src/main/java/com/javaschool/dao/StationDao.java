package com.javaschool.dao;

import com.javaschool.entity.Station;
import org.springframework.stereotype.Component;

import javax.persistence.TypedQuery;
import java.util.List;
@Component
public class StationDao extends AbstractDao<Station> {
    @Override
    public void create(Station entity) {
        em.getTransaction().begin();
        em.persist(entity);
        em.getTransaction().commit();
    }

    @Override
    public List<Station> getAll() {
        TypedQuery<Station> ticketTypedQuery = em.createQuery("SELECT stat FROM Station stat", Station.class);
        List<Station> stations = ticketTypedQuery.getResultList();
        return stations;
    }

    @Override
    public void delete(Station station) {
        em.getTransaction().begin();
        em.remove(station);
        em.getTransaction().commit();
    }


    @Override
    public void deleteAllEntites() {
        TypedQuery<Station> ticketTypedQuery = em.createQuery("DELETE FROM User u", Station.class);
        ticketTypedQuery.executeUpdate();
    }
   
}
