package com.javaschool.dao;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;


public abstract class AbstractDao<T> implements GenericDao<T> {

    protected EntityManager em = Persistence.createEntityManagerFactory("javaSchoolUnitHibernate").createEntityManager();

}
