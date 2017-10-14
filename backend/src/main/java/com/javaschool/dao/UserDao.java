package com.javaschool.dao;

import com.javaschool.entity.User;
import org.springframework.stereotype.Component;

import javax.persistence.TypedQuery;
import java.util.List;

@Component
public class UserDao extends AbstractDao<User> {
    /**
     * {@inheritDoc}
     */
    @Override
    public void create(User entity) {
        em.getTransaction().begin();
        em.persist(entity);
        em.getTransaction().commit();
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public List<User> getAll() {
        em.getTransaction().begin();
        TypedQuery<User> userTypedQuery = em.createQuery("SELECT u FROM User u", User.class);
        List<User> users = userTypedQuery.getResultList();
        em.getTransaction().commit();

        return users;
    }
    /**
     * Finds user with requred email and password in Database.
     * @return objects of type User
     * @param  email and password of this user.
     */
    public User findUserByNameAndLastNameAndPassword(String email, String password) {
        TypedQuery<User> userTypedQuery = em.createQuery("SELECT u FROM User u WHERE u.email=:email AND u.password=:password", User.class);
        userTypedQuery.setParameter("email", email);
        userTypedQuery.setParameter("password", password);

        em.getTransaction().begin();
        try {
            User user = userTypedQuery.getSingleResult();
            em.getTransaction().commit();
            return user;
        } catch (RuntimeException e) {
            em.getTransaction().rollback();
            throw e;
        }

    }
    /**
     * {@inheritDoc}
     */
    @Override
    public void delete(User user) {
        em.getTransaction().begin();
        em.remove(user);
        em.getTransaction().commit();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void deleteAllEntites() {
        TypedQuery<User> userTypedQuery = em.createQuery("DELETE FROM User u", User.class);

    }
}
