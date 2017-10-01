package com.javaschool.dao;

import java.util.List;

/**
 * Created by bugav on 30.09.2017.
 */
public interface GenericDao<T> {

    void saveEntity(T entity);

    List<T> findAllEntities();

    void removeEntity(T entity);

    void deleteAllEntites();
}
