package com.javaschool.dao;

import java.util.List;

public interface GenericDao<T> {

    /**
     * Persists the object in Database.
     * @param entity is object to persist.
     */
    void create(T entity);

    /**
     * Gets all objects of type T from database.
     * @return List of objects of type T
     */
    List<T> getAll();

    /**
     * Delete the object from Database.
     * @param entity is object to delete.
     */
    void delete(T entity);

    /**
     * Delete all objects from Database.
     */
    void deleteAllEntities();
}
