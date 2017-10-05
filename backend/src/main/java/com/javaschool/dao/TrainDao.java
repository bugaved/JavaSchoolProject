package com.javaschool.dao;

import com.javaschool.entity.Train;

import javax.persistence.TypedQuery;
import java.util.List;

public class TrainDao extends AbstractDao<Train>{
    @Override
    public void create(Train entity) {
        em.getTransaction().begin();
        em.persist(entity);
        em.getTransaction().commit();
    }

    @Override
    public List<Train> getAll() {
        em.getTransaction().begin();
        TypedQuery<Train> userTypedQuery = em.createQuery("SELECT t FROM Train t", Train.class);
        List<Train> trains = userTypedQuery.getResultList();
        em.getTransaction().commit();

        return trains;
    }

    @Override
    public void delete(Train train) {
        em.getTransaction().begin();
        em.remove(train);
        em.getTransaction().commit();
    }


    @Override
    public void deleteAllEntites() {
        TypedQuery<Train> userTypedQuery = em.createQuery("DELETE FROM Train t", Train.class);

    }
}
