package com.javaschool.dao;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

/**
 * Created by bugav on 30.09.2017.
 */
public abstract class AbstractDao<T> implements GenericDao<T> {

    protected EntityManager em = Persistence.createEntityManagerFactory("javaSchoolUnitHibernate").createEntityManager();

}
