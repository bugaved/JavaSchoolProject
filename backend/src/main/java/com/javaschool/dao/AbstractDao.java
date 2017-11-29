package com.javaschool.dao;

import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Component
public abstract class AbstractDao<T> implements GenericDao<T> {

    @PersistenceContext
    protected EntityManager em;

}
