package com.javaschool.dao;

import com.javaschool.entity.User;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.TypedQuery;
import java.util.Date;
import java.util.List;

@Component
@Transactional
public class UserDao extends AbstractDao<User> {
    /**
     * {@inheritDoc}
     */
    @Override
    public void create(User entity) {
        em.persist(entity);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<User> getAll() {
        TypedQuery<User> userTypedQuery = em.createQuery("SELECT u FROM User u", User.class);
        return userTypedQuery.getResultList();
    }

    /**
     * Finds user with requred email and password in Database.
     *
     * @param email    requred email of user.
     * @param password - required password of user
     * @return objects of type User
     */
    public List<User> findUserByEmailAndPassword(String email, String password) {
        TypedQuery<User> userTypedQuery = em.createQuery("SELECT u FROM User u WHERE u.email=?1 AND u.pass=?2", User.class);
        userTypedQuery.setParameter(1, email);
        userTypedQuery.setParameter(2, password);

        return userTypedQuery.getResultList();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void delete(User user) {
        User searchingUser = findUserByNameAndLastNameAndDate(user.getName(), user.getLastName(), user.getBirthDate());
        em.remove(searchingUser);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void deleteAllEntites() {
        em.createQuery("DELETE FROM User u", User.class);

    }

    /**
     * Returns user with requred First name, Last name and date of birth.
     *
     * @param name        - required first name of user
     * @param lastName    - required last name of user
     * @param dateOfBirth - required birth date of user
     * @return object of type User
     */
    public User findUserByNameAndLastNameAndDate(String name, String lastName, Date dateOfBirth) {

        TypedQuery<User> userTypedQuery = em.createQuery("Select u From User u  " +
                "where u.name = ?1 and u.lastName = ?2 and u.birthDate = ?3", User.class);

        userTypedQuery.setParameter(1, name);
        userTypedQuery.setParameter(2, lastName);
        userTypedQuery.setParameter(3, dateOfBirth);

        return userTypedQuery.getSingleResult();
    }
    /**
     * Returns user with requred id.
     *
     * @param id        - required id
     * @return object of type User
     */
    public User findById(long id) {
        return em.find(User.class, id);
    }
}
