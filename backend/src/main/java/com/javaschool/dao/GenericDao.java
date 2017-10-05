package com.javaschool.dao;

import java.util.List;

/**
 * Created by bugav on 30.09.2017.
 */
public interface GenericDao<T> {

    void create(T entity);

    List<T> getAll();

    void delete(T entity);

    void deleteAllEntites();
}
