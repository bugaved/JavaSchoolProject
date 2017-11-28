package com.javaschool.services;

import com.javaschool.dao.UserDao;
import com.javaschool.entity.User;
import com.javaschool.exception.UsernameNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.NoResultException;
import java.util.Date;
import java.util.List;

/**
 * Created by bugav on 01.10.2017.
 */
@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    /**
     * Finds user with requred email and password in Database.
     *
     * @param email    requred email of user.
     * @param password - required password of user
     * @return objects of type User
     */
    public List<User> findUserByEmailAndPassword(String email, String password) {

        if (email == null || password == null) {
            throw new UsernameNotFoundException();
        }
        try {
            return userDao.findUserByEmailAndPassword(email, password);
        } catch (NoResultException ex) {
            throw new UsernameNotFoundException(email, ex);
        }
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

        User user = null;

        try {
            user = userDao.findUserByNameAndLastNameAndDate(name, lastName, dateOfBirth);
        } catch (NoResultException e) {
            e.printStackTrace();
        }
        return user;
    }

    /**
     * {@inheritDoc}
     */
    public void persistUser(User user) {
        userDao.create(user);
    }

    /**
     * Returns user with requred id.
     *
     * @param id - required id
     * @return object of type User
     */
    public User findById(long id) {
        return userDao.findById(id);
    }

    /**
     * {@inheritDoc}
     */
    public void deleteUser(User user) {
        userDao.delete(user);
    }
}
