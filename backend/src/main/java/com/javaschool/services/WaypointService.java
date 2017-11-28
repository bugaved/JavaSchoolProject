package com.javaschool.services;

import com.javaschool.dao.WayPointDao;
import com.javaschool.entity.Route;
import com.javaschool.entity.Station;
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

    /**
     * {@inheritDoc}
     */
    public List<Waypoint> getAllWaypoints() {
        return waypointDao.getAll();
    }

    /**
     * Returns waypoint with requred route and station
     *
     * @param route   - required route of waypoint
     * @param station - required station of waypoint
     * @return object of type Waypoint
     */
    public Waypoint findWaypointByRouteAndStation(Route route, Station station) {
        return waypointDao.findWaypointByRouteAndStation(route, station);
    }

    /**
     * {@inheritDoc}
     */
    public void persistWaypoint(Waypoint waypoint) {
        try {
            waypointDao.create(waypoint);
            notifyProducer.sendNotifyUpdate();
        } catch (JMSException e) {
            System.out.println("------------|Can't send message to Broker");
        }
    }

    public void updateWaypoint(Waypoint waypoint){
        waypointDao.update(waypoint);
        try {
            notifyProducer.sendNotifyUpdate();
        } catch (JMSException e) {
            System.out.println("------------|Can't send message to Broker");
        }
    }

    /**
     * {@inheritDoc}
     */
    public void deleteWaypoint(Waypoint waypoint) {
        waypointDao.delete(waypoint);
    }
}
