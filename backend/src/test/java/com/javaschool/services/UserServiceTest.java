package com.javaschool.services;

import com.javaschool.entity.User;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath*:spring-context.xml")
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @Test
    public void findExistUserByNameAndLastNameAndDateTest() throws ParseException {
        String stringDate = "1993-05-30";
        Date date = new SimpleDateFormat("yyyy-MM-dd").parse(stringDate);
        User user = userService.findUserByNameAndLastNameAndDate("Viacheslav", "Rostov", date);
        assertEquals("Rostov", user.getLastName());
    }

    @Test
    public void findNonExistUserByNameAndLastNameAndDateTest() throws ParseException {
        String stringDate = "1922-05-30";
        Date date = new SimpleDateFormat("yyyy-MM-dd").parse(stringDate);
        User user = userService.findUserByNameAndLastNameAndDate("Viachesl2av", "Ros4tov", date);
        assertNull(user);
    }

    @Test
    public void findExistUserByIdTest() throws ParseException {
       User user = userService.findById(10);
        assertEquals("Rostov", user.getLastName());
    }

    @Test
    public void findNonExistUserByIdTest() throws ParseException {
        User user = userService.findById(111310);
        assertNull(user);
    }

    @Test
    public void persistUserTest() throws ParseException {
        String stringDate = "1922-05-30";
        Date date2 = new SimpleDateFormat("yyyy-MM-dd").parse(stringDate);

        User user = new User("test1", "test2", "test11@22.tu", "11", date2, false);
        userService.persistUser(user);

        User testUser = userService.findUserByNameAndLastNameAndDate("test1", "test2", date2);
        assertEquals("test1", testUser.getName());

    }
    @After
    public void cleanRoute() throws ParseException {
        String stringDate = "1922-05-30";
        Date date2 = new SimpleDateFormat("yyyy-MM-dd").parse(stringDate);

        User user = userService.findUserByNameAndLastNameAndDate("test1", "test2", date2);

        if (user != null) {
            userService.deleteUser(user);
        }
    }

}
