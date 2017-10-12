package com.javaschool.services;

import com.javaschool.dao.UserDao;
import com.javaschool.entity.User;
import com.javaschool.exception.UsernameNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.NoResultException;

/**
 * Created by bugav on 01.10.2017.
 */
@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    public User findUserByNameAndLastNameAndPassword(String name, String lastname, String password) {

        if (name == null || lastname == null || password == null) {
            throw new UsernameNotFoundException();
        }
        try {
            return userDao.findUserByNameAndLastNameAndPassword(name, lastname, password);
        } catch (NoResultException ex) {
            throw new UsernameNotFoundException(name, ex);
        }
    }

}
