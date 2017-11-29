package com.javaschool.services;

import com.javaschool.dao.WayPointDao;
import com.javaschool.entity.Route;
import com.javaschool.entity.Station;
import com.javaschool.entity.Waypoint;
import com.javaschool.jms.NotifyProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.jms.JMSException;
import javax.persistence.NoResultException;
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
    @Transactional(readOnly = true)
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

        Waypoint waypoint = null;

        try {
            waypoint = waypointDao.findWaypointByRouteAndStation(route, station);
        } catch (NoResultException e) {
            System.out.println("No such waypoint!");
        }
        return waypoint;
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
    /**
     * {@inheritDoc}
     */
    public void updateWaypoint(Waypoint waypoint) {
        try {
            waypointDao.update(waypoint);
            notifyProducer.sendNotifyUpdate();
        } catch (JMSException e) {
            System.out.println("------------|Can't send message to Broker");
        }
    }

    /**
     * {@inheritDoc}
     */
    @Transactional
    public void deleteWaypoint(Waypoint waypoint) {
        waypointDao.delete(waypoint);
    }
}
