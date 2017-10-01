package com.javaschool.services;

import com.javaschool.dao.UserDao;
import com.javaschool.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by bugav on 01.10.2017.
 */
@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    public User findUserByNameAndLastNameAndPassword(String name, String lastname, String password) {

        if (name == null || lastname == null) {
            return null;
        }
        return userDao.findUserByNameAndLastNameAndPassword(name, lastname, password);
    }

}
