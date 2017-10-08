package com.javaschool.dao;

import java.util.List;

public interface GenericDao<T> {

    void create(T entity);

    List<T> getAll();

    void delete(T entity);

    void deleteAllEntites();
}
