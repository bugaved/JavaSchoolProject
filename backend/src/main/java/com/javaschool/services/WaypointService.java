package com.javaschool.services;

import com.javaschool.dao.WayPointDao;
import com.javaschool.entity.Waypoint;
import com.javaschool.jms.NotifyProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.jms.JMSException;
import java.util.List;

/**
 * Created by bugav on 20.10.2017.
 */
@Service
public class WaypointService {

    @Autowired
    private WayPointDao waypointDao;
    @Autowired
    private NotifyProducer notifyProducer;


    public List<Waypoint> getAllWaypoints(){
        return waypointDao.getAll();
    }

    public void persistWaypoint(Waypoint waypoint) {
        try {
            waypointDao.create(waypoint);
            notifyProducer.sendNotifyUpdate();
        } catch (JMSException e) {
            System.out.println("------------|Can't send message to Broker");
        }
    }
}
